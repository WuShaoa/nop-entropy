/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.xlang.filter;

import io.nop.api.core.auth.ISecurityContext;
import io.nop.api.core.beans.DictBean;
import io.nop.api.core.beans.DictOptionBean;
import io.nop.api.core.beans.ITreeBean;
import io.nop.api.core.exceptions.NopException;
import io.nop.api.core.util.SourceLocation;
import io.nop.commons.cache.ICache;
import io.nop.commons.functional.Lazy;
import io.nop.core.context.IServiceContext;
import io.nop.core.dict.DictProvider;
import io.nop.core.reflect.bean.BeanTool;

import java.util.List;
import java.util.Map;

import static io.nop.xlang.XLangErrors.ARG_ATTR_NAME;
import static io.nop.xlang.XLangErrors.ARG_VAR_NAME;
import static io.nop.xlang.XLangErrors.ERR_BIZ_UNKNOWN_BIZ_VAR;

public class BizExprHelper {

    public static DictBean getBizExprDict(ISecurityContext context) {
        IServiceContext ctx = context instanceof IServiceContext ? (IServiceContext) context : null;
        ICache<Object, Object> cache = ctx != null ? ctx.getCache() : null;
        DictBean dict = DictProvider.instance().getDict(null, BizFilterConstants.DICT_NAME_BIZ_VAR, cache, ctx);
        return dict;
    }

    public static Object getBizExprValue(DictBean dict, SourceLocation loc, String name, String expr, ISecurityContext context) {
        DictOptionBean option = dict.getOptionByValue(expr);
        if (option == null) {
            throw new NopException(ERR_BIZ_UNKNOWN_BIZ_VAR)
                    .loc(loc)
                    .param(ARG_ATTR_NAME, name)
                    .param(ARG_VAR_NAME, expr);
        }
        String code = option.getCode();
        return BeanTool.getComplexProperty(context, code);
    }

    public static void resolveBizExpr(ITreeBean node, ISecurityContext context) {
        if (node == null)
            return;
        resolveBizExpr(Lazy.of(() -> getBizExprDict(context)), node, context);
    }

    private static void resolveBizExpr(Lazy<DictBean> dict, ITreeBean node, ISecurityContext context) {
        Map<String, Object> attrs = node.getAttrs();
        if (attrs != null) {
            for (Map.Entry<String, Object> entry : attrs.entrySet()) {
                String name = entry.getKey();
                Object value = entry.getValue();
                if (value instanceof String) {
                    String str = value.toString();
                    if (str.startsWith(BizFilterConstants.BIZ_EXPR_PREFIX)) {
                        value = getBizExprValue(dict.get(), node.getLocation(), name, str, context);
                        entry.setValue(value);
                    }
                }
            }
        }
        List<? extends ITreeBean> children = node.getChildren();
        if (children != null) {
            for (ITreeBean child : children) {
                resolveBizExpr(dict, child, context);
            }
        }
    }

    public static Object resolveBizValue(SourceLocation loc, String name, Object value,
                                         Lazy<DictBean> dict, ISecurityContext context) {
        if (value instanceof String) {
            String str = value.toString();
            if (str.startsWith(BizFilterConstants.BIZ_EXPR_PREFIX)) {
                value = getBizExprValue(dict.get(), loc, name, str, context);
            }
        }
        return value;
    }
}