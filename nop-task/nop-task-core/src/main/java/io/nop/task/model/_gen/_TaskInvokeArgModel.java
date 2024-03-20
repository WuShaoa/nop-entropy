package io.nop.task.model._gen;

import io.nop.commons.collections.KeyedList; //NOPMD NOSONAR - suppressed UnusedImports - Used for List Prop
import io.nop.core.lang.json.IJsonHandler;
import io.nop.task.model.TaskInvokeArgModel;
import io.nop.commons.util.ClassHelper;



// tell cpd to start ignoring code - CPD-OFF
/**
 * generate from [156:18:0:0]/nop/schema/task/task.xdef <p>
 * 
 */
@SuppressWarnings({"PMD.UselessOverridingMethod","PMD.UnusedLocalVariable",
    "PMD.UnnecessaryFullyQualifiedName","PMD.EmptyControlStatement","java:S116","java:S101","java:S1128","java:S1161"})
public abstract class _TaskInvokeArgModel extends io.nop.core.resource.component.AbstractComponentModel {
    
    /**
     *  
     * xml name: index
     * 
     */
    private int _index ;
    
    /**
     *  
     * xml name: valueExpr
     * 
     */
    private io.nop.core.lang.eval.IEvalAction _valueExpr ;
    
    /**
     * 
     * xml name: index
     *  
     */
    
    public int getIndex(){
      return _index;
    }

    
    public void setIndex(int value){
        checkAllowChange();
        
        this._index = value;
           
    }

    
    /**
     * 
     * xml name: valueExpr
     *  
     */
    
    public io.nop.core.lang.eval.IEvalAction getValueExpr(){
      return _valueExpr;
    }

    
    public void setValueExpr(io.nop.core.lang.eval.IEvalAction value){
        checkAllowChange();
        
        this._valueExpr = value;
           
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
        
        out.putNotNull("index",this.getIndex());
        out.putNotNull("valueExpr",this.getValueExpr());
    }

    public TaskInvokeArgModel cloneInstance(){
        TaskInvokeArgModel instance = newInstance();
        this.copyTo(instance);
        return instance;
    }

    protected void copyTo(TaskInvokeArgModel instance){
        super.copyTo(instance);
        
        instance.setIndex(this.getIndex());
        instance.setValueExpr(this.getValueExpr());
    }

    protected TaskInvokeArgModel newInstance(){
        return (TaskInvokeArgModel) ClassHelper.newInstance(getClass());
    }
}
 // resume CPD analysis - CPD-ON
