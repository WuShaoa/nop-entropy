/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.orm.dao;

import io.nop.dao.api.IEntityDao;
import io.nop.orm.IOrmEntity;
import io.nop.orm.IOrmTemplate;
import io.nop.orm.model.IEntityModel;

public interface IOrmEntityDao<T extends IOrmEntity> extends IEntityDao<T> {
    IEntityModel getEntityModel();

    IOrmTemplate getOrmTemplate();
}
