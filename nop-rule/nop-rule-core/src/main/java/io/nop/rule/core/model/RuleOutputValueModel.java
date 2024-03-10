/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.rule.core.model;

import io.nop.rule.core.model._gen._RuleOutputValueModel;
import io.nop.xlang.xmeta.ObjVarDefineModel;

public class RuleOutputValueModel extends _RuleOutputValueModel {

    private RuleOutputDefineModel varModel;

    public RuleOutputValueModel() {

    }

    public RuleOutputDefineModel getVarModel() {
        return varModel;
    }

    public void setVarModel(RuleOutputDefineModel varModel) {
        this.varModel = varModel;
    }
}