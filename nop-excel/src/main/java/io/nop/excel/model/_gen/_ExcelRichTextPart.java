package io.nop.excel.model._gen;

import io.nop.commons.collections.KeyedList; //NOPMD NOSONAR - suppressed UnusedImports - Used for List Prop
import io.nop.core.lang.json.IJsonHandler;
import io.nop.excel.model.ExcelRichTextPart;
import io.nop.commons.util.ClassHelper;



// tell cpd to start ignoring code - CPD-OFF
/**
 * generate from /nop/schema/excel/excel-table.xdef <p>
 * 
 */
@SuppressWarnings({"PMD.UselessOverridingMethod","PMD.UnusedLocalVariable",
    "PMD.UnnecessaryFullyQualifiedName","PMD.EmptyControlStatement","java:S116","java:S101","java:S1128","java:S1161"})
public abstract class _ExcelRichTextPart extends io.nop.core.resource.component.AbstractComponentModel {
    
    /**
     *  
     * xml name: font
     * 
     */
    private io.nop.excel.model.ExcelFont _font ;
    
    /**
     *  
     * xml name: text
     * 
     */
    private java.lang.String _text ;
    
    /**
     * 
     * xml name: font
     *  
     */
    
    public io.nop.excel.model.ExcelFont getFont(){
      return _font;
    }

    
    public void setFont(io.nop.excel.model.ExcelFont value){
        checkAllowChange();
        
        this._font = value;
           
    }

    
    /**
     * 
     * xml name: text
     *  
     */
    
    public java.lang.String getText(){
      return _text;
    }

    
    public void setText(java.lang.String value){
        checkAllowChange();
        
        this._text = value;
           
    }

    

    @Override
    public void freeze(boolean cascade){
        if(frozen()) return;
        super.freeze(cascade);

        if(cascade){ //NOPMD - suppressed EmptyControlStatement - Auto Gen Code
        
           this._font = io.nop.api.core.util.FreezeHelper.deepFreeze(this._font);
            
        }
    }

    @Override
    protected void outputJson(IJsonHandler out){
        super.outputJson(out);
        
        out.putNotNull("font",this.getFont());
        out.putNotNull("text",this.getText());
    }

    public ExcelRichTextPart cloneInstance(){
        ExcelRichTextPart instance = newInstance();
        this.copyTo(instance);
        return instance;
    }

    protected void copyTo(ExcelRichTextPart instance){
        super.copyTo(instance);
        
        instance.setFont(this.getFont());
        instance.setText(this.getText());
    }

    protected ExcelRichTextPart newInstance(){
        return (ExcelRichTextPart) ClassHelper.newInstance(getClass());
    }
}
 // resume CPD analysis - CPD-ON
