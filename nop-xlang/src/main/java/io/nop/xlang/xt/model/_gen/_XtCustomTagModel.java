package io.nop.xlang.xt.model._gen;

import io.nop.commons.collections.KeyedList; //NOPMD NOSONAR - suppressed UnusedImports - Used for List Prop
import io.nop.core.lang.json.IJsonHandler;
import io.nop.xlang.xt.model.XtCustomTagModel;
import io.nop.commons.util.ClassHelper;



// tell cpd to start ignoring code - CPD-OFF
/**
 * generate from /nop/schema/xt.xdef <p>
 * 
 */
@SuppressWarnings({"PMD.UselessOverridingMethod","PMD.UnusedLocalVariable",
    "PMD.UnnecessaryFullyQualifiedName","PMD.EmptyControlStatement","java:S116","java:S101","java:S1128","java:S1161"})
public abstract class _XtCustomTagModel extends io.nop.xlang.xt.model.XtRuleGroupModel {
    
    /**
     *  
     * xml name: 
     * 
     */
    private java.util.Map<java.lang.String,io.nop.core.lang.eval.IEvalAction> _attrs ;
    
    /**
     *  
     * xml name: 
     * 
     */
    private java.lang.String _tagName ;
    
    /**
     *  
     * xml name: xt:attrs
     * 
     */
    private io.nop.core.lang.eval.IEvalAction _xtAttrs ;
    
    /**
     *  
     * xml name: xt:xpath
     * 
     */
    private io.nop.core.lang.xml.IXSelector<io.nop.core.lang.xml.XNode> _xtXpath ;
    
    /**
     * 
     * xml name: 
     *  
     */
    
    public java.util.Map<java.lang.String,io.nop.core.lang.eval.IEvalAction> getAttrs(){
      return _attrs;
    }

    
    public void setAttrs(java.util.Map<java.lang.String,io.nop.core.lang.eval.IEvalAction> value){
        checkAllowChange();
        
        this._attrs = value;
           
    }

    
    public boolean hasAttrs(){
        return this._attrs != null && !this._attrs.isEmpty();
    }
    
    /**
     * 
     * xml name: 
     *  
     */
    
    public java.lang.String getTagName(){
      return _tagName;
    }

    
    public void setTagName(java.lang.String value){
        checkAllowChange();
        
        this._tagName = value;
           
    }

    
    /**
     * 
     * xml name: xt:attrs
     *  
     */
    
    public io.nop.core.lang.eval.IEvalAction getXtAttrs(){
      return _xtAttrs;
    }

    
    public void setXtAttrs(io.nop.core.lang.eval.IEvalAction value){
        checkAllowChange();
        
        this._xtAttrs = value;
           
    }

    
    /**
     * 
     * xml name: xt:xpath
     *  
     */
    
    public io.nop.core.lang.xml.IXSelector<io.nop.core.lang.xml.XNode> getXtXpath(){
      return _xtXpath;
    }

    
    public void setXtXpath(io.nop.core.lang.xml.IXSelector<io.nop.core.lang.xml.XNode> value){
        checkAllowChange();
        
        this._xtXpath = value;
           
    }

    

    @Override
    public void freeze(boolean cascade){
        if(frozen()) return;
        super.freeze(cascade);

        if(cascade){ //NOPMD - suppressed EmptyControlStatement - Auto Gen Code
        
           this._attrs = io.nop.api.core.util.FreezeHelper.deepFreeze(this._attrs);
            
        }
    }

    @Override
    protected void outputJson(IJsonHandler out){
        super.outputJson(out);
        
        out.putNotNull("attrs",this.getAttrs());
        out.putNotNull("tagName",this.getTagName());
        out.putNotNull("xtAttrs",this.getXtAttrs());
        out.putNotNull("xtXpath",this.getXtXpath());
    }

    public XtCustomTagModel cloneInstance(){
        XtCustomTagModel instance = newInstance();
        this.copyTo(instance);
        return instance;
    }

    protected void copyTo(XtCustomTagModel instance){
        super.copyTo(instance);
        
        instance.setAttrs(this.getAttrs());
        instance.setTagName(this.getTagName());
        instance.setXtAttrs(this.getXtAttrs());
        instance.setXtXpath(this.getXtXpath());
    }

    protected XtCustomTagModel newInstance(){
        return (XtCustomTagModel) ClassHelper.newInstance(getClass());
    }
}
 // resume CPD analysis - CPD-ON
