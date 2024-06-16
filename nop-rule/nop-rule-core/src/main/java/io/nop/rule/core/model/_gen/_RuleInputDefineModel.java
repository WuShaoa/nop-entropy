package io.nop.rule.core.model._gen;

import io.nop.commons.collections.KeyedList; //NOPMD NOSONAR - suppressed UnusedImports - Used for List Prop
import io.nop.core.lang.json.IJsonHandler;
import io.nop.rule.core.model.RuleInputDefineModel;
import io.nop.commons.util.ClassHelper;



// tell cpd to start ignoring code - CPD-OFF
/**
 * generate from /nop/schema/rule.xdef <p>
 * 
 */
@SuppressWarnings({"PMD.UselessOverridingMethod","PMD.UnusedLocalVariable",
    "PMD.UnnecessaryFullyQualifiedName","PMD.EmptyControlStatement","java:S116","java:S101","java:S1128","java:S1161"})
public abstract class _RuleInputDefineModel extends io.nop.xlang.xmeta.ObjVarDefineModel {
    
    /**
     *  
     * xml name: computed
     * 
     */
    private boolean _computed  = false;
    
    /**
     *  
     * xml name: mandatory
     * 
     */
    private boolean _mandatory  = false;
    
    /**
     * 
     * xml name: computed
     *  
     */
    
    public boolean isComputed(){
      return _computed;
    }

    
    public void setComputed(boolean value){
        checkAllowChange();
        
        this._computed = value;
           
    }

    
    /**
     * 
     * xml name: mandatory
     *  
     */
    
    public boolean isMandatory(){
      return _mandatory;
    }

    
    public void setMandatory(boolean value){
        checkAllowChange();
        
        this._mandatory = value;
           
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
        
        out.putNotNull("computed",this.isComputed());
        out.putNotNull("mandatory",this.isMandatory());
    }

    public RuleInputDefineModel cloneInstance(){
        RuleInputDefineModel instance = newInstance();
        this.copyTo(instance);
        return instance;
    }

    protected void copyTo(RuleInputDefineModel instance){
        super.copyTo(instance);
        
        instance.setComputed(this.isComputed());
        instance.setMandatory(this.isMandatory());
    }

    protected RuleInputDefineModel newInstance(){
        return (RuleInputDefineModel) ClassHelper.newInstance(getClass());
    }
}
 // resume CPD analysis - CPD-ON
