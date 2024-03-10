/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.stream.cep.model;

/**
 *
 *  举例来说，模式"a b"，给定事件序列"a"，"c"，"b1"，"b2"，会产生如下的结果：
 *
 *  <li> "a"和"b"之间严格连续： {} （没有匹配），"a"之后的"c"导致"a"被丢弃。</li>
 *
 *  <li> "a"和"b"之间松散连续： {a b1}，松散连续会"跳过不匹配的事件直到匹配上的事件"。</li>
 *
 *  <li> "a"和"b"之间不确定的松散连续： {a b1}, {a b2}，这是最常见的情况。</li>
 *
 *
 *  对于循环模式（例如oneOrMore()和times())），默认是松散连续。如果想使用严格连续，你需要使用consecutive()方法明确指定， 如果想使用不确定松散连续，你可以使用allowCombinations()方法
 *
 */
public enum FollowKind {
    /**
     * 严格连续, 期望所有匹配的事件严格的一个接一个出现，中间没有任何不匹配的事件。
     */
    next,

    /**
     * 松散连续: 忽略匹配的事件之间的不匹配的事件。
     */
    followedBy,

    /**
     * 不确定的松散连续: 更进一步的松散连续，允许忽略掉一些匹配事件的附加匹配。
     */
    followedByAny,

    /**
     * 如果不想后面直接连着一个特定事件
     */
    notNext,

    /**
     * 如果不想一个特定事件发生在两个事件之间的任何地方
     */
    notFollowedBy,
}
