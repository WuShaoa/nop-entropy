/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.xlang.xpl.output;

import io.nop.core.lang.xml.XNode;
import io.nop.xlang.api.IXLangCompileScope;
import io.nop.xlang.xpl.IXplCompiler;
import io.nop.xlang.xpl.IXplTagCompiler;
import io.nop.xlang.xpl.XLangParseBuffer;

public interface IXplUnknownTagCompiler extends IXplTagCompiler {
    void parseTag(XLangParseBuffer buf, XNode node, IXplCompiler cp, IXLangCompileScope scope);

    void parseContent(XLangParseBuffer buf, XNode node, IXplCompiler cp, IXLangCompileScope scope);
}