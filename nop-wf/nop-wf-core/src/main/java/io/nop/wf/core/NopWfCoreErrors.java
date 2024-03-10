/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.wf.core;

import io.nop.api.core.exceptions.ErrorCode;

import static io.nop.api.core.exceptions.ErrorCode.define;

public interface NopWfCoreErrors {
    String ARG_WF_NAME = "wfName";
    String ARG_STEP_NAME = "stepName";
    String ARG_ACTION_NAME = "actionName";

    String ARG_OTHER_STEP_NAME = "otherStepName";

    String ARG_WF_VERSION = "wfVersion";

    String ARG_WF_ID = "wfId";
    String ARG_STEP_ID = "stepId";

    String ARG_CALLER_ID = "callerId";

    String ARG_ACTOR_NAME = "actorName";

    String ARG_OWNER_ID = "ownerId";

    String ARG_ACTOR_TYPE = "actorType";
    String ARG_ACTOR_ID = "actorId";

    String ARG_ACTOR_DEPT_ID = "actorDeptId";

    String ARG_ACTOR_MODEL_ID = "actorModelId";

    String ARG_USER_ID = "userId";

    String ARG_PARENT_STEP_ID = "parentStepId";

    String ARG_STEP_STATUS = "stepStatus";

    String ARG_WF_STATUS = "wfStatus";

    String ARG_WF_ACTOR_TYPE = "wfActorType";
    String ARG_WF_ACTOR_ID = "wfActorId";
    String ARG_ARG_NAME = "argName";

    String ARG_VALUE = "value";

    String ARG_REJECT_STEP = "rejectStep";

    String ARG_ACTOR_CANDIDATES = "actorCandidates";

    String ARG_TARGET_STEPS = "targetSteps";
    String ARG_TARGET_CASES = "targetCases";

    String ARG_LOOP_EDGES = "loopEdges";

    String ARG_TO_STEP_NAME = "toStepName";

    ErrorCode ERR_WF_STEP_INSTANCE_NOT_EXISTS =
            define("nop.err.wf.step-instance-not-exists",
                    "工作流[{wfName}]的步骤实例[{stepId}]不存在", ARG_WF_NAME, ARG_STEP_ID);

    ErrorCode ERR_WF_ALREADY_STARTED =
            define("nop.err.wf.already-started", "工作流已经启动，不能重复启动", ARG_WF_NAME, ARG_WF_ID);

    ErrorCode ERR_WF_NOT_ALLOW_START =
            define("nop.err.wf.not-allow-start",
                    "工作流不满足启动条件，不允许启动", ARG_WF_NAME, ARG_WF_ID);

    ErrorCode ERR_WF_ASSIGNMENT_DYNAMIC_RETURN_NOT_WF_ACTOR =
            define("nop.err.wf.assignment-dynamic-return-not-wf-actor",
                    "动态分配[{wfActorType}]返回的结果不是IWfActor或者IWfActor列表", ARG_WF_ACTOR_TYPE);

    ErrorCode ERR_WF_DYNAMIC_ACTOR_RESOLVE_TO_MULTIPLE_ACTOR =
            define("nop.err.wf.dynamic-actor-resolve-to-multiple-actor",
                    "动态参与者[{actorType}]对应的实际参与者必须是唯一的一个，不允许对应于多个参与者", ARG_ACTOR_TYPE);

    ErrorCode ERR_WF_UNKNOWN_ACTION_ARG =
            define("nop.err.wf.unknown-action-arg",
                    "执行工作流[{wfName}]的[{actionName}]操作时，参数[{argName}]没有定义",
                    ARG_WF_NAME, ARG_ACTION_NAME, ARG_ARG_NAME);

    ErrorCode ERR_WF_EMPTY_ACTION_ARG =
            define("nop.err.wf.empty-action-arg",
                    "执行工作流[{wfName}]的[{actionName}]操作时，参数[{argName}]为空",
                    ARG_WF_NAME, ARG_ACTION_NAME, ARG_ARG_NAME);

    ErrorCode ERR_WF_SELECTED_ACTOR_NOT_IN_ASSIGNMENT =
            define("nop.err.wf.selected-actor-not-in-assignment",
                    "选择的参与者[{wfActorType}:{wfActorId}]不在配置范围之内", ARG_WF_ACTOR_TYPE, ARG_WF_ACTOR_ID);

    ErrorCode ERR_WF_SELECTED_ACTOR_COUNT_NOT_ONE =
            define("nop.err.wf.selected-actor-count-not-one",
                    "选择的参与者个数不是1");

