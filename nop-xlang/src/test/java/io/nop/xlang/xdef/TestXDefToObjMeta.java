/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.xlang.xdef;

import io.nop.core.initialize.CoreInitialization;
import io.nop.core.lang.xml.XNodeValuePosition;
import io.nop.xlang.xmeta.IObjMeta;
import io.nop.xlang.xmeta.IObjPropMeta;
import io.nop.xlang.xmeta.SchemaLoader;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestXDefToObjMeta {
    @BeforeAll
    public static void setUp() {
        CoreInitialization.initialize();
    }

    @AfterAll
    public static void tearDown() {
        CoreInitialization.destroy();
    }

    @Test
    public void testObjMeta() {
        IObjMeta objMeta = SchemaLoader.loadXMeta("/test/test2.xdef");
        objMeta.toNode().dump();
        assertEquals(XNodeValuePosition.child, objMeta.getProp("source").getXmlPos());
    }

    @Test
    public void testXdefProp() {
        IObjMeta objMeta = SchemaLoader.loadXMeta("/test/test_ext.xdef");
        IObjPropMeta propMeta = objMeta.getProp("filter");
        assertEquals("xml", propMeta.prop_get("graphql:mapper"));
    }
}
