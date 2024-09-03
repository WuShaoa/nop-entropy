/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.ooxml.xlsx.output;

import io.nop.commons.bytes.ByteString;
import io.nop.core.context.IEvalContext;
import io.nop.core.lang.xml.XNode;
import io.nop.core.resource.IResource;
import io.nop.core.resource.impl.ByteArrayResource;
import io.nop.core.resource.impl.FileResource;
import io.nop.excel.ExcelConstants;
import io.nop.excel.model.ExcelImage;
import io.nop.excel.model.ExcelSheet;
import io.nop.excel.model.ExcelWorkbook;
import io.nop.excel.model.IExcelSheet;
import io.nop.ooxml.common.IOfficePackagePart;
import io.nop.ooxml.common.OfficeConstants;
import io.nop.ooxml.common.constants.ContentTypes;
import io.nop.ooxml.common.impl.XmlOfficePackagePart;
import io.nop.ooxml.common.model.ContentTypesPart;
import io.nop.ooxml.common.model.OfficeRelsPart;
import io.nop.ooxml.common.output.AbstractOfficeTemplate;
import io.nop.ooxml.xlsx.XSSFRelation;
import io.nop.ooxml.xlsx.model.ExcelOfficePackage;
import io.nop.ooxml.xlsx.model.StylesPart;
import io.nop.ooxml.xlsx.model.drawing.DrawingBuilder;

import java.io.File;
import java.util.List;
import java.util.Map;

import static io.nop.ooxml.common.model.PackagingURIHelper.createPartName;

public class ExcelTemplate extends AbstractOfficeTemplate {

    private final ExcelWorkbook workbook;
    private final ExcelOfficePackage modelPkg;
    private final IExcelSheetGenerator sheetGenerator;

    public ExcelTemplate(ExcelOfficePackage pkg, ExcelWorkbook workbook,
                         IExcelSheetGenerator sheetGenerator) {
        this.workbook = workbook;
        this.modelPkg = pkg;
        this.sheetGenerator = sheetGenerator;
        pkg.loadInMemory();
    }

    public ExcelTemplate(ExcelWorkbook workbook,
                         IExcelSheetGenerator sheetGenerator) {
        this(ExcelOfficePackage.loadEmpty(), workbook, sheetGenerator);
    }

    public ExcelTemplate(ExcelWorkbook workbook) {
        this(workbook, null);
    }

    @Override
    public void generateToDir(File dir, IEvalContext context) {
        ExcelOfficePackage pkg = this.modelPkg.copy();

        context.getEvalScope().setLocalValue(null, OfficeConstants.VAR_OFC_PKG, pkg);

        pkg.getWorkbook().clearSheets();

        GenState genState = new GenState();
        genState.pkg = pkg;

        if (sheetGenerator != null) {
            sheetGenerator.generate(context, (sheet, ctx) -> {
                int index = genState.nextSheetIndex++;
                generateSheet(dir, index, sheet, ctx, genState);
            });
        } else if (workbook != null) {
            for (ExcelSheet sheet : workbook.getSheets()) {
                int index = genState.nextSheetIndex++;
                generateSheet(dir, index, sheet, context, genState);
            }
        }

        if (workbook != null) {
            pkg.addFile(new StylesPart(workbook.getStyles()));
        }
        pkg.generateToDir(dir, context.getEvalScope());
    }

    private void generateSheet(File dir, int index, IExcelSheet sheet,
                               IEvalContext context, GenState genState) {

        ExcelOfficePackage pkg = genState.pkg;
        String sheetPath = pkg.addSheet(index, normalizeSheetName(sheet.getName(), index, context));

        int sheetId = index + 1;
        ContentTypesPart contentTypes = pkg.getContentTypes();
        String commentPath = "/xl/comments" + sheetId + ".xml";
        contentTypes.addContentType(createPartName(commentPath), XSSFRelation.SHEET_COMMENTS.getType());

        IResource resource = new FileResource(new File(dir, sheetPath));
        ExcelSheetWriter writer = new ExcelSheetWriter(sheet, index == 0, index, this.workbook);
        writer.indent(isIndent()).generateToResource(resource, context);
        IOfficePackagePart sheetPart = pkg.addFile(sheetPath, resource);

        generateDrawings(sheet.getImages(), writer.getDrawingRelId(), sheetPart, genState);

        IResource commentResource = new FileResource(new File(dir, commentPath));
        new ExcelCommentsWriter(sheet).indent(isIndent()).generateToResource(commentResource, context);
        pkg.addFile(commentPath, commentResource);

        String relCommentsPath = "../comments" + sheetId + ".xml";
        OfficeRelsPart sheetRels = pkg.makeRelsForPart(sheetPart);
        sheetRels.removeRelationshipByType(XSSFRelation.SHEET_COMMENTS.getRelation());
        sheetRels.addRelationship(XSSFRelation.SHEET_COMMENTS.getRelation(), relCommentsPath, null);
    }

    public String normalizeSheetName(String sheetName, int index, IEvalContext context) {
        Map<String, String> mapping = (Map<String, String>) context.getEvalScope().getValue(ExcelConstants.VAR_SHEET_NAME_MAPPING);
        if (mapping != null) {
            String mappedName = mapping.get(sheetName);
            if (mappedName != null)
                return mappedName;
        }
        return XlsxGenHelper.normalizeSheetName(sheetName, index, workbook);
    }

    public void generateDrawings(List<ExcelImage> images,
                                 String drawingRelId, IOfficePackagePart sheetPart, GenState genState) {
        if (images == null || images.isEmpty())
            return;

        ExcelOfficePackage pkg = genState.pkg;

        int drawingIndex = genState.nextDrawingIndex++;
        String drawingPath = "/xl/drawings/drawing" + (drawingIndex + 1) + ".xml";

        // <Override PartName="/xl/drawings/drawing1.xml"
        //              ContentType="application/vnd.openxmlformats-officedocument.drawing+xml"/>
        pkg.getContentTypes().addOverrideContentType(drawingPath, XSSFRelation.DRAWINGS.getType());

        OfficeRelsPart relPart = pkg.makeRelsForPart(sheetPart);
        relPart.addRelationship(drawingRelId, XSSFRelation.DRAWINGS.getRelation(), "../drawings/drawing" + (drawingIndex + 1) + ".xml", null);

        OfficeRelsPart drawingRelPart = pkg.makeRelsForPartPath(drawingPath);
        for (ExcelImage image : images) {
            if (image.getData() == null)
                continue;
            String[] pathAndId = addImageData(pkg, image.getData(), image.getImgType(), genState);
            if (pathAndId[1] == null) {
                pathAndId[1] = drawingRelPart.addImage("/" + pathAndId[0]).getId();
            }
            image.setEmbedId(pathAndId[1]);
        }

        XNode node = new DrawingBuilder().build(images);
        XmlOfficePackagePart part = new XmlOfficePackagePart(drawingPath.substring(1), node);
        pkg.addFile(part);

    }

    private String[] addImageData(ExcelOfficePackage pkg, ByteString data, String imgType, GenState genState) {
        String[] pathAndId = genState.images.get(data);
        if (pathAndId == null) {
            int index = genState.nextImageIndex++;
            if (imgType == null)
                imgType = ContentTypes.EXTENSION_PNG;
            IResource resource = new ByteArrayResource("/" + index, data.toByteArray(), -1);
            String path = pkg.addImage(imgType, resource);
            pathAndId = new String[]{path, null};
            genState.images.put(data, pathAndId);
        }
        return pathAndId;
    }
}