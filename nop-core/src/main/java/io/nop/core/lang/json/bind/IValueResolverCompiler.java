/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.core.lang.json.bind;

import io.nop.api.core.util.SourceLocation;

public interface IValueResolverCompiler {
    char BIND_EXPR_SYMBOL = '@';
    String PREFIX_KEY = "@prefix";

    IValueResolver compile(SourceLocation loc, Object value, ValueResolverCompileOptions options);
}