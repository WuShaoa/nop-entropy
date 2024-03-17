/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.task.step;

import io.nop.api.core.annotations.data.DataBean;
import io.nop.api.core.exceptions.NopException;
import io.nop.commons.util.retry.IRetryPolicy;
import io.nop.core.context.IEvalContext;
import io.nop.task.ITaskRuntime;
import io.nop.task.ITaskStep;
import io.nop.task.ITaskStepState;
import io.nop.task.TaskStepResult;

import static io.nop.task.TaskErrors.ARG_STEP_NAME;
import static io.nop.task.TaskErrors.ERR_TASK_RETRY_TIMES_EXCEED_LIMIT;

public class RetryTaskStep extends AbstractTaskStep {
    private IRetryPolicy<IEvalContext> retryPolicy;
    private ITaskStep body;

    public IRetryPolicy<IEvalContext> getRetryPolicy() {
        return retryPolicy;
    }

    public void setRetryPolicy(IRetryPolicy<IEvalContext> retryPolicy) {
        this.retryPolicy = retryPolicy;
    }

    public ITaskStep getBody() {
        return body;
    }

    public void setBody(ITaskStep body) {
        this.body = body;
    }

    @DataBean
    public static class RetryStateBean {
        int retryTimes;
        long lastRetryTime;

        public int getRetryTimes() {
            return retryTimes;
        }

        public void setRetryTimes(int retryTimes) {
            this.retryTimes = retryTimes;
        }

        public long getLastRetryTime() {
            return lastRetryTime;
        }

        public void setLastRetryTime(long lastRetryTime) {
            this.lastRetryTime = lastRetryTime;
        }

        public void incRetryTimes() {
            retryTimes++;
        }
    }

    @Override
    protected void initStepState(ITaskStepState state, ITaskRuntime context) {
        super.initStepState(state, context);
        RetryStateBean stateBean = new RetryStateBean();
        state.setStateBean(stateBean);
    }

    @Override
    protected TaskStepResult doExecute(ITaskStepState state, ITaskRuntime taskRt) {
        RetryStateBean stateBean = state.getStateBean(RetryStateBean.class);

        do {
            long delay = retryPolicy.getRetryDelay(null, stateBean.getRetryTimes(), state.getEvalScope());
            if (delay < 0) {
                Throwable e = state.exception();
                if (e == null)
                    e = new NopException(ERR_TASK_RETRY_TIMES_EXCEED_LIMIT)
                            .source(this)
                            .param(ARG_STEP_NAME, getStepName());
                throw NopException.adapt(e);
            }

            TaskStepResult result = body.execute(state.getRunId(), state, null, taskRt);
            if (result.isAsync()) {
                return result.thenCompose((v, err) -> doRetry(v, err, state, taskRt));
            } else {
                stateBean.incRetryTimes();
                saveState(state, taskRt);
            }
        } while (true);
    }

    Object doRetry(Object value, Throwable err, ITaskStepState state, ITaskRuntime taskRt) {
        if (err != null) {
            RetryStateBean stateBean = state.getStateBean(RetryStateBean.class);
            stateBean.incRetryTimes();
            saveState(state, taskRt);
            return doExecute(state, taskRt);
        } else {
            return TaskStepResult.of(getNextStepId(), value);
        }
    }
}
