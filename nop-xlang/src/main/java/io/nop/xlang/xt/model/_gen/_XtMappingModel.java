package io.nop.xlang.xt.model._gen;

import io.nop.commons.collections.KeyedList; //NOPMD NOSONAR - suppressed UnusedImports - Used for List Prop
import io.nop.core.lang.json.IJsonHandler;
import io.nop.xlang.xt.model.XtMappingModel;
import io.nop.commons.util.ClassHelper;



// tell cpd to start ignoring code - CPD-OFF
/**
 * generate from /nop/schema/xt.xdef <p>
 * 按标签名映射到不同的规则
 */
@SuppressWarnings({"PMD.UselessOverridingMethod","PMD.UnusedLocalVariable",
    "PMD.UnnecessaryFullyQualifiedName","PMD.EmptyControlStatement","java:S116","java:S101","java:S1128","java:S1161"})
public abstract class _XtMappingModel extends io.nop.core.resource.component.AbstractComponentModel {
    
    /**
     *  
     * xml name: default
     * 
     */
    private io.nop.xlang.xt.model.XtRuleGroupModel _default ;
    
    /**
     *  
     * xml name: id
     * 
     */
    private java.lang.String _id ;
    
    /**
     *  
     * xml name: inherits
     * 继承其它mapping规则，允许替换
     */
    private java.util.Set<java.lang.String> _inherits ;
    
    /**
     *  
     * xml name: match
     * 
     */
    private KeyedList<io.nop.xlang.xt.model.XtMappingMatchModel> _matchs = KeyedList.emptyList();
    
    /**
     * 
     * xml name: default
     *  
     */
    
    public io.nop.xlang.xt.model.XtRuleGroupModel getDefault(){
      return _default;
    }

    
    public void setDefault(io.nop.xlang.xt.model.XtRuleGroupModel value){
        checkAllowChange();
        
        this._default = value;
           
    }

    
    /**
     * 
     * xml name: id
     *  
     */
    
    public java.lang.String getId(){
      return _id;
    }

    
    public void setId(java.lang.String value){
        checkAllowChange();
        
        this._id = value;
           
    }

    
    /**
     * 
     * xml name: inherits
     *  继承其它mapping规则，允许替换
     */
    
    public java.util.Set<java.lang.String> getInherits(){
      return _inherits;
    }

    
    public void setInherits(java.util.Set<java.lang.String> value){
        checkAllowChange();
        
        this._inherits = value;
           
    }

    
    /**
     * 
     * xml name: match
     *  
     */
    
    public java.util.List<io.nop.xlang.xt.model.XtMappingMatchModel> getMatchs(){
      return _matchs;
    }

    
    public void setMatchs(java.util.List<io.nop.xlang.xt.model.XtMappingMatchModel> value){
        checkAllowChange();
        
        this._matchs = KeyedList.fromList(value, io.nop.xlang.xt.model.XtMappingMatchModel::getTag);
           
    }

    
    public io.nop.xlang.xt.model.XtMappingMatchModel getMatch(String name){
        return this._matchs.getByKey(name);
    }

    public boolean hasMatch(String name){
        return this._matchs.containsKey(name);
    }

    public void addMatch(io.nop.xlang.xt.model.XtMappingMatchModel item) {
        checkAllowChange();
        java.util.List<io.nop.xlang.xt.model.XtMappingMatchModel> list = this.getMatchs();
        if (list == null || list.isEmpty()) {
            list = new KeyedList<>(io.nop.xlang.xt.model.XtMappingMatchModel::getTag);
            setMatchs(list);
        }
        list.add(item);
    }
    
    public java.util.Set<String> keySet_matchs(){
        return this._matchs.keySet();
    }

    public boolean hasMatchs(){
        return !this._matchs.isEmpty();
    }
    

    @Override
    public void freeze(boolean cascade){
        if(frozen()) return;
        super.freeze(cascade);

        if(cascade){ //NOPMD - suppressed EmptyControlStatement - Auto Gen Code
        
           this._default = io.nop.api.core.util.FreezeHelper.deepFreeze(this._default);
            
           this._matchs = io.nop.api.core.util.FreezeHelper.deepFreeze(this._matchs);
            
        }
    }

    @Override
    protected void outputJson(IJsonHandler out){
        super.outputJson(out);
        
        out.putNotNull("default",this.getDefault());
        out.putNotNull("id",this.getId());
        out.putNotNull("inherits",this.getInherits());
        out.putNotNull("matchs",this.getMatchs());
    }

    public XtMappingModel cloneInstance(){
        XtMappingModel instance = newInstance();
        this.copyTo(instance);
        return instance;
    }

    protected void copyTo(XtMappingModel instance){
        super.copyTo(instance);
        
        instance.setDefault(this.getDefault());
        instance.setId(this.getId());
        instance.setInherits(this.getInherits());
        instance.setMatchs(this.getMatchs());
    }

    protected XtMappingModel newInstance(){
        return (XtMappingModel) ClassHelper.newInstance(getClass());
    }
}
 // resume CPD analysis - CPD-ON
