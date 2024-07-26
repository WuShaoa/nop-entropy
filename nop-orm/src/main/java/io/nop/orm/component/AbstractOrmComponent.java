/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.orm.component;

import io.nop.api.core.ioc.IBeanProvider;
import io.nop.core.reflect.bean.BeanTool;
import io.nop.orm.IOrmComponent;
import io.nop.orm.IOrmEntity;
import io.nop.orm.exceptions.OrmException;

import java.util.Map;

import static io.nop.orm.OrmErrors.ARG_COMPONENT_CLASS;
import static io.nop.orm.OrmErrors.ARG_PROP_NAME;
import static io.nop.orm.model.OrmModelErrors.ERR_ORM_MODEL_UNKNOWN_COMPONENT_PROP;

public abstract class AbstractOrmComponent implements IOrmComponent {
    private IOrmEntity owner;
    private Map<String, Integer> propToColPropIds;

    public IOrmEntity orm_owner() {
        return owner;
    }

    protected Object internalGetPropValue(String propName) {
        return owner.orm_propValue(getColPropId(propName));
    }

    protected int getColPropId(String propName) {
        Integer propId = propToColPropIds.get(propName);
        if (propId == null)
            throw new OrmException(ERR_ORM_MODEL_UNKNOWN_COMPONENT_PROP)
                    .param(ARG_COMPONENT_CLASS, getClass().getName()).param(ARG_PROP_NAME, propName);
        return propId;
    }

    protected boolean orm_propDirty(int propId) {
        return owner.orm_propDirty(propId);
    }

    protected void internalSetPropValue(String propName, Object value) {
        owner.orm_propValue(getColPropId(propName), value);
    }

    protected void markDirty() {
        IOrmEntity owner = orm_owner();
        if (owner != null)
            owner.orm_extDirty(true);
    }

    @Override
    public void reset() {

    }

    protected IBeanProvider getBeanProvider() {
        IOrmEntity entity = orm_owner();
        return entity.orm_enhancer().getBeanProvider();
    }

    protected Object tryGetBean(String beanName) {
        IBeanProvider beanProvider = getBeanProvider();
        if (beanProvider == null)
            return null;
        if (beanProvider.containsBean(beanName)) {
            return beanProvider.getBean(beanName);
        }
        return null;
    }

    protected Object getBean(String beanName) {
        return getBeanProvider().getBean(beanName);
    }

    @Override
    public Object orm_propValueByName(String propName) {
        return BeanTool.instance().getProperty(this, propName);
    }

    @Override
    public void orm_propValueByName(String propName, Object value) {
        BeanTool.instance().setProperty(this, propName, value);
    }

    @Override
    public void bindToEntity(IOrmEntity owner, Map<String, Integer> propToColPropIds) {
        this.owner = owner;
        this.propToColPropIds = propToColPropIds;
    }

    @Override
    public void flushToEntity() {

    }
}