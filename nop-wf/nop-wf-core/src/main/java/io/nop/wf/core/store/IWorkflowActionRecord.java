/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.wf.core.store;

import io.nop.wf.api.actor.IWfActor;

import java.sql.Timestamp;

public interface IWorkflowActionRecord {
    String getSid();

    String getWfId();

    String getStepId();

    String getActionName();

    String getDisplayName();

    Timestamp getExecTime();

    String getCallerId();

    String getCallerName();

    void setCaller(IWfActor caller);

    String getOpinion();
}
