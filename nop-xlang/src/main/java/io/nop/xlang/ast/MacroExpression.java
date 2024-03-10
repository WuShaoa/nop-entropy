/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.xlang.ast;

import io.nop.api.core.util.Guard;
import io.nop.api.core.util.SourceLocation;
import io.nop.xlang.ast._gen._MacroExpression;

public class MacroExpression extends _MacroExpression {
    public static MacroExpression valueOf(SourceLocation loc, Expression expr) {
        Guard.notNull(expr, "expr is null");
        MacroExpression node = new MacroExpression();
        node.setLocation(loc);
        node.setExpr(expr);
        return node;
    }
}