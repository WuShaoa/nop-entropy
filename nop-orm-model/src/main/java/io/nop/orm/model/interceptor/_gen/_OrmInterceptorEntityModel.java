package io.nop.orm.model.interceptor._gen;

import io.nop.commons.collections.KeyedList; //NOPMD NOSONAR - suppressed UnusedImports - Used for List Prop
import io.nop.core.lang.json.IJsonHandler;
import io.nop.orm.model.interceptor.OrmInterceptorEntityModel;
import io.nop.commons.util.ClassHelper;



// tell cpd to start ignoring code - CPD-OFF
/**
 * generate from /nop/schema/orm/orm-interceptor.xdef <p>
 * 
 */
@SuppressWarnings({"PMD.UselessOverridingMethod","PMD.UnusedLocalVariable",
    "PMD.UnnecessaryFullyQualifiedName","PMD.EmptyControlStatement","java:S116","java:S101","java:S1128","java:S1161"})
public abstract class _OrmInterceptorEntityModel extends io.nop.core.resource.component.AbstractComponentModel {
    
    /**
     *  
     * xml name: 
     * 
     */
    private KeyedList<io.nop.orm.model.interceptor.OrmInterceptorActionModel> _actions = KeyedList.emptyList();
    
    /**
     *  
     * xml name: name
     * 
     */
    private java.lang.String _name ;
    
    /**
     * 
     * xml name: 
     *  
     */
    
    public java.util.List<io.nop.orm.model.interceptor.OrmInterceptorActionModel> getActions(){
      return _actions;
    }

    
    public void setActions(java.util.List<io.nop.orm.model.interceptor.OrmInterceptorActionModel> value){
        checkAllowChange();
        
        this._actions = KeyedList.fromList(value, io.nop.orm.model.interceptor.OrmInterceptorActionModel::getId);
           
    }

    
    public java.util.Set<String> keySet_actions(){
        return this._actions.keySet();
    }

    public boolean hasActions(){
        return !this._actions.isEmpty();
    }
    
    /**
     * 
     * xml name: name
     *  
     */
    
    public java.lang.String getName(){
      return _name;
    }

    
    public void setName(java.lang.String value){
        checkAllowChange();
        
        this._name = value;
           
    }

    

    @Override
    public void freeze(boolean cascade){
        if(frozen()) return;
        super.freeze(cascade);

        if(cascade){ //NOPMD - suppressed EmptyControlStatement - Auto Gen Code
        
           this._actions = io.nop.api.core.util.FreezeHelper.deepFreeze(this._actions);
            
        }
    }

    @Override
    protected void outputJson(IJsonHandler out){
        super.outputJson(out);
        
        out.putNotNull("actions",this.getActions());
        out.putNotNull("name",this.getName());
    }

    public OrmInterceptorEntityModel cloneInstance(){
        OrmInterceptorEntityModel instance = newInstance();
        this.copyTo(instance);
        return instance;
    }

    protected void copyTo(OrmInterceptorEntityModel instance){
        super.copyTo(instance);
        
        instance.setActions(this.getActions());
        instance.setName(this.getName());
    }

    protected OrmInterceptorEntityModel newInstance(){
        return (OrmInterceptorEntityModel) ClassHelper.newInstance(getClass());
    }
}
 // resume CPD analysis - CPD-ON
