/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.core.lang.eval.predicate;

import io.nop.core.context.IEvalContext;
import io.nop.core.lang.eval.IEvalPredicate;

public class NotEvalPredicate implements IEvalPredicate {
    private final IEvalPredicate predicate;

    public NotEvalPredicate(IEvalPredicate predicate) {
        this.predicate = predicate;
    }

    @Override
    public boolean passConditions(IEvalContext ctx) {
        return !predicate.passConditions(ctx);
    }

    @Override
    public IEvalPredicate not() {
        return predicate;
    }
}
