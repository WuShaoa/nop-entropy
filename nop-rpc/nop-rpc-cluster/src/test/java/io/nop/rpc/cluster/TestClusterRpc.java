/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.rpc.cluster;

import io.nop.api.core.beans.ApiRequest;
import io.nop.api.core.exceptions.NopException;
import io.nop.autotest.junit.JunitBaseTestCase;
import org.junit.jupiter.api.Test;

import jakarta.inject.Inject;

import static io.nop.http.api.HttpApiErrors.ERR_HTTP_CONNECT_FAIL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestClusterRpc extends JunitBaseTestCase {

    @Inject
    ServiceA serviceA;

    @Test
    public void testInvoke() {
        try {
            serviceA.myMethod(ApiRequest.build("test"));
            assertTrue(false);
        } catch (NopException e) {
            assertEquals(ERR_HTTP_CONNECT_FAIL.getErrorCode(), e.getErrorCode());
        } catch (Exception e) {
            assertTrue(false);
        }

    }
}
