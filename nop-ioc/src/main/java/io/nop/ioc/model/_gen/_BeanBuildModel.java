package io.nop.ioc.model._gen;

import io.nop.commons.collections.KeyedList; //NOPMD NOSONAR - suppressed UnusedImports - Used for List Prop
import io.nop.core.lang.json.IJsonHandler;
import io.nop.ioc.model.BeanBuildModel;
import io.nop.commons.util.ClassHelper;



// tell cpd to start ignoring code - CPD-OFF
/**
 * generate from /nop/schema/beans.xdef <p>
 * 将xml属性直接映射到bean属性，支持嵌套结构
 */
@SuppressWarnings({"PMD.UselessOverridingMethod","PMD.UnusedLocalVariable",
    "PMD.UnnecessaryFullyQualifiedName","PMD.EmptyControlStatement","java:S116","java:S101","java:S1128","java:S1161"})
public abstract class _BeanBuildModel extends io.nop.core.resource.component.AbstractComponentModel {
    
    /**
     *  
     * xml name: 
     * 
     */
    private java.util.Map<java.lang.String,java.lang.Object> _body ;
    
    /**
     * 
     * xml name: 
     *  
     */
    
    public java.util.Map<java.lang.String,java.lang.Object> getBody(){
      return _body;
    }

    
    public void setBody(java.util.Map<java.lang.String,java.lang.Object> value){
        checkAllowChange();
        
        this._body = value;
           
    }

    
    public boolean hasBody(){
        return this._body != null && !this._body.isEmpty();
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
    }

    public BeanBuildModel cloneInstance(){
        BeanBuildModel instance = newInstance();
        this.copyTo(instance);
        return instance;
    }

    protected void copyTo(BeanBuildModel instance){
        super.copyTo(instance);
        
        instance.setBody(this.getBody());
    }

    protected BeanBuildModel newInstance(){
        return (BeanBuildModel) ClassHelper.newInstance(getClass());
    }
}
 // resume CPD analysis - CPD-ON
