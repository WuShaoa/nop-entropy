/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.task.step;

import io.nop.api.core.exceptions.NopException;
import io.nop.task.ITaskRuntime;
import io.nop.task.ITaskStep;
import io.nop.task.ITaskStepState;
import io.nop.task.TaskStepResult;

public class TryTaskStep extends AbstractTaskStep {
    private ITaskStep body;
    private ITaskStep finallyAction;
    private ITaskStep catchAction;

    public ITaskStep getBody() {
        return body;
    }

    public void setBody(ITaskStep body) {
        this.body = body;
    }

    public ITaskStep getFinallyAction() {
        return finallyAction;
    }

    public void setFinallyAction(ITaskStep finallyAction) {
        this.finallyAction = finallyAction;
    }

    public ITaskStep getCatchAction() {
        return catchAction;
    }

    public void setCatchAction(ITaskStep catchAction) {
        this.catchAction = catchAction;
    }

    @Override
    protected TaskStepResult doExecute(ITaskStepState state, ITaskRuntime taskRt) {

        Integer pc = (Integer) state.getStateBean();
        if (pc == null)
            pc = 0;

        // 0: try, 1: catch 2: success

        boolean async = false;

        TaskStepResult result = state.result();
        if (result == null)
            result = TaskStepResult.CONTINUE;

        if (pc == 0) {
            try {
                result = body.execute(state.getRunId(), state, null, taskRt);
                if (result.isAsync()) {
                    async = true;
                    int pcParam = pc;
                    result = result.thenCompose((v, e) -> {
                        return nextStep(v, e, pcParam, state, taskRt);
                    });
                }
                return result;
            } catch (Exception e) {
                result = nextStep(null, e, pc, state, taskRt);
                if (result.isAsync()) {
                    async = true;
                    int pcParam = pc;
                    result = result.thenCompose((v, err) -> {
                        return nextStep(v, err, pcParam, state, taskRt);
                    });
                }
            } finally {
                if (!async) {
                    result = runFinally(result, state, taskRt);
                }
            }
        } else if (pc == 1) {
            try {
                result = nextStep(null, state.exception(), pc, state, taskRt);
                if (result.isAsync()) {
                    async = true;
                    int pcParam = pc;
                    result = result.thenCompose((v, err) -> {
                        return nextStep(v, err, pcParam, state, taskRt);
                    });
                }
            } finally {
                if (!async) {
                    result = runFinally(result, state, taskRt);
                }
            }
        } else if (pc == 2) {
            result = runFinally(result, state, taskRt);
        } else {
            Throwable err = state.exception();
            if (err != null)
                throw NopException.adapt(err);
            return TaskStepResult.of(null, state.getResultValue());
        }
        return result;
    }

    TaskStepResult runFinally(TaskStepResult result, ITaskStepState state, ITaskRuntime context) {
        if (finallyAction == null)
            return result;

        TaskStepResult finalResult = finallyAction.execute(state.getRunId(), state, null, context);
        if (finalResult.isAsync()) {
            finalResult = finalResult.thenApply(v -> {
                state.setStateBean(3);
                return state.getResultValue();
            });
        }
        return finalResult;
    }

    TaskStepResult nextStep(Object result, Throwable e, int pc, ITaskStepState state, ITaskRuntime context) {
        pc++;
        if (pc == 1) {
            if (e == null) {
                pc++;
            } else {
                state.exception(e);
                if (catchAction == null) {
                    pc++;
                }
            }
        }
        state.setStateBean(pc);
        // 已经结束
        if (pc >= 3) {
            Throwable err = state.exception();
            if (err != null)
                throw NopException.adapt(err);
            return TaskStepResult.of(null, state.getResultValue());
        }

        saveState(state, context);
        return doExecute(state, context);
    }
}