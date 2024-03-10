/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.graphql.core.ast;

import io.nop.api.core.util.INeedInit;
import io.nop.graphql.core.ast._gen._GraphQLDefinition;

public abstract class GraphQLDefinition extends _GraphQLDefinition implements INeedInit {
    public void init() {
    }

    public boolean isObjectDefinition() {
        return getASTKind() == GraphQLASTKind.GraphQLObjectDefinition;
    }

    public boolean isEnumDefinition() {
        return getASTKind() == GraphQLASTKind.GraphQLEnumDefinition;
    }
}