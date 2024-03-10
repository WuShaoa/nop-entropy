/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.wf.core.store;

import io.nop.core.resource.component.version.IVersionedModelStore;
import io.nop.core.resource.component.version.ResourceVersionedModelStore;
import io.nop.wf.core.model.IWorkflowModel;

public class ResourceWorkflowModelStore extends ResourceVersionedModelStore<IWorkflowModel> implements IVersionedModelStore<IWorkflowModel> {
    public ResourceWorkflowModelStore() {
        setFileType("xwf");
        setBasePath("/wf/");
    }
}
