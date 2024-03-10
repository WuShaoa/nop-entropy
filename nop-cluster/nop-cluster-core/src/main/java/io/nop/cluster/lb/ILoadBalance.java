/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.cluster.lb;

import java.util.List;

public interface ILoadBalance<T, R> {
    /**
     * 根据请求信息，从备选条目中选择一个
     */
    T choose(List<T> candidates, R request);
}