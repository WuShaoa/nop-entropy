/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.xlang.xpl.output;

import io.nop.api.core.exceptions.NopEvalException;
import io.nop.commons.util.StringHelper;
import io.nop.commons.util.objects.ValueWithLocation;
import io.nop.core.lang.xml.XNode;
import io.nop.xlang.api.IXLangCompileScope;
import io.nop.xlang.ast.Expression;
import io.nop.xlang.ast.GenNodeAttrExpression;
import io.nop.xlang.ast.GenNodeExpression;
import io.nop.xlang.xpl.IXplCompiler;
import io.nop.xlang.xpl.XLangParseBuffer;
import io.nop.xlang.xpl.XplConstants;
import io.nop.xlang.xpl.utils.XplParseHelper;

import java.util.ArrayList;
import java.util.List;

import static io.nop.xlang.XLangErrors.ARG_ALLOWED_NAMES;
import static io.nop.xlang.XLangErrors.ARG_ATTR_NAME;
import static io.nop.xlang.XLangErrors.ARG_TAG_NAME;
import static io.nop.xlang.XLangErrors.ERR_XPL_UNKNOWN_TAG_ATTR;
import static io.nop.xlang.xpl.output.OutputParseHelper.getTagNameExpr;

public class NodeOutputTagCompiler implements IXplUnknownTagCompiler {
    public static final NodeOutputTagCompiler INSTANCE = new NodeOutputTagCompiler();

    @Override
    public void parseContent(XLangParseBuffer buf, XNode node, IXplCompiler cp, IXLangCompileScope scope) {
        Expression expr = XplParseHelper.parseContentTemplate(node, cp, scope);
        buf.add(GenNodeExpression.genTextNode(expr));
    }

    @Override
    public void parseTag(XLangParseBuffer buf, XNode node, IXplCompiler cp, IXLangCompileScope scope) {
        if (node.isTextNode()) {
            parseContent(buf, node, cp, scope);
            return;
        }

        boolean xplNs = scope.isNsEnabled(XplConstants.XPL_NS);
        Expression tagName = getTagNameExpr(node, xplNs, cp, scope);
        List<GenNodeAttrExpression> attrExprs = genAttrExprs(xplNs, node, cp, scope);
        Expression extAttrExpr = parseExtAttrs(node, cp, scope);
        Expression bodyExpr = cp.parseTagBody(node, scope);

        buf.add(GenNodeExpression.valueOf(node.getLocation(), tagName, attrExprs, extAttrExpr, bodyExpr));
    }

    private Expression parseExtAttrs(XNode node, IXplCompiler cp, IXLangCompileScope scope) {
        ValueWithLocation attrs = node.attrValueLoc(XplConstants.ATTR_XPL_ATTRS);
        if (attrs.isNull())
            return null;

        return XplParseHelper.parseAttrSimpleExpr(node, XplConstants.ATTR_XPL_ATTRS, cp, scope);
    }

    private List<GenNodeAttrExpression> genAttrExprs(boolean xplNs, XNode node, IXplCompiler cp,
                                                     IXLangCompileScope scope) {
        List<GenNodeAttrExpression> ret = new ArrayList<>(node.getAttrCount());
        node.forEachAttr((name, value) -> {
            if (xplNs) {
                if (StringHelper.startsWithNamespace(name, XplConstants.XPL_NS)) {
                    // ignoreTag时仍然输出xpl:lib。但是此时xpl名字空间时是启用的，所以其他xpl名字空间的属性会被处理掉
                    if (name.equals(XplConstants.ATTR_XPL_LIB) && node.attrBoolean(XplConstants.ATTR_XPL_IGNORE_TAG)) {
                        Expression expr = XplParseHelper.parseAttrTemplateExpr(node, name, cp, scope);
                        ret.add(GenNodeAttrExpression.valueOf(value.getLocation(), name, expr));
                        return;
                    }
                    if (!XplConstants.XPL_ATTRS.contains(name))
                        throw new NopEvalException(ERR_XPL_UNKNOWN_TAG_ATTR).loc(node.attrLoc(name))
                                .param(ARG_ATTR_NAME, name).param(ARG_TAG_NAME, node.getTagName())
                                .param(ARG_ALLOWED_NAMES, XplConstants.XPL_ATTRS);
                    return;
                }
            }

            // xpl:disableNs和xpl:enableNs总是被处理？
            if (name.equals(XplConstants.ATTR_XPL_ENABLE_NS) || name.equals(XplConstants.ATTR_XPL_DISABLE_NS))
                return;


            if (name.startsWith(XplConstants.NAMESPACE_XGEN_PREFIX))
                name = name.substring(XplConstants.NAMESPACE_XGEN_PREFIX.length());

            Expression expr = XplParseHelper.parseAttrTemplateExpr(node, name, cp, scope);
            ret.add(GenNodeAttrExpression.valueOf(value.getLocation(), name, expr));
        });
        return ret;
    }
}