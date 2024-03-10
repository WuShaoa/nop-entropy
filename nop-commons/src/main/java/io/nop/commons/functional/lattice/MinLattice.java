/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.commons.functional.lattice;

import java.util.Objects;

public class MinLattice<T extends Comparable<T>> implements ILattice<T> {
    private T value;

    public MinLattice() {
    }

    public MinLattice(T value) {
        this.value = value;
    }

    public MinLattice<T> cloneInstance() {
        return new MinLattice<>(value);
    }

    @Override
    public T bot() {
        return null;
    }

    public T value() {
        return value;
    }

    public int hashCode() {
        return value == null ? 0 : value.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;

        if (!(o instanceof MinLattice))
            return false;
        MinLattice<T> other = (MinLattice<T>) o;

        return Objects.equals(value, other.value);
    }

    @Override
    public void merge(T e) {
        if (e == null)
            return;

        if (value == null) {
            value = e;
            return;
        }

        if (value.compareTo(e) > 0) {
            value = e;
        }
    }

    @Override
    public void assign(T e) {
        this.value = e;
    }
}