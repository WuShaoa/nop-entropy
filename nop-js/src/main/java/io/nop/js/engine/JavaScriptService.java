/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.js.engine;

import io.nop.api.core.config.IConfigRefreshable;
import io.nop.commons.concurrent.executor.DefaultThreadPoolExecutor;
import io.nop.commons.functional.IAsyncFunctionService;
import io.nop.commons.service.LifeCycleSupport;
import io.nop.core.resource.IResourceTextLoader;
import io.nop.js.JsConstants;

import java.util.concurrent.CompletableFuture;

public class JavaScriptService extends LifeCycleSupport implements IConfigRefreshable, IAsyncFunctionService {
    private String initScriptPath;
    private int workerCount = 5;
    private volatile JavaScriptWorker[] workers; //NOSONAR
    private DefaultThreadPoolExecutor executor;
    private IResourceTextLoader jsLibLoader;

    public void setWorkerCount(int workerCount) {
        this.workerCount = workerCount;
    }

    public void setInitScriptPath(String initScriptPath) {
        this.initScriptPath = initScriptPath;
    }

    public void setJsLibLoader(IResourceTextLoader jsLibLoader) {
        this.jsLibLoader = jsLibLoader;
    }

    @Override
    protected void doStart() {
        executor = DefaultThreadPoolExecutor.newExecutor("javascript-engine", -1, -1);

        workers = new JavaScriptWorker[workerCount];
        for (int i = 0; i < workerCount; i++) {
            JavaScriptWorker worker = newWorker();
            workers[i] = worker;
            executor.execute(worker);
        }
    }

    public void reinitWorkers() {
        JavaScriptWorker[] workers = this.workers;
        for (int i = 0; i < workers.length; i++) {
            workers[i].schedule(JsConstants.FUNC_REINIT);
        }
    }

    private JavaScriptWorker getCurrentWorker() {
        Thread currentThread = Thread.currentThread();
        JavaScriptWorker[] workers = this.workers;
        for (int i = 0; i < workers.length; i++) {
            if (workers[i].getExecuteThread() == currentThread)
                return workers[i];
        }
        return null;
    }

    public CompletableFuture<Object> invokeAsync(String funcName, Object... args) {
        if (funcName.equals(JsConstants.FUNC_REINIT_WORKERS)) {
            this.reinitWorkers();
            return CompletableFuture.completedFuture(null);
        }

        // 嵌套调用
        JavaScriptWorker currentWorker = getCurrentWorker();
        if (currentWorker != null)
            return currentWorker.invokeFunction(funcName, args);

        JavaScriptWorker[] workers = this.workers;
        int leastWaiting = Integer.MAX_VALUE;
        int leastIndex = -1;

        for (int i = 0, n = workers.length; i < n; i++) {
            int waiting = workers[i].getWaitingTasks();
            if (waiting == 0) {
                return workers[i].schedule(funcName, args);
            }
            if (waiting < leastWaiting) {
                leastIndex = i;
                leastWaiting = waiting;
            }
        }
        return workers[leastIndex].schedule(funcName, args);
    }

    @Override
    public void refreshConfig() {
        JavaScriptWorker[] workers = this.workers;
        int workerCount = this.workerCount;
        if (workers.length < workerCount) {
            JavaScriptWorker[] newWorkers = new JavaScriptWorker[workerCount];
            System.arraycopy(workers, 0, newWorkers, 0, workers.length);
            for (int i = workers.length; i < workerCount; i++) {
                JavaScriptWorker worker = new JavaScriptWorker();
                workers[i] = worker;
                executor.execute(worker);
            }
            this.workers = newWorkers;
        } else if (workers.length > workerCount) {
            JavaScriptWorker[] newWorkers = new JavaScriptWorker[workerCount];
            System.arraycopy(workers, 0, newWorkers, 0, workerCount);
            this.workers = newWorkers;

            for (int i = workerCount; i < workers.length; i++) {
                workers[i].shutdownGracefully();
            }
        }
    }

    private JavaScriptWorker newWorker() {
        JavaScriptWorker worker = new JavaScriptWorker();
        worker.setInitScriptPath(initScriptPath);
        worker.setJsLibLoader(jsLibLoader);
        return worker;
    }

    @Override
    public void doStop() {
        JavaScriptWorker[] workers = this.workers;
        if (workers != null) {
            for (JavaScriptWorker worker : workers) {
                if (worker != null) worker.close();
            }
        }
        if (executor != null) executor.destroy();
    }
}