/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.core.model.table.tree;

import java.util.List;

/**
 * 根据当前节点展开得到子节点集合
 *
 * @param <T>
 */
public interface ITreeCellExpander<T> {
    List<TreeCell> buildChildren(TreeCell cell);
}