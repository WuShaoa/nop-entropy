/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.wf.service.mock;

import io.nop.api.core.util.Guard;
import io.nop.wf.api.actor.IWfActor;
import io.nop.wf.api.actor.IWfActorResolver;
import io.nop.wf.api.actor.WfActorBean;
import io.nop.wf.api.actor.WfUserActorBean;

public class MockWfActorResolver implements IWfActorResolver {
    @Override
    public IWfActor resolveUser(String userId) {
        WfUserActorBean user = new WfUserActorBean();
        user.setActorId(userId);
        user.setActorName(userId);
        return user;
    }

    @Override
    public IWfActor resolveActor(String actorType, String actorId, String deptId) {
        if (actorType.equals(IWfActor.ACTOR_TYPE_USER)) {
            return resolveUser(actorId);
        }

        Guard.checkArgument(actorType.indexOf(':') < 0);

        WfActorBean actor = new WfActorBean();
        actor.setActorType(actorType);
        actor.setActorId(actorId);
        actor.setDeptId(deptId);
        return actor;
    }

    @Override
    public IWfActor getManager(IWfActor actor, int upLevel) {
        return null;
    }

    @Override
    public IWfActor getDeptManager(IWfActor actor, int upLevel) {
        return null;
    }
}
