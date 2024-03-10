/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.report.core.coordinate;

import io.nop.api.core.annotations.data.DataBean;

@DataBean
public class CellCoordinate {
    private String cellName;
    private boolean reverse;
    private boolean relative;
    private int position;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        appendTo(sb);
        return sb.toString();
    }

    public void appendTo(StringBuilder sb) {
        sb.append(cellName);
        if (position != 0) {
            sb.append(':');
            if (reverse) {
                sb.append('!');
            }
            if (relative) {
                if (position > 0)
                    sb.append('+');
            }
            sb.append(position);
        }
    }

    public boolean isRelative() {
        return relative;
    }

    public void setRelative(boolean relative) {
        this.relative = relative;
    }

    public String getCellName() {
        return cellName;
    }

    public void setCellName(String cellName) {
        this.cellName = cellName;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public boolean isReverse() {
        return reverse;
    }

    public void setReverse(boolean reverse) {
        this.reverse = reverse;
    }
}