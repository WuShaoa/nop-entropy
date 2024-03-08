/**
 * Copyright (c) 2017-2023 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-chaos
 * Github: https://github.com/entropy-cloud/nop-chaos
 */
package io.nop.record.output;

import java.io.Closeable;
import java.nio.ByteBuffer;

public interface IRecordBinaryOutput extends Closeable {
    IRecordBinaryOutput append(byte[] bytes);

    IRecordBinaryOutput append(byte[] str, int start, int end);

    IRecordBinaryOutput append(byte c);

    IRecordBinaryOutput append(ByteBuffer buf);
}
