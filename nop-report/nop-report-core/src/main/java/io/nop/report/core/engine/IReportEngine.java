/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.report.core.engine;

import io.nop.core.resource.tpl.ITemplateOutput;
import io.nop.core.resource.tpl.ITextTemplateOutput;
import io.nop.excel.model.ExcelWorkbook;
import io.nop.report.core.XptConstants;

public interface IReportEngine {
    /**
     * 获取xpt报表模型
     */
    ExcelWorkbook getXptModel(String reportPath);

    ITemplateOutput getRendererForXptModel(ExcelWorkbook workbook, String renderType);

    ITemplateOutput getRendererForExcel(ExcelWorkbook workbook, String renderType);


    default ITemplateOutput getRenderer(String reportPath, String renderType) {
        return getRendererForXptModel(getXptModel(reportPath), renderType);
    }

    default ITextTemplateOutput getHtmlRenderer(String reportPath) {
        return (ITextTemplateOutput) getRenderer(reportPath, XptConstants.RENDER_TYPE_HTML);
    }

    /**
     * 根据导入模板自动生成报表模型
     */
    ExcelWorkbook buildXptModelFromImpModel(String impModelPath);
}