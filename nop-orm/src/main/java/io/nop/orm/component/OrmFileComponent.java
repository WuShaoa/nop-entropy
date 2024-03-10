/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.orm.component;

import io.nop.api.core.convert.ConvertHelper;
import io.nop.api.core.ioc.IBeanProvider;
import io.nop.commons.util.StringHelper;
import io.nop.orm.IOrmEntity;
import io.nop.orm.IOrmEntityFileStore;
import io.nop.orm.OrmConstants;

public class OrmFileComponent extends AbstractOrmComponent {
    public static final String PROP_NAME_filePath = "filePath";

    public String getFilePath() {
        return ConvertHelper.toString(internalGetPropValue(PROP_NAME_filePath));
    }

    public void setFilePath(String value) {
        internalSetPropValue(PROP_NAME_filePath, value);
    }

    @Override
    public void onEntityFlush() {
        IOrmEntity entity = orm_owner();
        int propId = getColPropId(PROP_NAME_filePath);
        if (entity.orm_state().isUnsaved() || entity.orm_propDirty(propId)) {
            IBeanProvider beanProvider = entity.orm_enhancer().getBeanProvider();
            // 有可能没有引入file store支持
            if(!beanProvider.containsBean(OrmConstants.BEAN_ORM_ENTITY_FILE_STORE))
                return;

            IOrmEntityFileStore fileStore = (IOrmEntityFileStore) beanProvider.getBean(OrmConstants.BEAN_ORM_ENTITY_FILE_STORE);
            String oldValue = (String) entity.orm_propOldValue(propId);

            String fileId = fileStore.decodeFileId(getFilePath());
            String propName = entity.orm_propName(propId);

            String bizObjName = getBizObjName();

            if (!StringHelper.isEmpty(oldValue)) {
                String oldFileId = fileStore.decodeFileId(oldValue);
                if (!StringHelper.isEmpty(oldFileId)) {
                    fileStore.detachFile(oldFileId, bizObjName, entity.orm_idString(), propName);
                }
            }

            if (!StringHelper.isEmpty(fileId)) {
                fileStore.attachFile(fileId, bizObjName, entity.orm_idString(), propName);
            }
        }
    }

    @Override
    public void onEntityDelete(boolean logicalDelete) {
        if (logicalDelete)
            return;

        IOrmEntity entity = orm_owner();
        IBeanProvider beanProvider = entity.orm_enhancer().getBeanProvider();
        IOrmEntityFileStore fileStore = (IOrmEntityFileStore) beanProvider.getBean(OrmConstants.BEAN_ORM_ENTITY_FILE_STORE);

        String fileId = fileStore.decodeFileId(getFilePath());
        if (!StringHelper.isEmpty(fileId)) {
            int propId = getColPropId(PROP_NAME_filePath);
            String propName = entity.orm_propName(propId);

            String bizObjName = getBizObjName();

            fileStore.detachFile(fileId, bizObjName, entity.orm_idString(), propName);
        }
    }

    public String getBizObjName() {
        IOrmEntity entity = orm_owner();
        return StringHelper.lastPart(entity.orm_entityName(), '.');
    }
}
