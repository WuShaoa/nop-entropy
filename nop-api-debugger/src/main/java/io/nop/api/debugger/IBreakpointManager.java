/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.api.debugger;

import io.nop.api.core.annotations.core.Name;
import io.nop.api.core.util.SourceLocation;

import java.util.List;

public interface IBreakpointManager {
    void addBreakpoint(@Name("bp") Breakpoint bp);

    void removeBreakpoint(@Name("bp") Breakpoint bp);

    /**
     * 清除当前所有断点，然后设置新的断点
     *
     * @param bps 断点集合
     */
    void setBreakpoints(@Name("bps") List<Breakpoint> bps);

    List<Breakpoint> getBreakpoints();

    void clearBreakpoints();

    Breakpoint getBreakpointAt(@Name("loc") SourceLocation loc);
}