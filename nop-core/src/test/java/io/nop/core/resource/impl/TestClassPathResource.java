/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.core.resource.impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestClassPathResource {
    @Test
    public void testNormalizePath(){
        String path = ClassPathResource.normalizeClassPath("classpath:/_vfs/a.txt");
        assertEquals("classpath:_vfs/a.txt",path);
    }
}
