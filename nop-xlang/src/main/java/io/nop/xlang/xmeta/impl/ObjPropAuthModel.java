/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.xlang.xmeta.impl;

import io.nop.api.core.auth.ActionAuthMeta;
import io.nop.commons.util.CollectionHelper;
import io.nop.xlang.xmeta.impl._gen._ObjPropAuthModel;

public class ObjPropAuthModel extends _ObjPropAuthModel {
    public ObjPropAuthModel() {

    }

    public ActionAuthMeta toActionAuthMeta() {
        if (CollectionHelper.isEmpty(getRoles())) {
            if (getPermissions() == null || getPermissions().isEmpty())
                return null;
        }
        return new ActionAuthMeta(isPublicAccess(), getRoles(), getPermissions());
    }
}
