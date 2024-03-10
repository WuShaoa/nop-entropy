/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.cluster.discovery;

import java.util.List;
import java.util.stream.Collectors;

public interface IServiceInstanceFilter {
    default List<ServiceInstance> filter(List<ServiceInstance> instances) {
        return instances.stream().filter(this::accept).collect(Collectors.toList());
    }

    boolean isEnabled();

    boolean accept(ServiceInstance instance);
}
