package io.nop.record.model._gen;

import io.nop.commons.collections.KeyedList; //NOPMD NOSONAR - suppressed UnusedImports - Used for List Prop
import io.nop.core.lang.json.IJsonHandler;
import io.nop.record.model.RecordFieldSwitchCase;
import io.nop.commons.util.ClassHelper;



// tell cpd to start ignoring code - CPD-OFF
/**
 * generate from /nop/schema/record/record-field.xdef <p>
 * 
 */
@SuppressWarnings({"PMD.UselessOverridingMethod","PMD.UnusedLocalVariable",
    "PMD.UnnecessaryFullyQualifiedName","PMD.EmptyControlStatement","java:S116","java:S101","java:S1128","java:S1161"})
public abstract class _RecordFieldSwitchCase extends io.nop.core.resource.component.AbstractComponentModel {
    
    /**
     *  
     * xml name: type
     * 
     */
    private java.lang.String _type ;
    
    /**
     *  
     * xml name: when
     * 与on表达式的返回值比较，如果相等，则实际类型为type指定的值
     */
    private java.lang.String _when ;
    
    /**
     * 
     * xml name: type
     *  
     */
    
    public java.lang.String getType(){
      return _type;
    }

    
    public void setType(java.lang.String value){
        checkAllowChange();
        
        this._type = value;
           
    }

    
    /**
     * 
     * xml name: when
     *  与on表达式的返回值比较，如果相等，则实际类型为type指定的值
     */
    
    public java.lang.String getWhen(){
      return _when;
    }

    
    public void setWhen(java.lang.String value){
        checkAllowChange();
        
        this._when = value;
           
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
        
        out.putNotNull("type",this.getType());
        out.putNotNull("when",this.getWhen());
    }

    public RecordFieldSwitchCase cloneInstance(){
        RecordFieldSwitchCase instance = newInstance();
        this.copyTo(instance);
        return instance;
    }

    protected void copyTo(RecordFieldSwitchCase instance){
        super.copyTo(instance);
        
        instance.setType(this.getType());
        instance.setWhen(this.getWhen());
    }

    protected RecordFieldSwitchCase newInstance(){
        return (RecordFieldSwitchCase) ClassHelper.newInstance(getClass());
    }
}
 // resume CPD analysis - CPD-ON
