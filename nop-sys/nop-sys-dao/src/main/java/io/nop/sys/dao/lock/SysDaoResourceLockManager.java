/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.sys.dao.lock;

import io.nop.commons.concurrent.lock.IResourceLock;
import io.nop.commons.concurrent.lock.IResourceLockManager;
import io.nop.commons.concurrent.lock.IResourceLockState;
import io.nop.commons.concurrent.lock.impl.IResourceLockManagerImplementor;

import jakarta.annotation.Nonnull;

public class SysDaoResourceLockManager implements IResourceLockManager, IResourceLockManagerImplementor {
    private long defaultWaitTime = 1000; // 1s
    private long defaultLeaseTime = 10000; // 10s

    public void setDefaultWaitTime(long defaultWaitTime) {
        this.defaultWaitTime = defaultWaitTime;
    }

    public void setDefaultLeaseTime(long defaultLeaseTime) {
        this.defaultLeaseTime = defaultLeaseTime;
    }

    @Override
    public long getDefaultWaitTime() {
        return defaultWaitTime;
    }

    @Override
    public long getDefaultLeaseTime() {
        return defaultLeaseTime;
    }

    @Override
    public IResourceLock getLock(@Nonnull String resourceId, String holderId) {
        return null;
    }

    @Override
    public IResourceLockState getLockState(@Nonnull String resourceId) {
        return null;
    }

    @Override
    public boolean forceUnlock(String resourceId) {
        return false;
    }

    @Override
    public IResourceLockState tryLockWithLease(String resourceId, String lockerId, long waitTime, long leaseTime) {
        return null;
    }

    @Override
    public boolean tryResetLease(IResourceLockState lock, long leaseTime) {
        return false;
    }

    @Override
    public boolean isHoldingLock(IResourceLockState lock) {
        return false;
    }

    @Override
    public void releaseLock(IResourceLockState lock) {

    }
}
