/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.core.model.tree;

import static io.nop.core.model.tree.TreeVisitResult.CONTINUE;

public interface ITreeStateVisitor<S extends TreeVisitState<?>> {
    default TreeVisitResult beginNodeState(S state) {
        return CONTINUE;
    }

    default TreeVisitResult endNodeState(S state) {
        return CONTINUE;
    }
}