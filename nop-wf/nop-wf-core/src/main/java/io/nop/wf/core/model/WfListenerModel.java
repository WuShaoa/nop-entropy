/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.wf.core.model;

import io.nop.commons.util.StringHelper;
import io.nop.wf.core.model._gen._WfListenerModel;

public class WfListenerModel extends _WfListenerModel {
    public WfListenerModel() {

    }

    public boolean matchPattern(String event) {
        return StringHelper.matchSimplePattern(event, getEventPattern());
    }
}
