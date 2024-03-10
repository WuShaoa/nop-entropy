/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.xlang.script;

import io.nop.api.core.util.SourceLocation;
import io.nop.core.lang.eval.IEvalFunction;
import io.nop.xlang.api.IXLangCompileScope;

/**
 * 外部脚本引擎，例如groovy等
 */
public interface IScriptCompiler {
    IEvalFunction compile(SourceLocation loc, String text, IXLangCompileScope scope);
}