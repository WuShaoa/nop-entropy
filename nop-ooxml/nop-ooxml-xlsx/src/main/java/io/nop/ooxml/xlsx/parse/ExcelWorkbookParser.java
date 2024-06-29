/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.ooxml.xlsx.parse;

import io.nop.api.core.exceptions.NopException;
import io.nop.api.core.util.SourceLocation;
import io.nop.commons.bytes.ByteString;
import io.nop.commons.util.StringHelper;
import io.nop.core.lang.eval.DisabledEvalScope;
import io.nop.core.model.table.CellPosition;
import io.nop.core.model.table.CellRange;
import io.nop.core.model.table.ICell;
import io.nop.core.model.table.ICellView;
import io.nop.excel.ExcelConstants;
import io.nop.excel.format.ExcelDateHelper;
import io.nop.excel.model.ExcelCell;
import io.nop.excel.model.ExcelColumnConfig;
import io.nop.excel.model.ExcelImage;
import io.nop.excel.model.ExcelPageMargins;
import io.nop.excel.model.ExcelRow;
import io.nop.excel.model.ExcelSheet;
import io.nop.excel.model.ExcelStyle;
import io.nop.excel.model.ExcelTable;
import io.nop.excel.model.ExcelWorkbook;
import io.nop.excel.util.UnitsHelper;
import io.nop.ooxml.common.IOfficePackagePart;
import io.nop.ooxml.xlsx.model.CommentsPart;
import io.nop.ooxml.xlsx.model.WorkbookPart;
import io.nop.ooxml.xlsx.model.XSSFSheetRef;
import io.nop.ooxml.xlsx.model.drawing.DrawingParser;

import java.util.List;

import static io.nop.ooxml.xlsx.XlsxErrors.ARG_REL_ID;
import static io.nop.ooxml.xlsx.XlsxErrors.ARG_TYPE;
import static io.nop.ooxml.xlsx.XlsxErrors.ERR_XLSX_NULL_REL_PART;

public class ExcelWorkbookParser extends AbstractXlsxParser {
    @Override
    protected ExcelSheet parseSheet(ExcelWorkbook workbook, XSSFSheetRef sheetRef, WorkbookPart workbookFile) {
        IOfficePackagePart sheetPart = pkg.getRelPart(workbookFile, sheetRef.getRelId());
        if (sheetPart == null)
            throw new NopException(ERR_XLSX_NULL_REL_PART).param(ARG_TYPE, "sheet").param(ARG_REL_ID, sheetRef.getRelId());
        CommentsPart comments = pkg.getCommentsTable(sheetPart);

        SimpleSheetContentsHandler contentsHandler = new SimpleSheetContentsHandler(workbook, sheetRef.getName());

        SheetNodeHandler handler = new SheetNodeHandler(sharedStringsTable, contentsHandler);
        sheetPart.processXml(handler, null);

        ExcelSheet sheet = contentsHandler.getSheet();
        sheet.setLocation(pkg.getLocation());
        sheet.setDefaultColumnWidth(ExcelConstants.DEFAULT_COL_WIDTH * UnitsHelper.DEFAULT_CHARACTER_WIDTH_IN_PT);

        if (comments != null) {
            comments.forEachComment((cellPos, comment) -> {
                ICellView cell = sheet.getTable().getCell(cellPos.getRowIndex(), cellPos.getColIndex());
                if (cell != null) {
                    ExcelCell ec = (ExcelCell) cell.getRealCell();
                    ec.setComment(comment.getComment());
                } else {
                    ExcelCell ec = new ExcelCell();
                    ec.setLocation(new SourceLocation(workbook.resourcePath(), 0, 0, 0, 0,
                            sheet.getName(), cellPos.toABString(), null));
                    ec.setComment(comment.getComment());
                    sheet.getTable().setCell(cellPos.getRowIndex(), cellPos.getColIndex(), ec);
                }
            });
        }

        if (contentsHandler.getDrawingId() != null) {
            IOfficePackagePart drawing = pkg.getRelPart(sheetPart, contentsHandler.getDrawingId());
            if (drawing != null) {
                List<ExcelImage> images = new DrawingParser().parseDrawing(drawing.loadXml());
                for (ExcelImage image : images) {
                    if (image.getEmbedId() == null)
                        continue;

                    IOfficePackagePart imagePart = pkg.getRelPart(drawing, image.getEmbedId());
                    if (imagePart == null)
                        continue;
                    image.setImgType(StringHelper.fileExt(imagePart.getPath()));
                    image.setData(ByteString.of(imagePart.generateBytes(DisabledEvalScope.INSTANCE)));
                    image.calcSize(sheet);
                }
                sheet.setImages(images);
            }
        }

        return sheet;
    }

