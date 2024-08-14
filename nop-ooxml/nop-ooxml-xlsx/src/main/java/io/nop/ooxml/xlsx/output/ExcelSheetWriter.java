/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.ooxml.xlsx.output;

import io.nop.api.core.util.ProcessResult;
import io.nop.commons.util.StringHelper;
import io.nop.commons.util.objects.ValueWithLocation;
import io.nop.core.context.IEvalContext;
import io.nop.core.lang.xml.IXNodeHandler;
import io.nop.core.model.table.CellPosition;
import io.nop.core.model.table.ICellView;
import io.nop.core.model.table.IColumnConfig;
import io.nop.core.model.table.IRowView;
import io.nop.core.resource.tpl.AbstractXmlTemplate;
import io.nop.excel.ExcelConstants;
import io.nop.excel.format.ExcelDateHelper;
import io.nop.excel.model.ExcelPageMargins;
import io.nop.excel.model.ExcelStyle;
import io.nop.excel.model.ExcelWorkbook;
import io.nop.excel.model.IExcelSheet;
import io.nop.excel.util.UnitsHelper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static io.nop.ooxml.xlsx.output.XlsxGenHelper.normalizeSheetName;

public class ExcelSheetWriter extends AbstractXmlTemplate {
    private final IExcelSheet sheet;
    private final boolean tabSelected;
    private final int sheetIndex;

    private final ExcelWorkbook workbook;

    private String drawingRelId;

    public ExcelSheetWriter(IExcelSheet sheet, boolean tabSelected, int sheetIndex, ExcelWorkbook workbook) {
        this.sheet = sheet;
        this.tabSelected = tabSelected;
        this.sheetIndex = sheetIndex;
        this.workbook = workbook;
    }

    public String getDrawingRelId() {
        return drawingRelId;
    }

    @Override
    public void generateXml(IXNodeHandler out, IEvalContext context) {
        out.beginDoc("UTF-8", null, null);

        Map<String, ValueWithLocation> attrs = new LinkedHashMap<>();
        attrs.put("xmlns", value("http://schemas.openxmlformats.org/spreadsheetml/2006/main"));
        attrs.put("xmlns:r", value("http://schemas.openxmlformats.org/officeDocument/2006/relationships"));
        attrs.put("xmlns:xdr", value("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing"));
        attrs.put("xmlns:x14", value("http://schemas.microsoft.com/office/spreadsheetml/2009/9/main"));
        attrs.put("xmlns:mc", value("http://schemas.openxmlformats.org/markup-compatibility/2006"));
        attrs.put("mc:Ignorable", value("x14ac xr xr2 xr3"));
        attrs.put("xmlns:x14ac", value("http://schemas.microsoft.com/office/spreadsheetml/2009/9/ac"));
        attrs.put("xmlns:xr", value("http://schemas.microsoft.com/office/spreadsheetml/2014/revision"));
        attrs.put("xmlns:xr2", value("http://schemas.microsoft.com/office/spreadsheetml/2015/revision2"));
        attrs.put("xmlns:xr3", value("http://schemas.microsoft.com/office/spreadsheetml/2016/revision3"));
        attrs.put("xr:uid", value("{" + UUID.randomUUID() + "}"));

        out.beginNode(null, "worksheet", attrs);
        out.simpleNode(null, "dimension", attrs("ref", sheet.getTable().getCellRange().toABString()));

        genSheetViews(out, sheet);
        genCols(out, sheet);
        genRows(out, sheet);
        genMergeCells(out, sheet);

        genLinks(out, sheet);

        genPageMargins(out, sheet);

        if (sheet.getImages() != null && !sheet.getImages().isEmpty()) {
            this.drawingRelId = "rId1";
            out.simpleNode(null, "drawing", attrs("r:id", this.drawingRelId));
        }
        out.endNode("worksheet");
        out.endDoc();
    }

    void genSheetViews(IXNodeHandler out, IExcelSheet sheet) {
        // <sheetViews><sheetView tabSelected="1" workbookViewId="0"><selection activeCell="A3" sqref="A3"/></sheetView></sheetViews>
        // <sheetFormatPr defaultRowHeight="14" x14ac:dyDescent="0.3"/>
        out.beginNode(null, "sheetViews", Collections.emptyMap());
        out.beginNode(null, "sheetView", attrs("tabSelected", tabSelected ? "1" : null, "workbookViewId", "0"));
        out.simpleNode(null, "selection", attrs("activeCell", "A1", "sqref", "A1"));
        out.endNode("sheetView");
        out.endNode("sheetViews");

        Double height = sheet.getDefaultRowHeight();
        if (height == null)
            height = 14.0;
        out.simpleNode(null, "sheetFormatPr", attrs("defaultRowHeight", height, "x14ac:dyDescent", "0.3"));
    }

