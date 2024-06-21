package io.nop.ioc.model._gen;

import io.nop.commons.collections.KeyedList; //NOPMD NOSONAR - suppressed UnusedImports - Used for List Prop
import io.nop.core.lang.json.IJsonHandler;
import io.nop.ioc.model.BeanXplValue;
import io.nop.commons.util.ClassHelper;



// tell cpd to start ignoring code - CPD-OFF
/**
 * generate from /nop/schema/beans.xdef <p>
 * 
 */
@SuppressWarnings({"PMD.UselessOverridingMethod","PMD.UnusedLocalVariable",
    "PMD.UnnecessaryFullyQualifiedName","PMD.EmptyControlStatement","java:S116","java:S101","java:S1128","java:S1161"})
public abstract class _BeanXplValue extends io.nop.core.resource.component.AbstractComponentModel {
    
    /**
     *  
     * xml name: 
     * 
     */
    private java.lang.String _beanValueType ;
    
    /**
     *  
     * xml name: outputMode
     * 
     */
    private io.nop.xlang.ast.XLangOutputMode _outputMode ;
    
    /**
     *  
     * xml name: 
     * 
     */
    private io.nop.xlang.api.EvalCode _source ;
    
    /**
     * 
     * xml name: 
     *  
     */
    
    public java.lang.String getBeanValueType(){
      return _beanValueType;
    }

    
    public void setBeanValueType(java.lang.String value){
        checkAllowChange();
        
        this._beanValueType = value;
           
    }

    
    /**
     * 
     * xml name: outputMode
     *  
     */
    
    public io.nop.xlang.ast.XLangOutputMode getOutputMode(){
      return _outputMode;
    }

    
    public void setOutputMode(io.nop.xlang.ast.XLangOutputMode value){
        checkAllowChange();
        
        this._outputMode = value;
           
    }

    
    /**
     * 
     * xml name: 
     *  
     */
    
    public io.nop.xlang.api.EvalCode getSource(){
      return _source;
    }

    
    public void setSource(io.nop.xlang.api.EvalCode value){
        checkAllowChange();
        
        this._source = value;
           
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
        
        out.putNotNull("beanValueType",this.getBeanValueType());
        out.putNotNull("outputMode",this.getOutputMode());
        out.putNotNull("source",this.getSource());
    }

    public BeanXplValue cloneInstance(){
        BeanXplValue instance = newInstance();
        this.copyTo(instance);
        return instance;
    }

    protected void copyTo(BeanXplValue instance){
        super.copyTo(instance);
        
        instance.setBeanValueType(this.getBeanValueType());
        instance.setOutputMode(this.getOutputMode());
        instance.setSource(this.getSource());
    }

    protected BeanXplValue newInstance(){
        return (BeanXplValue) ClassHelper.newInstance(getClass());
    }
}
 // resume CPD analysis - CPD-ON