    ErrorCode ERR_WF_START_WF_FAIL =
            define("nop.err.wf.start-wf-fail", "启动工作流[{wfName}]失败", ARG_WF_NAME);

    ErrorCode ERR_WF_ASSIGNMENT_OWNER_EXPR_RESULT_NOT_WF_ACTOR =
            define("nop.err.wf.assignment-owner-expr-result-not-wf-actor",
                    "拥有者表达式的返回值类型不是IWfActor类型", ARG_VALUE);

    ErrorCode ERR_WF_STEP_NO_ASSIGNMENT =
            define("nop.err.wf.step-no-assignment", "工作流[{wfName}]的步骤[{stepName}]没有指定参与者",
                    ARG_WF_NAME, ARG_STEP_NAME);

    ErrorCode ERR_WF_UNKNOWN_ACTION =
            define("nop.err.wf.unknown-action", "工作流[{wfName}]中没有定义操作[{actionName}]",
                    ARG_WF_NAME, ARG_ACTION_NAME);

    ErrorCode ERR_WF_NOT_ALLOW_ACTION_IN_CURRENT_STEP_STATUS =
            define("nop.err.wf.not-allow-action-in-current-step-status",
                    "当前工作流[{wfName}]的步骤[{stepName}]的状态为[{stepStatus}]，不允许执行操作[{actionName}]",
                    ARG_WF_NAME, ARG_STEP_NAME, ARG_ACTION_NAME, ARG_STEP_STATUS);

    ErrorCode ERR_WF_NOT_ALLOW_ACTION_IN_CURRENT_STEP =
            define("nop.err.wf.not-allow-action-in-current-step",
                    "当前工作流[{wfName}]的步骤[{stepName}]不允许执行操作[{actionName}]",
                    ARG_WF_NAME, ARG_STEP_NAME, ARG_ACTION_NAME);
    ErrorCode ERR_WF_REJECT_ACTION_IS_NOT_ALLOWED =
            define("nop.err.wf.reject-action-is-not-allowed",
                    "工作流[{wfName}]的步骤[{stepName}]不允许执行退回操作[{actionName}]",
                    ARG_WF_NAME, ARG_STEP_NAME, ARG_ACTION_NAME);

    ErrorCode ERR_WF_WITHDRAW_ACTION_IS_NOT_ALLOWED =
            define("nop.err.wf.withdraw-action-is-not-allowed",
                    "工作流[{wfName}]的步骤[{stepName}]不允许执行撤回操作[{actionName}]",
                    ARG_WF_NAME, ARG_STEP_NAME, ARG_ACTION_NAME);

    ErrorCode ERR_WF_ACTION_CONDITIONS_NOT_PASSED =
            define("nop.err.wf.action-conditions-not-passed",
                    "工作流[{wfName}]的步骤[{stepName}]的操作[{actionName}]不满足执行条件",
                    ARG_WF_NAME, ARG_STEP_NAME, ARG_ACTION_NAME);

    ErrorCode ERR_WF_ACTION_NOT_ALLOWED_WHEN_SIGNAL_NOT_READY =
            define("nop.err.wf.action-not-allowed-when-signal-not-ready",
                    "工作流[{wfName}]的步骤[{stepName}]的操作[{actionName}]等待的信号没有被设置",
                    ARG_WF_NAME, ARG_STEP_NAME, ARG_ACTION_NAME);

    ErrorCode ERR_WF_UNKNOWN_STEP =
            define("nop.err.wf.unknown-step",
                    "工作流[{wfName}]中没有定义步骤[{stepName}]", ARG_WF_NAME, ARG_STEP_NAME);

    ErrorCode ERR_WF_REJECT_STEP_IS_NOT_ANCESTOR_OF_CURRENT_STEP =
            define("nop.err.wf.reject-step-is-not-ancestor-of-current-step",
                    "退回步骤[{rejectStep}]不是当前步骤[{stepName}]的前置步骤", ARG_WF_NAME, ARG_REJECT_STEP, ARG_STEP_NAME);

    ErrorCode ERR_WF_ACTION_TRANSITION_NO_NEXT_STEP =
            define("nop.err.wf.action-transition-no-next-step",
                    "工作流[{wfName}]执行操作[{actionName}]后没有有效的后续步骤", ARG_WF_NAME, ARG_ACTION_NAME);

    ErrorCode ERR_WF_TRANSITION_TARGET_STEPS_NOT_MATCH =
            define("nop.err.wf.transition-target-steps-not-match",
                    "没有匹配的目标步骤：{targetSteps}", ARG_TARGET_STEPS);

