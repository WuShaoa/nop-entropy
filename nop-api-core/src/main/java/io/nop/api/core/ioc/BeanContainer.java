/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.api.core.ioc;

import io.nop.api.core.annotations.core.GlobalInstance;
import io.nop.api.core.exceptions.NopException;

import static io.nop.api.core.ApiErrors.ERR_IOC_BEAN_CONTAINER_NOT_INITIALIZED;

@GlobalInstance
public class BeanContainer {
    static IBeanContainer _instance;

    public static boolean isInitialized() {
        return _instance != null;
    }

    public static IBeanContainer instance() {
        IBeanContainer provider = _instance;
        if (provider == null)
            throw new NopException(ERR_IOC_BEAN_CONTAINER_NOT_INITIALIZED);
        return provider;
    }

    public static void registerInstance(IBeanContainer container) {
        _instance = container;
    }

    public static <T> T getBeanByType(Class<T> beanClass) {
        return _instance.getBeanByType(beanClass);
    }

    public static Object tryGetBean(String beanName) {
        if (_instance == null)
            return null;
        if (!_instance.containsBean(beanName))
            return null;
        return _instance.getBean(beanName);
    }
}
