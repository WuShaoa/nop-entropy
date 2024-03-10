/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.js;

import io.nop.api.core.exceptions.ErrorCode;

import static io.nop.api.core.exceptions.ErrorCode.define;

public interface JsErrors {

    ErrorCode ERR_JS_ERROR = define("nop.err.js.error","脚本执行错误");
    ErrorCode ERR_JS_CONTEXT_ALREADY_CLOSED =
            define("nop.err.js.context-already-closed", "JS执行环境已经被关闭，不能再执行操作");
}
