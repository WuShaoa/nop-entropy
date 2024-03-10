/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.orm.model;

import io.nop.commons.type.StdDataType;
import io.nop.core.reflect.hook.IPropGetMissingHook;

import java.util.List;

public interface IEntityPropModel extends IPdmElement, IOrmDataType, IPropGetMissingHook {

    IEntityModel getOwnerEntityModel();

//    Object getPropValue(IOrmEntity entity);
//
//    void setPropValue(IOrmEntity entity, Object value);

    List<? extends IColumnModel> getColumns();

    StdDataType getStdDataType();

    String getJavaTypeName();

    String getName();

    String getDisplayName();

    boolean isSingleColumn();

    boolean isMandatory();

    /**
     * 是否延迟加载属性
     */
    boolean hasLazyLoadColumn();

    int getColumnPropId();

    int[] getColumnPropIds();

    String getAliasPropPath();

    OrmDataTypeKind getKind();

    default boolean isCompositePk() {
        return false;
    }

    default boolean isRelationModel() {
        return getKind().isRelation();
    }

    default boolean isToOneRelation() {
        return getKind().isToOneRelation();
    }

    /**
     * 是否是对已有复合属性的别名
     *
     * @return
     */
    default boolean isAliasModel() {
        return getKind().isAlias();
    }

    default boolean isComputeModel() {
        return getKind().isCompute();
    }

    default boolean isColumnModel() {
        return getKind().isColumn();
    }

    default boolean isToManyRelation() {
        return getKind().isToManyRelation();
    }

    default boolean isComponentModel() {
        return getKind().isComponent();
    }
}