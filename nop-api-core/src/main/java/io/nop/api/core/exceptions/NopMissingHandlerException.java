/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.api.core.exceptions;

public class NopMissingHandlerException extends NopException {
    private static final long serialVersionUID = -6293065145798413692L;

    public NopMissingHandlerException(ErrorCode errorCode, Throwable cause) {
        super(errorCode, cause);
    }

    public NopMissingHandlerException(ErrorCode errorCode) {
        super(errorCode);
    }
}