/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.api.core.time;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DefaultSysCalendar implements ISysCalendar {
    public static DefaultSysCalendar INSTANCE = new DefaultSysCalendar();

    public static DefaultSysCalendar instance() {
        return INSTANCE;
    }

    @Override
    public boolean isWorkDay(LocalDate date) {
        return true;
    }

    @Override
    public LocalDate nextWorkDay(LocalDate date) {
        return date.plusDays(1);
    }

    @Override
    public LocalDate getSysDate() {
        return LocalDate.now();
    }

    @Override
    public LocalDateTime getSysDateTime() {
        return LocalDateTime.now();
    }
}
