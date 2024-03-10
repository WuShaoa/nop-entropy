/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.api.core.beans;

import io.nop.api.core.util.ISourceLocationGetter;
import io.nop.api.core.util.ISourceLocationSetter;

import java.util.List;
import java.util.Map;

public interface ITreeBean extends ISourceLocationGetter, ISourceLocationSetter {
    String getTagName();

    void setTagName(String tagName);

    Map<String, Object> getAttrs();

    Object getAttr(String name);

    Object getContentValue();

    List<? extends ITreeBean> getChildren();

    default int getChildCount() {
        List<?> children = getChildren();
        return children == null ? 0 : children.size();
    }

    TreeBean toTreeBean();

    ITreeBean cloneInstance();

    Object toJsonObject();
}
