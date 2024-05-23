package io.nop.orm.model._gen;

import io.nop.commons.collections.KeyedList; //NOPMD NOSONAR - suppressed UnusedImports - Used for List Prop
import io.nop.core.lang.json.IJsonHandler;
import io.nop.orm.model.OrmJoinOnModel;
import io.nop.commons.util.ClassHelper;



// tell cpd to start ignoring code - CPD-OFF
/**
 * generate from [134:14:0:0]/nop/schema/orm/entity.xdef <p>
 * 
 */
@SuppressWarnings({"PMD.UselessOverridingMethod","PMD.UnusedLocalVariable",
    "PMD.UnnecessaryFullyQualifiedName","PMD.EmptyControlStatement","java:S116","java:S101","java:S1128","java:S1161"})
public abstract class _OrmJoinOnModel extends io.nop.core.resource.component.AbstractComponentModel {
    
    /**
     *  
     * xml name: leftProp
     * 
     */
    private java.lang.String _leftProp ;
    
    /**
     *  
     * xml name: leftValue
     * 
     */
    private java.lang.Object _leftValue ;
    
    /**
     *  
     * xml name: rightProp
     * 
     */
    private java.lang.String _rightProp ;
    
    /**
     *  
     * xml name: rightValue
     * 
     */
    private java.lang.Object _rightValue ;
    
    /**
     * 
     * xml name: leftProp
     *  
     */
    
    public java.lang.String getLeftProp(){
      return _leftProp;
    }

    
    public void setLeftProp(java.lang.String value){
        checkAllowChange();
        
        this._leftProp = value;
           
    }

    
    /**
     * 
     * xml name: leftValue
     *  
     */
    
    public java.lang.Object getLeftValue(){
      return _leftValue;
    }

    
    public void setLeftValue(java.lang.Object value){
        checkAllowChange();
        
        this._leftValue = value;
           
    }

    
    /**
     * 
     * xml name: rightProp
     *  
     */
    
    public java.lang.String getRightProp(){
      return _rightProp;
    }

    
    public void setRightProp(java.lang.String value){
        checkAllowChange();
        
        this._rightProp = value;
           
    }

    
    /**
     * 
     * xml name: rightValue
     *  
     */
    
    public java.lang.Object getRightValue(){
      return _rightValue;
    }

    
    public void setRightValue(java.lang.Object value){
        checkAllowChange();
        
        this._rightValue = value;
           
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
        
        out.putNotNull("leftProp",this.getLeftProp());
        out.putNotNull("leftValue",this.getLeftValue());
        out.putNotNull("rightProp",this.getRightProp());
        out.putNotNull("rightValue",this.getRightValue());
    }

    public OrmJoinOnModel cloneInstance(){
        OrmJoinOnModel instance = newInstance();
        this.copyTo(instance);
        return instance;
    }

    protected void copyTo(OrmJoinOnModel instance){
        super.copyTo(instance);
        
        instance.setLeftProp(this.getLeftProp());
        instance.setLeftValue(this.getLeftValue());
        instance.setRightProp(this.getRightProp());
        instance.setRightValue(this.getRightValue());
    }

    protected OrmJoinOnModel newInstance(){
        return (OrmJoinOnModel) ClassHelper.newInstance(getClass());
    }
}
 // resume CPD analysis - CPD-ON
