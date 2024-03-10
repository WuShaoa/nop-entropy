/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.biz.impl;

import io.nop.api.core.annotations.autotest.NopTestConfig;
import io.nop.api.core.beans.graphql.GraphQLRequestBean;
import io.nop.api.core.beans.graphql.GraphQLResponseBean;
import io.nop.api.core.json.JSON;
import io.nop.autotest.junit.JunitBaseTestCase;
import io.nop.graphql.core.IGraphQLExecutionContext;
import io.nop.graphql.core.engine.GraphQLEngine;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@NopTestConfig(enableAutoConfig = false, enableAppBeansFile = false)
public class TestBizObjectManager extends JunitBaseTestCase {

    BizObjectManager bizObjManager;

    GraphQLEngine engine;

    @BeforeEach
    public void setUp() {
        bizObjManager = new BizObjectManager();
        bizObjManager.setBizModelBeans(Arrays.asList(new MyObjectBizModel()));
        bizObjManager.init();

        engine = new GraphQLEngine();
        engine.init();
        engine.setSchemaLoader(bizObjManager);
    }

    @AfterEach
    public void tearDown() {
        bizObjManager.destroy();
    }

    @Test
    public void testQuery() {
        GraphQLRequestBean request = attachmentBean("request.yaml", GraphQLRequestBean.class);
        IGraphQLExecutionContext context = engine.newGraphQLContext(request);
        GraphQLResponseBean response = engine.executeGraphQL(context);
        System.out.println(JSON.serialize(response, true));

        assertEquals(attachmentJsonText("response.json"), JSON.serialize(response, true));
    }

    @Test
    public void testStateMachine() {
        GraphQLRequestBean request = attachmentBean("mutation.yaml", GraphQLRequestBean.class);
        IGraphQLExecutionContext context = engine.newGraphQLContext(request);
        GraphQLResponseBean response = engine.executeGraphQL(context);
        System.out.println(JSON.serialize(response, true));

        assertEquals(attachmentJsonText("mutation-response.json"), JSON.serialize(response, true));
    }
}