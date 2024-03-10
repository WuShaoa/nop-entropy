/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.rpc.grpc.proto.marshaller;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import io.nop.commons.type.BinaryScalarType;
import io.nop.rpc.grpc.proto.IFieldMarshaller;

import java.io.IOException;

public class FloatFieldMarshaller implements IFieldMarshaller {
    public static FloatFieldMarshaller INSTANCE = new FloatFieldMarshaller();

    @Override
    public String getGrpcTypeName(){
        return "float";
    }
    @Override
    public boolean isObject() {
        return false;
    }

    @Override
    public Object readField(CodedInputStream in) throws IOException {
        return in.readFloat();
    }

    @Override
    public void writeField(CodedOutputStream out, int propId, Object value) throws IOException {
        out.writeFloat(propId, (Float) value);
    }

    @Override
    public void writeFieldNoTag(CodedOutputStream out, Object value) throws IOException {
        out.writeFloatNoTag((Float) value);
    }

    @Override
    public int computeSize(int propId, Object value) {
        return CodedOutputStream.computeFloatSize(propId, (Float) value);
    }

    @Override
    public int computeSizeNoTag(Object value) {
        return CodedOutputStream.computeFloatSizeNoTag((Float) value);
    }

    @Override
    public BinaryScalarType getBinaryScalarType() {
        return BinaryScalarType.FLOAT;
    }
}
