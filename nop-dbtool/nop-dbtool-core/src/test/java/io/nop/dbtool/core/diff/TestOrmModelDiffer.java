/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.dbtool.core.diff;

import io.nop.api.core.annotations.autotest.NopTestConfig;
import io.nop.autotest.junit.JunitBaseTestCase;
import io.nop.commons.diff.DiffValuePrinter;
import io.nop.commons.diff.IDiffValue;
import io.nop.core.initialize.CoreInitialization;
import io.nop.core.unittest.BaseTestCase;
import io.nop.orm.model.OrmModel;
import io.nop.xlang.xdsl.DslModelHelper;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

@NopTestConfig(localDb = true)
public class TestOrmModelDiffer extends JunitBaseTestCase {
    @BeforeAll
    public static void init() {
        CoreInitialization.initialize();
    }

    @AfterAll
    public static void destroy() {
        CoreInitialization.destroy();
    }

    @Test
    public void testDiffTables() {
        OrmModel modelA = (OrmModel) DslModelHelper.loadDslModel(attachmentResource("test-a.orm.xml"));
        OrmModel modelB = (OrmModel) DslModelHelper.loadDslModel(attachmentResource("test-b.orm.xml"));

        IDiffValue diff = new OrmModelDiffer().diffTables(modelA, modelB);
        String text = new DiffValuePrinter().print(diff);
        System.out.println(text);
    }
}