    static class SimpleSheetContentsHandler implements SheetContentsHandler {
        private final ExcelWorkbook workbook;

        private final ExcelSheet sheet = new ExcelSheet();
        private ExcelTable table = sheet.getTable();

        private String drawingId;

        public SimpleSheetContentsHandler(ExcelWorkbook workbook, String sheetName) {
            this.workbook = workbook;
            this.sheet.setName(sheetName);
        }

        public ExcelSheet getSheet() {
            return sheet;
        }

        public String getDrawingId() {
            return drawingId;
        }

        public void drawing(String id) {
            this.drawingId = StringHelper.emptyAsNull(id);
        }

        @Override
        public void startSheet(String sheetName) {
            this.sheet.setName(sheetName);
        }

        @Override
        public void cols(List<ExcelColumnConfig> cols) {
            table.setCols(cols);
        }

        @Override
        public void pageMargins(ExcelPageMargins pageMargins) {
            sheet.setPageMargins(pageMargins);
        }

        @Override
        public void sheetFormat(Double defaultRowHeight) {
            sheet.setDefaultRowHeight(defaultRowHeight);
        }

        @Override
        public void startRow(int rowNum, Double height, boolean hidden) {
            ExcelRow row = table.makeRow(rowNum);
            row.setHeight(height);
            row.setHidden(hidden);
        }

        @Override
        public void endRow(int rowNum) {
        }

        @Override
        public void cell(CellPosition cellRef, Object value, String formulaStr, int styleId) {
            ExcelCell cell = table.newCell();
            cell.setFormula(formulaStr);
            cell.setLocation(new SourceLocation(workbook.resourcePath(), 0, 0, 0, 0,
                    sheet.getName(), cellRef.toABString(), null));
            if (styleId >= 0) {
                cell.setStyleId(String.valueOf(styleId));
                if (value instanceof Double) {
                    ExcelStyle style = workbook.getStyle(cell.getStyleId());
                    if (style != null && style.isDateFormat()) {
                        value = ExcelDateHelper.excelDateToLocalDateTime((Double) value);
                    }
                }
            }
            cell.setValue(value);
            table.setCell(cellRef.getRowIndex(), cellRef.getColIndex(), cell);
        }

        @Override
        public void mergeCell(CellRange range) {
            ExcelCell ec = (ExcelCell) table.getCell(range.getFirstRowIndex(), range.getFirstColIndex());
            ICell lastCell = table.getCell(range.getLastRowIndex(), range.getLastColIndex());
            if (lastCell != null) {
                ExcelCell ec2 = (ExcelCell) lastCell.getRealCell();
                ExcelStyle style = getStyle(workbook, ec);
                ExcelStyle style2 = getStyle(workbook, ec2);
                if (style != null && style2 != null) {
                    style.setRightBorder(style2.getRightBorder());
                    style.setBottomBorder(style2.getBottomBorder());
                }
            }
            table.mergeCell(range);
        }

        ExcelStyle getStyle(ExcelWorkbook wk, ExcelCell ec) {
            String styleId = ec.getStyleId();
            if (styleId == null)
                return null;
            return wk.getStyle(styleId);
        }
    }

}