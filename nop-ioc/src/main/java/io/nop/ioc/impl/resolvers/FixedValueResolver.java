/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.ioc.impl.resolvers;

import io.nop.api.core.convert.ConvertHelper;
import io.nop.core.lang.xml.XNode;
import io.nop.ioc.api.IBeanContainerImplementor;
import io.nop.ioc.api.IBeanScope;
import io.nop.ioc.impl.IBeanPropValueResolver;

public class FixedValueResolver implements IBeanPropValueResolver {
    private final Object value;

    public FixedValueResolver(Object value) {
        this.value = value;
    }

    @Override
    public String toConfigString() {
        return ConvertHelper.toString(value);
    }

    @Override
    public XNode toConfigNode() {
        XNode node = XNode.make("value");
        node.setContentValue(value);
        return node;
    }

    @Override
    public Object resolveValue(IBeanContainerImplementor container, IBeanScope scope) {
        return value;
    }
}