    void genCols(IXNodeHandler out, IExcelSheet sheet) {
        List<? extends IColumnConfig> cols = sheet.getTable().getCols();
        if (cols != null && cols.size() > 0) {
            out.beginNode(null, "cols", Collections.emptyMap());
            // <cols><col min="1" max="1" width="13.6640625" bestFit="1" customWidth="1"/><col min="2" max="2" width="17.58203125" customWidth="1"/></cols>
            for (int i = 0, n = cols.size(); i < n; i++) {
                IColumnConfig col = cols.get(i);
                Double width = col == null ? null : col.getWidth();
                if (width == null)
                    width = sheet.getDefaultColumnWidth();
                Boolean hidden = col != null && col.isHidden() ? true : null;

                out.simpleNode(null, "col", attrs("min", i + 1, "max", i + 1, "width",
                        ptToCharWidth(width), "hidden", hidden,
                        "customWidth", width != null ? "1" : null));
            }
            out.endNode("cols");
        }
    }

    Double ptToCharWidth(Double d) {
        if (d == null)
            return null;

        return d / UnitsHelper.DEFAULT_CHARACTER_WIDTH_IN_PT;
    }

    void genRows(IXNodeHandler out, IExcelSheet sheet) {
        out.beginNode(null, "sheetData", Collections.emptyMap());
        List<? extends IRowView> rows = sheet.getTable().getRows();
        int colCount = sheet.getTable().getColCount();
        for (int i = 0, n = rows.size(); i < n; i++) {
            IRowView row = rows.get(i);
            Boolean hidden = row.isHidden() ? true : null;

            // <row r="1" spans="1:4" ht="38" customHeight="1" x14ac:dyDescent="0.3">
            out.beginNode(null, "row", attrs("r", i + 1, "spans", "1:" + colCount,
                    "ht", row.getHeight(), "customHeight", row.getHeight() != null ? "1" : null,
                    "hidden", hidden,
                    "x14ac:dyDescent", "0.3"));
            genCells(out, i, row);
            out.endNode("row");
        }
        out.endNode("sheetData");
    }

    void genCells(IXNodeHandler out, int rowIndex, IRowView row) {
        // <c r="A1" s="11"><v>44563</v></c>
        for (int i = 0, n = row.getColCount(); i < n; i++) {
            ICellView cell = row.getCell(i);
            if (cell == null)
                continue;

            if (cell.isProxyCell()) {
                ICellView ec = cell.getRealCell();
                // 保留border样式
                out.simpleNode(null, "c",
                        attrs("r", CellPosition.toABString(rowIndex, i, false, false),
                                "s", normalizeStyleId(ec)));
                continue;
            }

            ExcelStyle style = workbook.getStyle(cell.getStyleId());

            ICellView ec = cell;
            String cellType = null;

            // 优先输出格式化后的值
            Object value = ec.isExportFormattedValue() ? ec.getFormattedValue() : ec.getValue();

            String str = null;
            if (value instanceof Boolean) {
                cellType = "b";
                str = ((Boolean) value) ? "1" : "0";
            } else if (value instanceof Number) {
                cellType = "n";
                str = value.toString();
            } else if (value instanceof String) {
                str = value.toString();
                cellType = "inlineStr";
            } else if (value instanceof Collection) {
                str = StringHelper.join((Collection) value, ",");
                cellType = "inlineStr";
            } else if (value instanceof LocalDateTime && style != null && style.isDateFormat()) {
                str = String.valueOf(ExcelDateHelper.localDateTimeToExcelDate((LocalDateTime) value));
                cellType = "n";
            } else if (value != null) {
                str = value.toString();
                cellType = "inlineStr";
            }

            String formula = ec.getFormula();

            out.beginNode(null, "c",
                    attrs("r", CellPosition.toABString(rowIndex, i, false, false),
                            "s", normalizeStyleId(ec), "t", cellType));

            if (!StringHelper.isEmpty(formula)) {
                out.beginNode(null, "f", Collections.emptyMap());
                out.value(null, formula);
                out.endNode("f");
            }

            if ("inlineStr".equals(cellType)) {
                out.beginNode(null, "is", Collections.emptyMap());
                out.beginNode(null, "t", Collections.emptyMap());
                out.value(null, str);
                out.endNode("t");
                out.endNode("is");
            } else if (cellType != null) {
                out.beginNode(null, "v", Collections.emptyMap());
                out.value(null, str);
                out.endNode("v");
            }
            out.endNode("c");
        }
    }

    String normalizeStyleId(ICellView cell) {
        String styleId = cell.getStyleId();
        if (StringHelper.isEmpty(styleId))
            return styleId;

        ExcelStyle style = workbook.getStyle(styleId);
        if (style != null) {
            int index = workbook.getStyles().indexOf(style);
            return String.valueOf(index);
        }
        return styleId;
    }

