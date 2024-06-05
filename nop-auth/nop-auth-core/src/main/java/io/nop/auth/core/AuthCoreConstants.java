/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.auth.core;

public interface AuthCoreConstants {
    String PLACEHOLDER_BACK_URL = "{backUrl}";
    String PLACEHOLDER_HOST = "{host}";
    String PLACEHOLDER_PORT = "{port}";
    String PLACEHOLDER_ERR_CODE = "{errCode}";

    String ROLE_ADMIN = "admin";
    String ROLE_USER = "user";

    String ROLE_NOP_ADMIN = "nop-admin";

    String NOP_ROLE_PREFIX = "nop-";

    String PARAM_CODE = "code";
    String PARAM_STATE = "state";
    String PARAM_REDIRECT_URI = "redirect_uri";

    String COOKIE_NOP_TOKEN = "nop-token";

    String VAR_ACTION = "action";
    String VAR_ENTITY = "entity";
    String VAR_USER_CONTEXT = "userContext";
    String VAR_FILTER = "filter";

    String VAR_OBJ_AUTH_MODEL = "objAuthModel";
    String VAR_AUTH_OBJ_NAME = "authObjName";

    String USER_ID_SYS = "sys";

    String NS_BIZ = "auth-when";

    String LIB_PATH_BIZ_WHEN = "/nop/core/xlib/biz!when.xlib";
}
