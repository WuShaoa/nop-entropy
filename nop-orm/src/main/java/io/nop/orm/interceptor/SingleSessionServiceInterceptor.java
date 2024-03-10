/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.orm.interceptor;

import io.nop.api.core.beans.ApiResponse;
import io.nop.orm.IOrmTemplate;
import io.nop.rpc.api.IRpcServiceInterceptor;
import io.nop.rpc.api.IRpcServiceInvocation;

import java.util.concurrent.CompletionStage;

public class SingleSessionServiceInterceptor implements IRpcServiceInterceptor {
    private final IOrmTemplate ormTemplate;

    public SingleSessionServiceInterceptor(IOrmTemplate ormTemplate) {
        this.ormTemplate = ormTemplate;
    }

    @Override
    public CompletionStage<ApiResponse<?>> interceptAsync(IRpcServiceInvocation inv) {
        return ormTemplate.runInSessionAsync(session -> {
            return inv.proceedAsync();
        });
    }

    @Override
    public ApiResponse<?> intercept(IRpcServiceInvocation inv) {
        return ormTemplate.runInSession(session -> {
            return inv.proceed();
        });
    }
}
