/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.sys.dao.i18n;

import io.nop.core.i18n.I18nMessageManager;
import io.nop.dao.api.IDaoProvider;
import io.nop.sys.dao.entity.NopSysI18n;

import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SysI18nMessageLoader {
    @Inject
    IDaoProvider daoProvider;

    @PostConstruct
    public void init() {
        List<NopSysI18n> messages = daoProvider.daoFor(NopSysI18n.class).findAll();
        Map<String, Map<String, String>> map = new HashMap<>();
        for (NopSysI18n i18n : messages) {
            map.computeIfAbsent(i18n.getI18nLocale(), k -> new HashMap<>()).put(i18n.getI18nKey(), i18n.getValue());
        }

        for (Map.Entry<String, Map<String, String>> entry : map.entrySet()) {
            I18nMessageManager.instance().registerMessages(entry.getKey(), entry.getValue());
        }
    }

}
