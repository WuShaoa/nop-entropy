/**
 * Copyright (c) 2017-2023 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-chaos
 * Github: https://github.com/entropy-cloud/nop-chaos
 */
package io.nop.auth.service;

import io.nop.api.core.annotations.autotest.EnableSnapshot;
import io.nop.api.core.beans.ApiRequest;
import io.nop.api.core.beans.ApiResponse;
import io.nop.api.core.beans.graphql.GraphQLRequestBean;
import io.nop.api.core.beans.graphql.GraphQLResponseBean;
import io.nop.autotest.junit.JunitAutoTestCase;
import io.nop.graphql.core.IGraphQLExecutionContext;
import io.nop.graphql.core.engine.IGraphQLEngine;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.util.Map;

/**
 * 测试在xbiz模型文件中定义的action
 */
public class TestBizAction extends JunitAutoTestCase {
    @Inject
    IGraphQLEngine graphQLEngine;

    @EnableSnapshot
    @Test
    public void testMyFindPage() {
        // ApiRequest<LoginRequest> request = request("request.json5", LoginRequest.class);
        GraphQLRequestBean request = input("request.yaml", GraphQLRequestBean.class);

        IGraphQLExecutionContext context = graphQLEngine.newGraphQLContext(request);
        GraphQLResponseBean result = graphQLEngine.executeGraphQL(context);

        output("response.json5", result);
    }

    @EnableSnapshot
    @Test
    public void testBizAuth() {
        ApiRequest<Map<String, Object>> request = request("request.json5", Map.class);

        IGraphQLExecutionContext context = graphQLEngine.newRpcContext(null, "NopAuthRole__addRoleUsers",
                request);
        ApiResponse<?> result = graphQLEngine.executeRpc(context);

        output("response.json5", result);
    }
}
