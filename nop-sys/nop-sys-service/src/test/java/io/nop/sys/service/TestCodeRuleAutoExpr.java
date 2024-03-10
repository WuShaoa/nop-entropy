/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.sys.service;

import io.nop.api.core.annotations.autotest.EnableSnapshot;
import io.nop.api.core.annotations.autotest.NopTestConfig;
import io.nop.api.core.beans.ApiRequest;
import io.nop.api.core.util.FutureHelper;
import io.nop.autotest.junit.JunitAutoTestCase;
import io.nop.dao.api.IDaoProvider;
import io.nop.dao.api.IEntityDao;
import io.nop.graphql.core.IGraphQLExecutionContext;
import io.nop.graphql.core.ast.GraphQLOperationType;
import io.nop.graphql.core.engine.IGraphQLEngine;
import io.nop.sys.dao.entity.NopSysCodeRule;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

@NopTestConfig(localDb = true, initDatabaseSchema = true,disableSnapshot = false)
public class TestCodeRuleAutoExpr extends JunitAutoTestCase {
    @Inject
    IGraphQLEngine graphQLEngine;

    @Inject
    IDaoProvider daoProvider;

    @Test
    @EnableSnapshot
    public void testAutoExpr() {
        IEntityDao<NopSysCodeRule> dao = daoProvider.daoFor(NopSysCodeRule.class);
        NopSysCodeRule rule = new NopSysCodeRule();
        rule.setCodePattern("D{@year}{@prop:entity.name,3}{@seq:3}");
        rule.setName("test");
        rule.setDisplayName("Test");
        rule.setSeqName("default");
        rule.setCreatedBy("a");
        rule.setCreateTime(new Timestamp(System.currentTimeMillis()));
        rule.setUpdatedBy("a");
        rule.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        dao.saveEntity(rule);

        ApiRequest<?> request = input("request.json5", ApiRequest.class);
        IGraphQLExecutionContext context = graphQLEngine.newRpcContext(GraphQLOperationType.mutation,
                "NopSysNoticeTemplate__save", request);
        Object result = FutureHelper.syncGet(graphQLEngine.executeRpcAsync(context));
        output("response.json5", result);
    }
}
