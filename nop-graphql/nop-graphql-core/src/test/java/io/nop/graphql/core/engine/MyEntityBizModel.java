/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.graphql.core.engine;

import io.nop.api.core.annotations.biz.BizLoader;
import io.nop.api.core.annotations.biz.BizModel;
import io.nop.api.core.annotations.biz.BizQuery;
import io.nop.api.core.annotations.biz.ContextSource;
import io.nop.api.core.annotations.core.Name;
import io.nop.api.core.annotations.graphql.GraphQLReturn;
import io.nop.api.core.beans.FieldSelectionBean;
import io.nop.api.core.beans.PageBean;
import io.nop.api.core.beans.query.QueryBean;
import io.nop.core.context.IServiceContext;
import io.nop.core.lang.eval.IEvalScope;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@BizModel("MyEntity")
public class MyEntityBizModel {

    @BizLoader("children")
    @GraphQLReturn(bizObjName = "MyChild")
    public List<MyChild> getChildren(@ContextSource MyEntity entity) {
        List<MyChild> children = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            MyChild child = new MyChild();
            child.setId(entity.getId() + "_" + i);
            child.setName("child_" + i);
            child.setValue(i);
            children.add(child);
        }
        return children;
    }

    @BizQuery("get")
    @GraphQLReturn(bizObjName = "MyEntity")
    public MyEntity getEntity(@Name("id") String id, IEvalScope scope, IServiceContext context,
                              FieldSelectionBean selection) {
        assertEquals("MyEntity__get", selection.getName());
        assertTrue(scope != null);
        assertTrue(scope == context.getEvalScope());

        MyEntity entity = new MyEntity();
        entity.setId(id);
        entity.setName("my");
        return entity;
    }

    @BizQuery
    @GraphQLReturn(bizObjName = "MyEntity")
    public PageBean<MyEntity> findPage(@Name("query") QueryBean query) {
        List<MyEntity> ret = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            MyEntity entity = new MyEntity();
            entity.setId("entity_" + i);
            entity.setName("entity_name_" + i + "_" + query.getFilter().getAttr("value"));
            ret.add(entity);
        }
        PageBean<MyEntity> page = new PageBean<>();
        page.setTotal(100);
        page.setItems(ret);
        return page;
    }
}