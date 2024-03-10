/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.xlang.xpl;

public enum XplSlotType {
    node, renderer;

    public static XplSlotType fromText(String name) {
        for (XplSlotType value : values()) {
            if (value.name().equals(name))
                return value;
        }
        return null;
    }
}
