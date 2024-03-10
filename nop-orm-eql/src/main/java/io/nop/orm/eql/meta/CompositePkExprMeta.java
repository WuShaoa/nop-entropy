/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.orm.eql.meta;

import io.nop.dataset.binder.IDataParameterBinder;
import io.nop.orm.eql.IEqlQueryContext;
import io.nop.orm.model.IEntityPropModel;
import io.nop.orm.model.IOrmDataType;

import java.util.List;

public class CompositePkExprMeta implements ISqlExprMeta {
    private final List<IDataParameterBinder> columnBinders;
    private final IEntityPropModel propModel;
    private final List<String> columnNames;

    public CompositePkExprMeta(List<String> columnNames, List<IDataParameterBinder> columnBinders,
                               IEntityPropModel propModel) {
        this.columnBinders = columnBinders;
        this.propModel = propModel;
        this.columnNames = columnNames;
    }

    @Override
    public List<String> getColumnNames() {
        return columnNames;
    }

    @Override
    public int getColumnCount() {
        return columnBinders.size();
    }

    @Override
    public List<IDataParameterBinder> getColumnBinders() {
        return columnBinders;
    }

    @Override
    public IOrmDataType getOrmDataType() {
        return propModel;
    }

    @Override
    public Object buildValue(Object[] row, int fromIndex, IEqlQueryContext session) {
        Object[] id = new Object[getColumnCount()];
        System.arraycopy(row, fromIndex, id, 0, id.length);
        return session.castId(propModel.getOwnerEntityModel(), id);
    }
}
