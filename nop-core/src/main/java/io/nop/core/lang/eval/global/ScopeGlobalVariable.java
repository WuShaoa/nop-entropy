/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.core.lang.eval.global;

import io.nop.api.core.annotations.core.Description;
import io.nop.api.core.annotations.core.Locale;
import io.nop.core.lang.eval.EvalRuntime;
import io.nop.core.lang.eval.IEvalScope;
import io.nop.core.reflect.ReflectionManager;
import io.nop.core.type.IGenericType;

@Locale("zh-CN")
@Description("当前scope对象")
public class ScopeGlobalVariable implements IGlobalVariableDefinition {
    private final IGenericType type = ReflectionManager.instance().buildRawType(IEvalScope.class);

    @Override
    public IGenericType getResolvedType() {
        return type;
    }

    @Override
    public Object getValue(EvalRuntime rt) {
        return rt.getScope();
    }
}