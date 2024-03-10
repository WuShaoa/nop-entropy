/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.rpc.core.interceptors;

import io.nop.api.core.beans.ApiResponse;
import io.nop.api.core.json.JSON;
import io.nop.api.core.util.ApiHeaders;
import io.nop.rpc.api.IRpcServiceInterceptor;
import io.nop.rpc.api.IRpcServiceInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletionStage;

public class LogRpcServiceInterceptor implements IRpcServiceInterceptor {
    private static final Logger LOG = LoggerFactory.getLogger(LogRpcServiceInterceptor.class);

    public static final LogRpcServiceInterceptor INSTANCE = new LogRpcServiceInterceptor();

    @Override
    public CompletionStage<ApiResponse<?>> interceptAsync(IRpcServiceInvocation inv) {
        if (LOG.isInfoEnabled()) {
            LOG.info("nop.rpc.invoke:request={}", JSON.serialize(inv.getRequest(), true));
        }
        return inv.proceedAsync().whenComplete((res, err) -> {
            if (err != null) {
                String reqId = ApiHeaders.getId(inv.getRequest());
                LOG.error("nop.err.rpc.invoke-error:serviceName={},serviceMethod={},reqId={}", inv.getServiceName(),
                        inv.getServiceMethod(), reqId, err);
            } else if (LOG.isInfoEnabled()) {
                LOG.info("nop.rpc.return-result:response={}", JSON.serialize(res, true));
            }
        });
    }
}
