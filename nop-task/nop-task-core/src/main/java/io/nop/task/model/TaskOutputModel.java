/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.task.model;

import io.nop.core.lang.eval.IEvalAction;
import io.nop.task.model._gen._TaskOutputModel;
import io.nop.xlang.xdsl.action.IActionOutputModel;

public class TaskOutputModel extends _TaskOutputModel implements IActionOutputModel {
    public TaskOutputModel() {

    }

    public IEvalAction getValueExpr() {
        IEvalAction source = getSource();
        if (source == null) {
            source = getValue();
        }
        return source;
    }
}
