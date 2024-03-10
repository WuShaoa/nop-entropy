/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.excel.imp;

import io.nop.core.model.table.CellRange;
import io.nop.core.model.table.ICellView;
import io.nop.excel.imp.model.IFieldContainer;
import io.nop.excel.imp.model.ImportFieldModel;
import io.nop.excel.imp.model.ImportSheetModel;

public interface ITableDataEventListener {
    void beginSheet(String sheetName, ImportSheetModel sheetModel);

    void endSheet(ImportSheetModel sheetModel);

    void beginList(int rowIndex, int colIndex, int maxRowIndex, int maxColIndex,
                   IFieldContainer fieldModel, boolean cardList);

    default void onColHeader(int rowIndex, int colIndex, LabelData labelData) {

    }

    default void onFieldLabel(int rowIndex, int colIndex, LabelData labelData) {

    }

    default void onFieldEnd(int rowIndex, int colIndex, LabelData labelData, CellRange range) {

    }

    void endList(int maxRowIndex, int maxColIndex, IFieldContainer fieldModel);

    void beginObject(int rowIndex, int colIndex, int maxRowIndex, int maxColIndex, IFieldContainer fieldModel);

    void endObject(IFieldContainer fieldModel);

    void simpleField(int rowIndex, int colIndex, ICellView cell, LabelData labelData);
}