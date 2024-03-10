/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.js.fs;

public class ResourceSource {
    private final String path;
    private final String text;

    public ResourceSource(String path, String text) {
        this.path = path;
        this.text = text;
    }

    public String getPath() {
        return path;
    }

    public String getText() {
        return text;
    }
}
