/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.dao.dialect.model;

import io.nop.dao.dialect.model._gen._SqlNativeFunctionModel;

public class SqlNativeFunctionModel extends _SqlNativeFunctionModel implements ISqlFunctionModel {
    public SqlNativeFunctionModel() {

    }

    public String getType() {
        return "native";
    }
}