    ErrorCode ERR_WF_TRANSITION_TARGET_CASES_NOT_MATCH =
            define("nop.err.wf.transition-target-cases-not-match",
                    "没有匹配的目标步骤：{targetCases}", ARG_TARGET_CASES);

    ErrorCode ERR_WF_NOT_ALLOW_SUSPEND =
            define("nop.err.wf.not-allow-suspend", "工作流实例不允许暂停操作");

    ErrorCode ERR_WF_NOT_ALLOW_REMOVE =
            define("nop.err.wf.not-allow-remove", "正在运行的工作流实例不允许删除。需要先停止才能删除");

    ErrorCode ERR_WF_MISSING_WF_INSTANCE =
            define("nop.err.wf.missing-wf-instance", "工作流实例[{wfId}]不存在");

    ErrorCode ERR_WF_DUPLICATE_STEP_ID =
            define("nop.err.wf.duplicate-step-id", "步骤实例的id重复:{stepId}", ARG_STEP_ID);

    ErrorCode ERR_WF_TRANSITION_TO_UNKNOWN_STEP =
            define("nop.err.wf.transition-to-unknown-step", "迁移的目标步骤为未知步骤：{stepName}", ARG_STEP_NAME);

    ErrorCode ERR_WF_GRAPH_CONTAINS_LOOP =
            define("nop.err.wf.graph-contains-loop",
                    "流程图包含循环结构，不满足要求，需要删除以下连接:{loopEdges}", ARG_LOOP_EDGES);

    ErrorCode ERR_WF_STEP_NOT_ENDABLE =
            define("nop.err.wf.step-not-endable", "步骤{stepName}无法结束，会导致流程被挂起", ARG_STEP_NAME);

    ErrorCode ERR_WF_MISSING_PARENT_WF =
            define("nop.err.wf.missing-parent-wf", "父工作流不存在：wfId={wfId},wfName={wfName},wfVersion={wfVersion}",
                    ARG_WF_ID, ARG_WF_NAME, ARG_WF_VERSION);

    ErrorCode ERR_WF_MISSING_STEP_INSTANCE =
            define("nop.err.wf.missing-step-instance", "工作流[{wfName}]的实例[{wfId}]中没有步骤实例[{stepId}]",
                    ARG_WF_NAME, ARG_WF_ID, ARG_STEP_ID);

    ErrorCode ERR_WF_STEP_REF_ACTION_IS_COMMON =
            define("nop.err.wf.step-ref-action-is-common",
                    "流程步骤[{stepName}]中引用的动作[{actionName}]不允许是公共动作", ARG_STEP_NAME, ARG_ACTION_NAME);

    ErrorCode ERR_WF_MULTIPLE_STEP_REF_SAME_ACTION =
            define("nop.err.wf.multiple-step-ref-same-action",
                    "同一个动作[{actionName}]不允许被多个步骤所引用：[{stepName}]与[{otherStepName}]",
                    ARG_ACTION_NAME, ARG_STEP_NAME, ARG_OTHER_STEP_NAME);

    ErrorCode ERR_WF_UNKNOWN_WF_DEFINITION =
            define("nop.err.wf.unknown-wf-definition", "未知的工作流定义：{wfName},version={wfVersion}",
                    ARG_WF_NAME, ARG_WF_VERSION);

    ErrorCode ERR_WF_ACTOR_NOT_EXISTS =
            define("nop.err.wf.actor-not-exists", "参与者[{actorType}:{actorId}]不存在",
                    ARG_ACTOR_TYPE, ARG_ACTOR_ID);

    ErrorCode ERR_WF_USER_NOT_EXISTS =
            define("nop.err.wf.user-not-exists", "用户[{userId}]不存在", ARG_USER_ID);

    ErrorCode ERR_WF_NO_ACTOR_ASSIGNED_FOR_TRANSFER =
            define("nop.err.wf.no-actor-assigned-for-transfer", "没有指定参与者");

    ErrorCode ERR_WF_TRANSIT_TO_NO_TARGETS =
            define("nop.err.wf.transit-to-no-targets", "步骤迁移没有目标参与者，迁移失败", ARG_STEP_NAME);

    ErrorCode ERR_WF_NOT_ALLOW_CALL_ACTION_BY_USER =
            define("nop.err.wf.not-allow-call-action-by-user",
                    "步骤[{stepName}:{stepId}]不允许被用户[{callerId}]调用,步骤的参与者限定为[{actorType}:${actorId}]",
                    ARG_STEP_NAME, ARG_STEP_ID, ARG_CALLER_ID, ARG_ACTOR_TYPE, ARG_ACTOR_ID);
}