    void genMergeCells(IXNodeHandler out, IExcelSheet sheet) {
        // <mergeCells count="1"><mergeCell ref="A6:B7"/></mergeCells>
        List<String> cells = new ArrayList<>();
        sheet.getTable().forEachRealCell((cell, rowIndex, colIndex) -> {
            if (cell.getMergeAcross() > 0 || cell.getMergeDown() > 0) {
                cells.add(CellPosition.toABString(rowIndex, colIndex) + ":" +
                        CellPosition.toABString(rowIndex + cell.getMergeDown(), colIndex + cell.getMergeAcross()));
            }
            return ProcessResult.CONTINUE;
        });

        if (!cells.isEmpty()) {
            out.beginNode(null, "mergeCells", attrs("count", cells.size()));
            for (String cell : cells) {
                out.simpleNode(null, "mergeCell", attrs("ref", cell));
            }
            out.endNode("mergeCells");
        }
    }

    void genPageMargins(IXNodeHandler out, IExcelSheet sheet) {
        ExcelPageMargins margins = sheet.getPageMargins();
        if (margins != null) {
            out.simpleNode(null, "pageMargins", attrs("left", margins.getLeft(), "right", margins.getRight(),
                    "top", margins.getTop(), "bottom", margins.getBottom(), "header", margins.getHeader(),
                    "footer", margins.getFooter()));
        }
    }

    /**
     * <hyperlink ref="B2" location="nop_wf_instance!A1" display="a" xr:uid="{074F63BF-E89D-4D35-AB00-86F3F72AF403}"/>
     * <hyperlink ref="B3" location="wf_status" display="dd" xr:uid="{1E0AC103-9F7F-465F-9C86-64335D36742B}"/>
     * <hyperlink ref="B4" r:id="rId1" xr:uid="{600CE871-0B2C-47DB-A4AB-A39BD76FEFE9}"/>
     */
    void genLinks(IXNodeHandler out, IExcelSheet sheet) {
        List<Link> links = new ArrayList<>();
        sheet.getTable().forEachRealCell((cell, rowIndex, colIndex) -> {
            String linkUrl = cell.getLinkUrl();
            if (linkUrl != null && linkUrl.startsWith(ExcelConstants.REF_LINK_PREFIX)) {
                String location = linkUrl.substring(ExcelConstants.REF_LINK_PREFIX.length());
                Link link = new Link();
                link.index = links.size();
                link.rowIndex = rowIndex;
                link.colIndex = colIndex;
                link.location = location;
                link.text = cell.getText();

                if (location.indexOf('!') > 0) {
                    links.add(link);
                }
            }
            return ProcessResult.CONTINUE;
        });

        if (!links.isEmpty()) {
            out.beginNode("hyperlinks");
            links.forEach(link -> {
                Map<String, ValueWithLocation> attrs = new LinkedHashMap<>();
                attrs.put("ref", ValueWithLocation.of(null, CellPosition.toABString(link.rowIndex, link.colIndex)));
                attrs.put("location", ValueWithLocation.of(null, normalizeLocation(link.location)));
                attrs.put("display", ValueWithLocation.of(null, link.text));
                attrs.put("xr:id", ValueWithLocation.of(null, intToUUID(link.index)));
                out.simpleNode(null, "hyperlink", attrs);
            });
            out.endNode("hyperlinks");
        }
    }

    private String normalizeLocation(String location) {
        int pos = location.indexOf('!');
        if (pos > 0) {
            String abPos = location.substring(pos + 1);
            try {
                CellPosition.fromABString(abPos);
                String sheetName = location.substring(0, pos);
                return normalizeSheetName(sheetName, sheetIndex, workbook) + '!' + abPos;
            } catch (Exception e) {
                return location;
            }
        }
        return location;
    }

    static class Link {
        int index;
        int rowIndex;
        int colIndex;
        String text;
        String location;
    }

    public static String intToUUID(int number) {
        // 第一步：获取整数的哈希码
        int hashCode = Integer.hashCode(number);

        // 第二步：将哈希码扩展到128位
        // 注意：这里只是一个示例，实际的哈希算法可能需要更复杂的逻辑来确保分布均匀
        long mostSigBits = hashCode & 0xFFFFFFFFL;
        long leastSigBits = (hashCode ^ 0xFFFFFFFFL) & 0xFFFFFFFFL;

        // 第三步：为了符合UUID的版本4（随机）格式，我们需要设置特定的位
        mostSigBits |= 0x4000L << 48; // 设置版本位为4
        leastSigBits |= 0x8000000000000000L; // 设置变体位

        // 第四步：使用UUID的静态方法来构造UUID
        UUID uuid = new UUID(mostSigBits, leastSigBits);
        return "{" + uuid + "}";
    }
}