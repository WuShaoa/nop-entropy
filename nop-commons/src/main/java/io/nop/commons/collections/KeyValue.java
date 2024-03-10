/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.commons.collections;

import io.nop.api.core.annotations.data.DataBean;
import io.nop.api.core.util.Guard;
import io.nop.commons.util.StringHelper;

import java.io.Serializable;
import java.util.Objects;

@DataBean
public class KeyValue implements Serializable {
    private final String key;
    private final String value;

    public KeyValue(String key, String value) {
        this.key = Guard.notEmpty(key, "");
        this.value = value == null ? "" : value;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        output(sb, key);
        sb.append('=');
        output(sb, value);
        sb.append(']');
        return sb.toString();
    }

    private void output(StringBuilder sb, String v) {
        String encValue = StringHelper.escapeJava(v);
        if (Objects.equals(encValue, v)) {
            // 不包含转义字符则直接输出
            sb.append(v);
        } else {
            sb.append('"');
            sb.append(v);
            sb.append('"');
        }
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public int hashCode() {
        return key.hashCode() * 31 + value.hashCode();
    }

    public boolean equals(Object o) {
        if (o == this)
            return true;

        if (!(o instanceof KeyValue))
            return false;

        KeyValue other = (KeyValue) o;
        return key.equals(other.key) && value.equals(other.value);
    }
}
