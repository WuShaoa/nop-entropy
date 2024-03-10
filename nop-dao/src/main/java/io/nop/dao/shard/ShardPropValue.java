/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.dao.shard;

public class ShardPropValue {
    private final String shardProp;
    private final Object shardValue;

    public ShardPropValue(String shardProp, Object shardValue) {
        this.shardProp = shardProp;
        this.shardValue = shardValue;
    }

    public String getShardProp() {
        return shardProp;
    }

    public Object getShardValue() {
        return shardValue;
    }
}