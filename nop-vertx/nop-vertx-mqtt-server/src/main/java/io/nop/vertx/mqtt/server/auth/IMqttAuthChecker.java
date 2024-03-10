/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.vertx.mqtt.server.auth;

import io.nop.vertx.mqtt.server.IMqttConnection;

import java.util.concurrent.CompletionStage;

public interface IMqttAuthChecker {
    CompletionStage<Boolean> checkAuthAsync(String userName, String password, IMqttConnection conn);
}