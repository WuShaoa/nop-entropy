/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.core.model.query;

import io.nop.api.core.util.IVariableScope;
import io.nop.core.reflect.ReflectionManager;
import io.nop.core.reflect.bean.BeanTool;
import io.nop.core.reflect.bean.IBeanModel;

public class BeanVariableScope implements IVariableScope {
    private final Object bean;

    public BeanVariableScope(Object bean) {
        this.bean = bean;
    }

    public static IVariableScope makeScope(Object obj) {
        if (obj instanceof IVariableScope)
            return (IVariableScope) obj;
        return new BeanVariableScope(obj);
    }

    @Override
    public Object getValue(String name) {
        return BeanTool.instance().getProperty(bean, name);
    }

    @Override
    public Object getValueByPropPath(String propPath) {
        return BeanTool.getComplexProperty(bean, propPath);
    }

    @Override
    public boolean containsValue(String name) {
        IBeanModel beanModel = ReflectionManager.instance().getBeanModelForClass(bean.getClass());
        if (beanModel.getPropertyModel(name) != null)
            return true;
        return beanModel.isAllowExtProperty(bean, name);
    }
}
