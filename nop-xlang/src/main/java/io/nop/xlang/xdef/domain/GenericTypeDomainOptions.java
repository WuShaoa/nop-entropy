/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.xlang.xdef.domain;

import io.nop.api.core.beans.DictBean;
import io.nop.core.dict.EnumDictLoader;
import io.nop.core.reflect.IClassModel;
import io.nop.core.reflect.IFunctionModel;
import io.nop.core.reflect.ReflectionManager;
import io.nop.core.reflect.impl.DefaultClassResolver;
import io.nop.core.type.IGenericType;
import io.nop.xlang.xdef.IStdDomainOptions;

public class GenericTypeDomainOptions implements IStdDomainOptions {
    private final IGenericType genericType;
    private DictBean dictBean;

    public GenericTypeDomainOptions(IGenericType genericType) {
        this.genericType = genericType;
    }

    public IGenericType getGenericType() {
        return genericType;
    }

    public String getTypeName() {
        return genericType.getTypeName();
    }

    @Override
    public String toString() {
        return genericType.toString();
    }

    public IFunctionModel getFactoryMethod() {
        IClassModel classModel = ReflectionManager.instance().loadClassModel(genericType.getTypeName());
        return classModel.getFactoryMethod();
    }

    public DictBean loadDictBean() {
        if (dictBean == null) {
            if (!genericType.isResolved())
                genericType.resolve(DefaultClassResolver.INSTANCE);
            dictBean = EnumDictLoader.INSTANCE.loadDict(null, genericType.getTypeName(), null);
        }
        return dictBean;
    }
}
