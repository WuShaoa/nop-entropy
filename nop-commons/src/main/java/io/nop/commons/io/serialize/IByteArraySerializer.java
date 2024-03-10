/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.commons.io.serialize;

public interface IByteArraySerializer {
    byte[] serializeToByteArray(Object o);

    Object deserializeFromByteArray(byte[] data);

    default <T> T deserializeFromByteArray(byte[] data, Class<T> clazz) {
        return (T) deserializeFromByteArray(data);
    }
}