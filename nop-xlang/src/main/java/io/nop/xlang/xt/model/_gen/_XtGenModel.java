package io.nop.xlang.xt.model._gen;

import io.nop.commons.collections.KeyedList; //NOPMD NOSONAR - suppressed UnusedImports - Used for List Prop
import io.nop.core.lang.json.IJsonHandler;
import io.nop.xlang.xt.model.XtGenModel;
import io.nop.commons.util.ClassHelper;



// tell cpd to start ignoring code - CPD-OFF
/**
 * generate from /nop/schema/xt.xdef <p>
 * 执行代码来输出转换结果
 */
@SuppressWarnings({"PMD.UselessOverridingMethod","PMD.UnusedLocalVariable",
    "PMD.UnnecessaryFullyQualifiedName","PMD.EmptyControlStatement","java:S116","java:S101","java:S1128","java:S1161"})
public abstract class _XtGenModel extends io.nop.xlang.xt.model.XtRuleModel {
    
    /**
     *  
     * xml name: 
     * 
     */
    private io.nop.core.lang.xml.IXNodeGenerator _body ;
    
    /**
     *  
     * xml name: xpath
     * 
     */
    private io.nop.core.lang.xml.IXSelector<io.nop.core.lang.xml.XNode> _xpath ;
    
    /**
     * 
     * xml name: 
     *  
     */
    
    public io.nop.core.lang.xml.IXNodeGenerator getBody(){
      return _body;
    }

    
    public void setBody(io.nop.core.lang.xml.IXNodeGenerator value){
        checkAllowChange();
        
        this._body = value;
           
    }

    
    /**
     * 
     * xml name: xpath
     *  
     */
    
    public io.nop.core.lang.xml.IXSelector<io.nop.core.lang.xml.XNode> getXpath(){
      return _xpath;
    }

    
    public void setXpath(io.nop.core.lang.xml.IXSelector<io.nop.core.lang.xml.XNode> value){
        checkAllowChange();
        
        this._xpath = value;
           
    }

    

    @Override
    public void freeze(boolean cascade){
        if(frozen()) return;
        super.freeze(cascade);

        if(cascade){ //NOPMD - suppressed EmptyControlStatement - Auto Gen Code
        
        }
    }

    @Override
    protected void outputJson(IJsonHandler out){
        super.outputJson(out);
        
        out.putNotNull("body",this.getBody());
        out.putNotNull("xpath",this.getXpath());
    }

    public XtGenModel cloneInstance(){
        XtGenModel instance = newInstance();
        this.copyTo(instance);
        return instance;
    }

    protected void copyTo(XtGenModel instance){
        super.copyTo(instance);
        
        instance.setBody(this.getBody());
        instance.setXpath(this.getXpath());
    }

    protected XtGenModel newInstance(){
        return (XtGenModel) ClassHelper.newInstance(getClass());
    }
}
 // resume CPD analysis - CPD-ON
