/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.cluster.lb.impl;

import io.nop.cluster.discovery.ServiceInstance;
import io.nop.cluster.lb.ILoadBalanceAdapter;

public class ServiceLoadBalanceAdapter implements ILoadBalanceAdapter<ServiceInstance> {

    @Override
    public int getWeight(ServiceInstance candidate) {
        return candidate.getWeight();
    }

    @Override
    public int getActiveCount(ServiceInstance candidate) {
        return 0;
    }
}
