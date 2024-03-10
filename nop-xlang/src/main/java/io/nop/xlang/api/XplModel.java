/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.xlang.api;

import io.nop.api.core.annotations.data.ImmutableBean;
import io.nop.api.core.util.IComponentModel;
import io.nop.core.lang.eval.IExecutableExpression;

@ImmutableBean
public class XplModel extends ExprEvalAction implements IComponentModel {
    public XplModel(IExecutableExpression expr) {
        super(expr);
    }
}
