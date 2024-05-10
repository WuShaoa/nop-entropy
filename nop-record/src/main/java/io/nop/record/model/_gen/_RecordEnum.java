package io.nop.record.model._gen;

import io.nop.commons.collections.KeyedList; //NOPMD NOSONAR - suppressed UnusedImports - Used for List Prop
import io.nop.core.lang.json.IJsonHandler;
import io.nop.record.model.RecordEnum;
import io.nop.commons.util.ClassHelper;



// tell cpd to start ignoring code - CPD-OFF
/**
 * generate from [77:10:0:0]/nop/schema/record/record-file.xdef <p>
 * 
 */
@SuppressWarnings({"PMD.UselessOverridingMethod","PMD.UnusedLocalVariable",
    "PMD.UnnecessaryFullyQualifiedName","PMD.EmptyControlStatement","java:S116","java:S101","java:S1128","java:S1161"})
public abstract class _RecordEnum extends io.nop.core.resource.component.AbstractComponentModel {
    
    /**
     *  
     * xml name: doc
     * 
     */
    private java.lang.String _doc ;
    
    /**
     *  
     * xml name: name
     * 
     */
    private java.lang.String _name ;
    
    /**
     *  
     * xml name: option
     * 
     */
    private KeyedList<io.nop.record.model.RecordEnumOption> _options = KeyedList.emptyList();
    
    /**
     *  
     * xml name: valueType
     * 
     */
    private io.nop.commons.type.StdDataType _valueType ;
    
    /**
     * 
     * xml name: doc
     *  
     */
    
    public java.lang.String getDoc(){
      return _doc;
    }

    
    public void setDoc(java.lang.String value){
        checkAllowChange();
        
        this._doc = value;
           
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

    
    /**
     * 
     * xml name: option
     *  
     */
    
    public java.util.List<io.nop.record.model.RecordEnumOption> getOptions(){
      return _options;
    }

    
    public void setOptions(java.util.List<io.nop.record.model.RecordEnumOption> value){
        checkAllowChange();
        
        this._options = KeyedList.fromList(value, io.nop.record.model.RecordEnumOption::getValue);
           
    }

    
    public io.nop.record.model.RecordEnumOption getOption(String name){
        return this._options.getByKey(name);
    }

    public boolean hasOption(String name){
        return this._options.containsKey(name);
    }

    public void addOption(io.nop.record.model.RecordEnumOption item) {
        checkAllowChange();
        java.util.List<io.nop.record.model.RecordEnumOption> list = this.getOptions();
        if (list == null || list.isEmpty()) {
            list = new KeyedList<>(io.nop.record.model.RecordEnumOption::getValue);
            setOptions(list);
        }
        list.add(item);
    }
    
    public java.util.Set<String> keySet_options(){
        return this._options.keySet();
    }

    public boolean hasOptions(){
        return !this._options.isEmpty();
    }
    
    /**
     * 
     * xml name: valueType
     *  
     */
    
    public io.nop.commons.type.StdDataType getValueType(){
      return _valueType;
    }

    
    public void setValueType(io.nop.commons.type.StdDataType value){
        checkAllowChange();
        
        this._valueType = value;
           
    }

    

    @Override
    public void freeze(boolean cascade){
        if(frozen()) return;
        super.freeze(cascade);

        if(cascade){ //NOPMD - suppressed EmptyControlStatement - Auto Gen Code
        
           this._options = io.nop.api.core.util.FreezeHelper.deepFreeze(this._options);
            
        }
    }

    @Override
    protected void outputJson(IJsonHandler out){
        super.outputJson(out);
        
        out.putNotNull("doc",this.getDoc());
        out.putNotNull("name",this.getName());
        out.putNotNull("options",this.getOptions());
        out.putNotNull("valueType",this.getValueType());
    }

    public RecordEnum cloneInstance(){
        RecordEnum instance = newInstance();
        this.copyTo(instance);
        return instance;
    }

    protected void copyTo(RecordEnum instance){
        super.copyTo(instance);
        
        instance.setDoc(this.getDoc());
        instance.setName(this.getName());
        instance.setOptions(this.getOptions());
        instance.setValueType(this.getValueType());
    }

    protected RecordEnum newInstance(){
        return (RecordEnum) ClassHelper.newInstance(getClass());
    }
}
 // resume CPD analysis - CPD-ON
