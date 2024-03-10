/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.batch.core.consumer;

import io.nop.batch.core.IBatchConsumer;

import java.util.List;

public final class MultiBatchConsumer<R, C> implements IBatchConsumer<R, C> {
    private final List<IBatchConsumer<R, C>> list;

    public MultiBatchConsumer(List<IBatchConsumer<R, C>> list) {
        this.list = list;
    }

    public List<IBatchConsumer<R, C>> getConsumers() {
        return list;
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public int size(){
        return list.size();
    }

    public IBatchConsumer<R,C> first(){
        return list.get(0);
    }
    @Override
    public void consume(List<R> items, C context) {
        for (IBatchConsumer<R, C> consumer : list) {
            consumer.consume(items, context);
        }
    }
}
