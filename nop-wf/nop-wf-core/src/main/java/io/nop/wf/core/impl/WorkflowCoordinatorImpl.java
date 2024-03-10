/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.wf.core.impl;

import io.nop.core.context.IServiceContext;
import io.nop.wf.api.WfReference;
import io.nop.wf.api.WfStepReference;
import io.nop.wf.core.IWorkflow;
import io.nop.wf.core.IWorkflowCoordinator;
import io.nop.wf.core.IWorkflowManager;
import io.nop.wf.core.IWorkflowStep;
import io.nop.wf.core.store.IWorkflowRecord;

import java.util.HashMap;
import java.util.Map;

public class WorkflowCoordinatorImpl implements IWorkflowCoordinator {

    private final IWorkflowManager wfManager;

    public WorkflowCoordinatorImpl(IWorkflowManager wfManager) {
        this.wfManager = wfManager;
    }

    @Override
    public WfReference startSubFlow(String wfName, Long wfVersion, WfStepReference parentStep,
                                    Map<String, Object> args, IServiceContext ctx) {
        if (args == null)
            args = new HashMap<>();

        IWorkflow wf = wfManager.newWorkflow(wfName, wfVersion);
        IWorkflowRecord record = wf.getRecord();
        record.setParentStepId(parentStep.getStepId());
        record.setParentWfName(parentStep.getWfName());
        record.setParentWfVersion(parentStep.getWfVersion());
        record.setParentWfId(parentStep.getWfId());

        wf.start(args, ctx);

        return wf.getWfReference();
    }

    @Override
    public void endSubFlow(WfReference wfRef, int status, WfStepReference parentStep, Map<String, Object> results,
                           IServiceContext ctx) {
        IWorkflow parentWf = wfManager.getWorkflow(parentStep.getWfId());
//        if (parentWf == null)
//            throw new NopException(ERR_WF_MISSING_PARENT_WF)
//                    .param(ARG_WF_NAME, parentStep.getWfName())
//                    .param(ARG_WF_VERSION, parentStep.getWfId())
//                    .param(ARG_WF_ID, parentStep.getWfId()).param(ARG_PARENT_STEP_ID, parentStep.getStepId());

        IWorkflowStep step = parentWf.getStepById(parentStep.getStepId());
        step.notifySubFlowEnd(status, results, ctx);
    }
}
