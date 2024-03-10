/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.dev.core;

import io.nop.api.core.annotations.core.Description;
import io.nop.api.core.config.IConfigReference;
import io.nop.api.core.util.SourceLocation;

import static io.nop.api.core.config.AppConfig.varRef;

public interface DevCoreConfigs {
    SourceLocation s_loc = SourceLocation.fromClass(DevCoreConfigs.class);
    @Description("开发工程的根目录，子模块全部存放在此目录下")
    IConfigReference<String> CFG_DEV_ROOT_PATH = varRef(s_loc, "nop.dev.root-path", String.class, null);
}
