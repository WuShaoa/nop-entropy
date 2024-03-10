/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.api.core.exceptions;

import io.nop.api.core.beans.ApiRequest;
import io.nop.api.core.beans.ApiResponse;
import io.nop.api.core.beans.ErrorBean;
import io.nop.api.core.util.ApiHeaders;

import java.util.Map;

public interface IErrorMessageManager {
    Throwable getRealCause(Throwable exception);

    ErrorBean buildErrorMessage(String locale, Throwable e, boolean includeStack, boolean onlyPublic, boolean logError);

    default ErrorBean buildErrorMessage(String locale, Throwable e, boolean includeStack, boolean onlyPublic) {
        return buildErrorMessage(locale, e, includeStack, onlyPublic, true);
    }

    String resolveDescription(String locale, String message, Map<String, ?> params);

    ErrorBean resolveErrorBean(ErrorBean error, boolean onlyPublic);

    default ErrorBean buildErrorMessage(String locale, Throwable e) {
        return buildErrorMessage(locale, e, false, true);
    }

    default ApiResponse<?> buildResponse(ApiRequest<?> request, Throwable e) {
        ApiResponse<?> res = buildResponse(ApiHeaders.getLocale(request), e);
        return res;
    }

    ApiResponse<?> buildResponse(String locale, Throwable e);

    ApiResponse<?> buildResponse(String locale, ErrorBean error);
}
