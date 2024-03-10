/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.wf.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.nop.api.core.annotations.data.DataBean;

import java.io.Serializable;

@DataBean
public class WfStepReference implements Serializable {

    private static final long serialVersionUID = 5073441321371891430L;

    private final String wfName;
    private final Long wfVersion;
    private final String wfId;
    private final String stepId;

    public WfStepReference(@JsonProperty("wfName") String wfName,
                           @JsonProperty("wfVersion") Long wfVersion,
                           @JsonProperty("wfId") String wfId,
                           @JsonProperty("stepId") String stepId) {
        this.wfName = wfName;
        this.wfVersion = wfVersion;
        this.wfId = wfId;
        this.stepId = stepId;
    }

    public String toString() {
        return wfName + '-' + wfVersion + ":" + wfId + ":" + stepId;
    }

    public String getWfName() {
        return wfName;
    }

    public Long getWfVersion() {
        return wfVersion;
    }

    public String getWfId() {
        return wfId;
    }

    public String getStepId() {
        return stepId;
    }

}