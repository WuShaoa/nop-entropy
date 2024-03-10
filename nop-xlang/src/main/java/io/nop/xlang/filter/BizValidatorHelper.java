/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.xlang.filter;

import io.nop.api.core.validate.IValidationErrorCollector;
import io.nop.commons.util.objects.ValueWithLocation;
import io.nop.core.context.IServiceContext;
import io.nop.core.lang.eval.IEvalAction;
import io.nop.core.lang.eval.IEvalScope;
import io.nop.core.lang.xml.XNode;
import io.nop.core.model.validator.ModelBasedValidator;
import io.nop.core.model.validator.ValidatorModel;
import io.nop.core.resource.component.ResourceComponentManager;
import io.nop.xlang.XLangConstants;
import io.nop.xlang.xdef.IXDefinition;
import io.nop.xlang.xdsl.DslModelParser;
import io.nop.xlang.xmeta.SchemaLoader;

public class BizValidatorHelper {

    /**
     * 在对象obj上运行validator
     *
     * @param validatorPath validator模型所对应的虚拟路径
     * @param obj           待验证的对象
     * @param context       服务上下文，可以从中获取userId,roles等信息
     */
    public static void runValidator(String validatorPath, Object obj, IServiceContext context) {
        ValidatorModel model = (ValidatorModel) ResourceComponentManager.instance().loadComponentModel(validatorPath);
        runValidatorModel(model, obj, context);
    }

    public static void runValidator(String validatorPath, IServiceContext context) {
        ValidatorModel model = (ValidatorModel) ResourceComponentManager.instance().loadComponentModel(validatorPath);
        Object obj;
        if (model.getObj() != null) {
            obj = model.getObj().invoke(context);
        } else {
            obj = context.getEvalScope();
        }

        runValidatorModel(model, obj, context);
    }

    public static ValidatorModel parseValidator(XNode node) {
        IXDefinition xdef = SchemaLoader.loadXDefinition(XLangConstants.XDSL_SCHEMA_VALIDATOR);
        DslModelParser parser = new DslModelParser();
        ValidatorModel model = (ValidatorModel) parser.parseWithXDef(xdef, node.cloneInstance());
        return model;
    }

    public static void runValidatorModel(ValidatorModel model, Object obj, IServiceContext context) {
        String checkLibPath = model.getCheckLibPath();
        if (checkLibPath == null)
            checkLibPath = BizFilterConstants.XLIB_BIZ_CHECK_PATH;
        new ModelBasedValidator(model, new BizFilterEvaluator(checkLibPath, context))
                .validateWithDefaultCollector(obj, model.getFatalSeverity());
    }

    public static void runValidatorModelForValue(ValidatorModel model, Object value, IEvalScope scope, IServiceContext ctx,
                                                 IValidationErrorCollector collector) {
        String checkLibPath = model.getCheckLibPath();
        if (checkLibPath == null)
            checkLibPath = BizFilterConstants.XLIB_BIZ_CHECK_PATH;

        ValueWithLocation vl = scope.recordValueLocation(BizFilterConstants.VAR_VALUE);
        try {
            scope.setLocalValue(BizFilterConstants.VAR_VALUE, value);
            new ModelBasedValidator(model, new BizFilterEvaluator(checkLibPath, ctx, scope)).validate(scope, collector);
        } finally {
            scope.restoreValueLocation(BizFilterConstants.VAR_VALUE, vl);
        }
    }

    public static IEvalAction toEvalAction(ValidatorModel model) {
        return ctx -> {
            runValidatorModel(model, ctx, IServiceContext.fromEvalContext(ctx));
            return null;
        };
    }
}
