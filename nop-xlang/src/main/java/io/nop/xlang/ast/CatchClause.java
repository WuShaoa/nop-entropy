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
import io.nop.xlang.ast._gen._CatchClause;

public class CatchClause extends _CatchClause {
    public static CatchClause valueOf(SourceLocation loc, Identifier name, NamedTypeNode type, Expression body) {
        Guard.notNull(name, "name is null");

        CatchClause node = new CatchClause();
        node.setLocation(loc);
        node.setName(name);
        node.setVarType(type);
        node.setBody(body);
        return node;
    }
}