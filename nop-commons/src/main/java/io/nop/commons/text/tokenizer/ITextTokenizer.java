/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.commons.text.tokenizer;

import io.nop.api.core.util.SourceLocation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public interface ITextTokenizer {
    Iterator<IToken> tokenize(SourceLocation loc, String text);

    default List<IToken> tokenizeToList(SourceLocation loc, String text) {
        List<IToken> ret = new ArrayList<>();
        tokenize(loc, text).forEachRemaining(ret::add);
        return ret;
    }
}