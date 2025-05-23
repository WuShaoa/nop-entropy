/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.biz.crud;

import io.nop.api.core.beans.DictOptionBean;
import io.nop.api.core.convert.ConvertHelper;
import io.nop.api.core.exceptions.NopException;
import io.nop.biz.BizConstants;
import io.nop.core.i18n.I18nHelper;
import io.nop.xlang.xmeta.IObjMeta;
import io.nop.xlang.xmeta.IObjPropMeta;
import io.nop.xlang.xmeta.IObjSchema;

import java.util.List;
import java.util.Set;

import static io.nop.auth.api.AuthApiErrors.ARG_BIZ_OBJ_NAME;
import static io.nop.biz.BizErrors.ARG_PROP_NAME;
import static io.nop.biz.BizErrors.ARG_PROP_NAMES;
import static io.nop.biz.BizErrors.ERR_BIZ_NOT_ALLOWED_LEFT_JOIN_PROPS;
import static io.nop.biz.BizErrors.ERR_BIZ_PROP_NOT_SORTABLE;
import static io.nop.biz.BizErrors.ERR_BIZ_UNKNOWN_PROP;

public class BizObjMetaHelper {
//    public static IObjPropMeta getPropMeta(IObjSchema objMeta, String propName, String relatedTag,
//                                           IBizObjectManager bizObjectManager) {
//        IObjPropMeta propMeta = objMeta.getProp(propName);
//        if (propMeta != null)
//            return propMeta;
//
//        // 故意从后向前查找
//        int pos = propName.lastIndexOf('.');
//        if (pos < 0)
//            return null;
//
//        // 如果是复合属性，则检查一下是否对应于关联对象上的属性
//        IObjPropMeta baseProp = getPropMeta(objMeta, propName.substring(0, pos), relatedTag, bizObjectManager);
//        if (baseProp == null)
//            return null;
//
//        // 不允许递归
//        if (relatedTag != null && !baseProp.containsTag(relatedTag))
//            return null;
//
//        ISchema schema = baseProp.getSchema();
//        if (schema == null)
//            return null;
//
//        String bizObjName = schema.getBizObjName();
//        if (bizObjName == null)
//            return null;
//
//        String refPropName = propName.substring(pos + 1);
//
//        IBizObject bizObj = bizObjectManager.getBizObject(bizObjName);
//        IObjMeta refObjMeta = bizObj.getObjMeta();
//        return refObjMeta.getProp(refPropName);
//    }

    public static IObjPropMeta checkPropSortable(String bizObjName,
                                                 IObjSchema objMeta, String propName) {
        // 可排序字段必须直接定义在objMeta上
        IObjPropMeta propMeta = objMeta.getProp(propName);
        if (propMeta != null) {
            if (!propMeta.isSortable()) {
                throw new NopException(ERR_BIZ_PROP_NOT_SORTABLE).param(ARG_BIZ_OBJ_NAME, bizObjName)
                        .param(ARG_PROP_NAME, propMeta.getName());
            }
        } else {
            throw new NopException(ERR_BIZ_UNKNOWN_PROP).param(ARG_BIZ_OBJ_NAME, bizObjName)
                    .param(ARG_PROP_NAME, propName);
        }
        return propMeta;
    }

    public static void checkAllowLeftJoinProps(List<String> leftJoinProps, IObjMeta objMeta) {
        if (leftJoinProps == null || leftJoinProps.isEmpty())
            return;

        Set<String> allowed = ConvertHelper.toCsvSet(objMeta.prop_get(BizConstants.BIZ_ALLOWED_LEFT_JOIN_PROPS));
        if (allowed != null && allowed.contains("*"))
            return;

        if (allowed == null || allowed.isEmpty() || !allowed.containsAll(leftJoinProps))
            throw new NopException(ERR_BIZ_NOT_ALLOWED_LEFT_JOIN_PROPS)
                    .param(ARG_BIZ_OBJ_NAME, objMeta.getBizObjName())
                    .param(ARG_PROP_NAMES, leftJoinProps);
    }

    public static IObjPropMeta getRelationMeta(IObjSchema objMeta, IObjPropMeta propMeta) {
        String relation = (String) propMeta.prop_get(BizConstants.EXT_RELATION);
        if (relation != null) {
            return objMeta.requireProp(relation);
        }
        return propMeta;
    }

//
//    public static ITreeBean getFilter(IObjMeta objMeta, IServiceContext context) {
//        if (objMeta.getFilter() == null)
//            return null;
//
//        IEvalScope scope = XLang.newEvalScope();
//        scope.setLocalValue(BizConstants.VAR_USER_CONTEXT, context.getUserContext());
//        scope.setLocalValue(CoreConstants.VAR_SVC_CTX, context);
//        return objMeta.getFilter().generateNode(scope);
//    }

    public static DictOptionBean getPropInfo(IObjPropMeta propMeta, String locale, String bizObjName) {
        DictOptionBean option = new DictOptionBean();
        option.setValue(propMeta.getName());
        String displayName = I18nHelper.getFieldDisplayName(locale, bizObjName, propMeta.getName(), false, propMeta.getDisplayName());
        option.setLabel(displayName);
        return option;
    }
}