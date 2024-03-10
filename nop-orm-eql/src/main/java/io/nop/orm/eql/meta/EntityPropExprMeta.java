/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.orm.eql.meta;

import io.nop.dao.api.IDaoEntity;
import io.nop.dataset.binder.IDataParameterBinder;
import io.nop.orm.eql.IEqlQueryContext;
import io.nop.orm.model.IEntityPropModel;
import io.nop.orm.model.IOrmDataType;

import java.util.List;

/**
 * 多对一或者一对多关联等实体属性的读取方式是先使用idExprMeta读取主键，然后构造对象实例，再利用对象内部的加载机制去读取关联属性
 */
public class EntityPropExprMeta implements ISqlExprMeta {
    private final ISqlExprMeta idExprMeta;
    private final IEntityPropModel propModel;

    public EntityPropExprMeta(ISqlExprMeta idExprMeta, IEntityPropModel propModel) {
        this.idExprMeta = idExprMeta;
        this.propModel = propModel;
    }

    @Override
    public List<String> getColumnNames() {
        return idExprMeta.getColumnNames();
    }

    @Override
    public int getColumnCount() {
        return idExprMeta.getColumnCount();
    }

    @Override
    public List<IDataParameterBinder> getColumnBinders() {
        return idExprMeta.getColumnBinders();
    }

    @Override
    public IOrmDataType getOrmDataType() {
        return propModel;
    }

    @Override
    public Object buildValue(Object[] row, int fromIndex, IEqlQueryContext session) {
        Object id = idExprMeta.buildValue(row, fromIndex, session);
        if (id == null)
            return null;
        //  IOrmEntity entity = session.internalLoad(propModel.getOwnerEntityModel().getName(), id);
        IDaoEntity entity = session.internalLoad(propModel.getOwnerEntityModel().getName(), id);
        return entity.orm_propValueByName(propModel.getName());
    }
}