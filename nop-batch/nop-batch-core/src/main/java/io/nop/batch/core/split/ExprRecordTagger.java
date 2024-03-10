/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.batch.core.split;

import io.nop.batch.core.BatchConstants;
import io.nop.core.lang.eval.EvalExprProvider;
import io.nop.core.lang.eval.IEvalAction;
import io.nop.core.lang.eval.IEvalScope;
import io.nop.dataset.record.IRecordTagger;

import java.util.Collection;
import java.util.Collections;

public class ExprRecordTagger<T, C> implements IRecordTagger<T, C> {
    private final IEvalAction expr;

    public ExprRecordTagger(IEvalAction expr) {
        this.expr = expr;
    }

    @Override
    public Collection<String> getTags(T record, C context) {
        IEvalScope scope = EvalExprProvider.newEvalScope();
        scope.setLocalValue(null, BatchConstants.VAR_RECORD, record);
        Object value = expr.invoke(scope);
        if (value == null)
            return null;

        if (value instanceof Collection)
            return ((Collection<String>) value);

        return Collections.singletonList(value.toString());
    }
}
