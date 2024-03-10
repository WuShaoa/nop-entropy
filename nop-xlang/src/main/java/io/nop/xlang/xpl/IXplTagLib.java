/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.xlang.xpl;

import io.nop.api.core.util.IComponentModel;
import io.nop.xlang.ast.ImportAsDeclaration;

import java.util.List;
import java.util.Map;

public interface IXplTagLib extends IComponentModel {
    List<ImportAsDeclaration> getImportExprs();

    Map<String, ? extends IXplTag> getTags();

    IXplTag getTag(String tagName);
}