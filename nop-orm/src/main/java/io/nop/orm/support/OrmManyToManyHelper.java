/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.orm.support;

import io.nop.commons.type.StdDataType;
import io.nop.commons.util.StringHelper;
import io.nop.orm.OrmConstants;
import io.nop.orm.model.IColumnModel;
import io.nop.orm.model.IEntityJoinConditionModel;
import io.nop.orm.model.IEntityModel;
import io.nop.orm.model.IEntityRelationModel;
import io.nop.orm.model.OrmModelConstants;

public class OrmManyToManyHelper {

    public static class RefPropInfo {
        private final IEntityRelationModel relatedObjProp;

        public RefPropInfo(IEntityRelationModel relatedObjProp) {
            this.relatedObjProp = relatedObjProp;
        }

        public IEntityRelationModel getRelatedObjPropModel() {
            return relatedObjProp;
        }

        private String getConstantName(String propName) {
            return getRelatedEntityName() + ".PROP_NAME_" + propName;
        }

        public String getObjPropNameConst() {
            return relatedObjProp.getOwnerEntityModel().getName() + ".PROP_NAME_" + relatedObjProp.getName();
        }

        public String getDispColNameConst() {
            return getConstantName(getDispColName());
        }

        public String getColNameConst() {
            IColumnModel col = relatedObjProp.getSingleJoinColumn();
            return relatedObjProp.getOwnerEntityModel().getName() + ".PROP_NAME_" + col.getName();
        }

        public String getDispColName() {
            IEntityModel entityModel = relatedObjProp.getRefEntityModel();
            IColumnModel colModel = entityModel.getColumnByTag(OrmConstants.TAG_DISP);
            return colModel == null ? null : colModel.getName();
        }

        public String getRelatedEntityName() {
            return relatedObjProp.getRefEntityName();
        }

        public IEntityModel getRelatedEntityModel() {
            return relatedObjProp.getRefEntityModel();
        }

        public String getRelatedDisplayName() {
            return relatedObjProp.getDisplayName();
        }

        public String getBizObjName() {
            return StringHelper.simpleClassName(getRelatedEntityName());
        }

        public String getRelatedEnDisplayName() {
            return (String) relatedObjProp.prop_get("i18n-en:displayName");
        }

        public String getRelatedObjPropName() {
            return "related" + StringHelper.capitalize(relatedObjProp.getName());
        }

        public String getRelatedObjListPropName() {
            return "related" + StringHelper.capitalize(relatedObjProp.getName()) + "List";
        }

        public String getRelatedColPropName() {
            IColumnModel colModel = relatedObjProp.getSingleJoinColumn();
            return colModel == null ? null : "related" + StringHelper.capitalize(colModel.getName());
        }

        public String getRelatedObjPropName_label() {
            if (getDispColName() == null)
                return null;
            String name = getRelatedObjPropName();
            return name == null ? null : name + "_label";
        }

        public String getRelatedObjListPropName_label() {
            if (getDispColName() == null)
                return null;
            String name = getRelatedObjListPropName();
            return name == null ? null : name + "_label";
        }

        public StdDataType getRelatedColType() {
            IColumnModel colModel = relatedObjProp.getSingleJoinColumn();
            return colModel == null ? null : colModel.getStdDataType();
        }

        public String getRelatedColTypeName() {
            StdDataType type = getRelatedColType();
            return type == null ? null : type.getJavaTypeName();
        }

        public String getRelatedColListPropName() {
            String propName = getRelatedColPropName();
            return propName == null ? null : propName + "List";
        }
    }

    public static class RefMappingInfo {
        private final IEntityRelationModel relationModel;

        public RefMappingInfo(IEntityRelationModel relationModel) {
            this.relationModel = relationModel;
        }

        public String getManyToManyRefProp() {
            IEntityJoinConditionModel join = relationModel.getSingleColumnJoin();
            if (join == null)
                return null;

            IEntityModel refEntityModel = relationModel.getRefEntityModel();

            for (IEntityRelationModel relModel : refEntityModel.getRelations()) {
                if (relModel.isToOneRelation()) {
                    if (relModel.getName().equals(relationModel.getRefPropName()))
                        continue;

                    if(relModel.isSingleColumn())
                        return relModel.getSingleJoinColumn().getName();
                    return relModel.getName();
                }
            }

            return null;
        }
    }

    public static RefMappingInfo getRefMappingInfo(IEntityRelationModel propModel) {
        if (!propModel.isToManyRelation())
            return null;

        IEntityModel refEntityModel = propModel.getRefEntityModel();
        if (!refEntityModel.containsTag(OrmModelConstants.TAG_MANY_TO_MANY) && !refEntityModel.containsTag(OrmModelConstants.TAG_MAPPING))
            return null;

        return new RefMappingInfo(propModel);
    }


    public static RefPropInfo getRefManyPropInfo(IEntityRelationModel propModel) {
        if (!propModel.isToManyRelation())
            return null;

        IEntityModel refEntityModel = propModel.getRefEntityModel();
        if (!refEntityModel.containsTag(OrmConstants.TAG_MANY_TO_MANY) && !refEntityModel.containsTag(OrmModelConstants.TAG_MAPPING))
            return null;

        return getRefPropInfo(propModel);
    }

    public static RefPropInfo getRefOnePropInfo(IEntityRelationModel propModel) {
        if (!propModel.isToManyRelation())
            return null;

        IEntityModel refEntityModel = propModel.getRefEntityModel();
        if (!refEntityModel.containsTag(OrmConstants.TAG_ONE_TO_ONE))
            return null;

        return getRefPropInfo(propModel);
    }

    private static RefPropInfo getRefPropInfo(IEntityRelationModel propModel) {
        IEntityModel refEntityModel = propModel.getRefEntityModel();
        for (IEntityRelationModel relModel : refEntityModel.getRelations()) {
            if (relModel.isToOneRelation()) {
                if (propModel.getName().equals(relModel.getRefPropName()))
                    continue;

                RefPropInfo ref = new RefPropInfo(relModel);
                return ref;
            }
        }

        return null;
    }
}