/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.xlang.api;

import io.nop.core.reflect.IFunctionModel;

public interface IFunctionProvider {
    void registerFunction(String funcName, IFunctionModel fn);

    void unregisterFunction(String funcName, IFunctionModel fn);

    IFunctionModel getRegisteredFunction(String funcName);
}