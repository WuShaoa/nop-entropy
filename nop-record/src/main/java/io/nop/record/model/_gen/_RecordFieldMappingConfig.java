package io.nop.record.model._gen;

import io.nop.commons.collections.KeyedList; //NOPMD NOSONAR - suppressed UnusedImports - Used for List Prop
import io.nop.core.lang.json.IJsonHandler;
import io.nop.record.model.RecordFieldMappingConfig;
import io.nop.commons.util.ClassHelper;



// tell cpd to start ignoring code - CPD-OFF
/**
 * generate from /nop/schema/record/record-mapping.xdef <p>
 * 
 */
@SuppressWarnings({"PMD.UselessOverridingMethod","PMD.UnusedLocalVariable",
    "PMD.UnnecessaryFullyQualifiedName","PMD.EmptyControlStatement","java:S116","java:S101","java:S1128","java:S1161"})
public abstract class _RecordFieldMappingConfig extends io.nop.core.resource.component.AbstractComponentModel {
    
    /**
     *  
     * xml name: afterFieldMapping
     * 
     */
    private io.nop.core.lang.eval.IEvalFunction _afterFieldMapping ;
    
    /**
     *  
     * xml name: beforeFieldMapping
     * 
     */
    private io.nop.core.lang.eval.IEvalFunction _beforeFieldMapping ;
    
    /**
     *  
     * xml name: computeExpr
     * 
     */
    private io.nop.core.lang.eval.IEvalFunction _computeExpr ;
    
    /**
     *  
     * xml name: defaultValue
     * 
     */
    private java.lang.String _defaultValue ;
    
    /**
     *  
     * xml name: displayName
     * 
     */
    private java.lang.String _displayName ;
    
    /**
     *  
     * xml name: from
     * 
     */
    private java.lang.String _from ;
    
    /**
     *  
     * xml name: itemFilterExpr
     * 当Map或者Collection结构进行映射时，可以判断每个条目是否需要映射
     */
    private io.nop.core.lang.eval.IEvalFunction _itemFilterExpr ;
    
    /**
     *  
     * xml name: itemMapping
     * 如果to和from对应的属性是Map类型或者List类型，可以通过itemMapping来指定每个条目所对应的映射规则
     */
    private java.lang.String _itemMapping ;
    
    /**
     *  
     * xml name: mandatory
     * 
     */
    private boolean _mandatory  = false;
    
    /**
     *  
     * xml name: mapping
     * 引用其他RecordMapping映射规则。
     */
    private java.lang.String _mapping ;
    
    /**
     *  
     * xml name: newInstanceExpr
     * 
     */
    private io.nop.core.lang.eval.IEvalFunction _newInstanceExpr ;
    
    /**
     *  
     * xml name: newItemExpr
     * 
     */
    private io.nop.core.lang.eval.IEvalFunction _newItemExpr ;
    
    /**
     *  
     * xml name: schema
     * schema包含如下几种情况：1. 简单数据类型 2. Map（命名属性集合） 3. List（顺序结构，重复结构） 4. Union（switch选择结构）
     * Map对应props配置,  List对应item配置, Union对应oneOf配置
     */
    private io.nop.xlang.xmeta.ISchema _schema ;
    
    /**
     *  
     * xml name: tagSet
     * 
     */
    private java.util.Set<java.lang.String> _tagSet ;
    
    /**
     *  
     * xml name: to
     * 
     */
    private java.lang.String _to ;
    
    /**
     *  
     * xml name: type
     * 
     */
    private io.nop.core.type.IGenericType _type ;
    
    /**
     *  
     * xml name: valueMapper
     * 
     */
    private io.nop.core.model.mapper.IValueMapper<java.lang.String,java.lang.Object> _valueMapper ;
    
    /**
     *  
     * xml name: virtual
     * 
     */
    private boolean _virtual  = false;
    
    /**
     *  
     * xml name: when
     * 
     */
    private io.nop.core.lang.eval.IEvalFunction _when ;
    
    /**
     * 
     * xml name: afterFieldMapping
     *  
     */
    
    public io.nop.core.lang.eval.IEvalFunction getAfterFieldMapping(){
      return _afterFieldMapping;
    }

    
    public void setAfterFieldMapping(io.nop.core.lang.eval.IEvalFunction value){
        checkAllowChange();
        
        this._afterFieldMapping = value;
           
    }

    
    /**
     * 
     * xml name: beforeFieldMapping
     *  
     */
    
    public io.nop.core.lang.eval.IEvalFunction getBeforeFieldMapping(){
      return _beforeFieldMapping;
    }

    
    public void setBeforeFieldMapping(io.nop.core.lang.eval.IEvalFunction value){
        checkAllowChange();
        
        this._beforeFieldMapping = value;
           
    }

    
    /**
     * 
     * xml name: computeExpr
     *  
     */
    
    public io.nop.core.lang.eval.IEvalFunction getComputeExpr(){
      return _computeExpr;
    }

    
    public void setComputeExpr(io.nop.core.lang.eval.IEvalFunction value){
        checkAllowChange();
        
        this._computeExpr = value;
           
    }

    
    /**
     * 
     * xml name: defaultValue
     *  
     */
    
    public java.lang.String getDefaultValue(){
      return _defaultValue;
    }

    
    public void setDefaultValue(java.lang.String value){
        checkAllowChange();
        
        this._defaultValue = value;
           
    }

    
    /**
     * 
     * xml name: displayName
     *  
     */
    
    public java.lang.String getDisplayName(){
      return _displayName;
    }

    
    public void setDisplayName(java.lang.String value){
        checkAllowChange();
        
        this._displayName = value;
           
    }

    
    /**
     * 
     * xml name: from
     *  
     */
    
    public java.lang.String getFrom(){
      return _from;
    }

    
    public void setFrom(java.lang.String value){
        checkAllowChange();
        
        this._from = value;
           
    }

    
    /**
     * 
     * xml name: itemFilterExpr
     *  当Map或者Collection结构进行映射时，可以判断每个条目是否需要映射
     */
    
    public io.nop.core.lang.eval.IEvalFunction getItemFilterExpr(){
      return _itemFilterExpr;
    }

    
    public void setItemFilterExpr(io.nop.core.lang.eval.IEvalFunction value){
        checkAllowChange();
        
        this._itemFilterExpr = value;
           
    }

    
    /**
     * 
     * xml name: itemMapping
     *  如果to和from对应的属性是Map类型或者List类型，可以通过itemMapping来指定每个条目所对应的映射规则
     */
    
    public java.lang.String getItemMapping(){
      return _itemMapping;
    }

    
    public void setItemMapping(java.lang.String value){
        checkAllowChange();
        
        this._itemMapping = value;
           
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

    
    /**
     * 
     * xml name: mapping
     *  引用其他RecordMapping映射规则。
     */
    
    public java.lang.String getMapping(){
      return _mapping;
    }

    
    public void setMapping(java.lang.String value){
        checkAllowChange();
        
        this._mapping = value;
           
    }

    
    /**
     * 
     * xml name: newInstanceExpr
     *  
     */
    
    public io.nop.core.lang.eval.IEvalFunction getNewInstanceExpr(){
      return _newInstanceExpr;
    }

    
    public void setNewInstanceExpr(io.nop.core.lang.eval.IEvalFunction value){
        checkAllowChange();
        
        this._newInstanceExpr = value;
           
    }

    
    /**
     * 
     * xml name: newItemExpr
     *  
     */
    
    public io.nop.core.lang.eval.IEvalFunction getNewItemExpr(){
      return _newItemExpr;
    }

    
    public void setNewItemExpr(io.nop.core.lang.eval.IEvalFunction value){
        checkAllowChange();
        
        this._newItemExpr = value;
           
    }

    
    /**
     * 
     * xml name: schema
     *  schema包含如下几种情况：1. 简单数据类型 2. Map（命名属性集合） 3. List（顺序结构，重复结构） 4. Union（switch选择结构）
     * Map对应props配置,  List对应item配置, Union对应oneOf配置
     */
    
    public io.nop.xlang.xmeta.ISchema getSchema(){
      return _schema;
    }

    
    public void setSchema(io.nop.xlang.xmeta.ISchema value){
        checkAllowChange();
        
        this._schema = value;
           
    }

    
    /**
     * 
     * xml name: tagSet
     *  
     */
    
    public java.util.Set<java.lang.String> getTagSet(){
      return _tagSet;
    }

    
    public void setTagSet(java.util.Set<java.lang.String> value){
        checkAllowChange();
        
        this._tagSet = value;
           
    }

    
    /**
     * 
     * xml name: to
     *  
     */
    
    public java.lang.String getTo(){
      return _to;
    }

    
    public void setTo(java.lang.String value){
        checkAllowChange();
        
        this._to = value;
           
    }

    
    /**
     * 
     * xml name: type
     *  
     */
    
    public io.nop.core.type.IGenericType getType(){
      return _type;
    }

    
    public void setType(io.nop.core.type.IGenericType value){
        checkAllowChange();
        
        this._type = value;
           
    }

    
    /**
     * 
     * xml name: valueMapper
     *  
     */
    
    public io.nop.core.model.mapper.IValueMapper<java.lang.String,java.lang.Object> getValueMapper(){
      return _valueMapper;
    }

    
    public void setValueMapper(io.nop.core.model.mapper.IValueMapper<java.lang.String,java.lang.Object> value){
        checkAllowChange();
        
        this._valueMapper = value;
           
    }

    
    /**
     * 
     * xml name: virtual
     *  
     */
    
    public boolean isVirtual(){
      return _virtual;
    }

    
    public void setVirtual(boolean value){
        checkAllowChange();
        
        this._virtual = value;
           
    }

    
    /**
     * 
     * xml name: when
     *  
     */
    
    public io.nop.core.lang.eval.IEvalFunction getWhen(){
      return _when;
    }

    
    public void setWhen(io.nop.core.lang.eval.IEvalFunction value){
        checkAllowChange();
        
        this._when = value;
           
    }

    

    @Override
    public void freeze(boolean cascade){
        if(frozen()) return;
        super.freeze(cascade);

        if(cascade){ //NOPMD - suppressed EmptyControlStatement - Auto Gen Code
        
           this._schema = io.nop.api.core.util.FreezeHelper.deepFreeze(this._schema);
            
        }
    }

    @Override
    protected void outputJson(IJsonHandler out){
        super.outputJson(out);
        
        out.putNotNull("afterFieldMapping",this.getAfterFieldMapping());
        out.putNotNull("beforeFieldMapping",this.getBeforeFieldMapping());
        out.putNotNull("computeExpr",this.getComputeExpr());
        out.putNotNull("defaultValue",this.getDefaultValue());
        out.putNotNull("displayName",this.getDisplayName());
        out.putNotNull("from",this.getFrom());
        out.putNotNull("itemFilterExpr",this.getItemFilterExpr());
        out.putNotNull("itemMapping",this.getItemMapping());
        out.putNotNull("mandatory",this.isMandatory());
        out.putNotNull("mapping",this.getMapping());
        out.putNotNull("newInstanceExpr",this.getNewInstanceExpr());
        out.putNotNull("newItemExpr",this.getNewItemExpr());
        out.putNotNull("schema",this.getSchema());
        out.putNotNull("tagSet",this.getTagSet());
        out.putNotNull("to",this.getTo());
        out.putNotNull("type",this.getType());
        out.putNotNull("valueMapper",this.getValueMapper());
        out.putNotNull("virtual",this.isVirtual());
        out.putNotNull("when",this.getWhen());
    }

    public RecordFieldMappingConfig cloneInstance(){
        RecordFieldMappingConfig instance = newInstance();
        this.copyTo(instance);
        return instance;
    }

    protected void copyTo(RecordFieldMappingConfig instance){
        super.copyTo(instance);
        
        instance.setAfterFieldMapping(this.getAfterFieldMapping());
        instance.setBeforeFieldMapping(this.getBeforeFieldMapping());
        instance.setComputeExpr(this.getComputeExpr());
        instance.setDefaultValue(this.getDefaultValue());
        instance.setDisplayName(this.getDisplayName());
        instance.setFrom(this.getFrom());
        instance.setItemFilterExpr(this.getItemFilterExpr());
        instance.setItemMapping(this.getItemMapping());
        instance.setMandatory(this.isMandatory());
        instance.setMapping(this.getMapping());
        instance.setNewInstanceExpr(this.getNewInstanceExpr());
        instance.setNewItemExpr(this.getNewItemExpr());
        instance.setSchema(this.getSchema());
        instance.setTagSet(this.getTagSet());
        instance.setTo(this.getTo());
        instance.setType(this.getType());
        instance.setValueMapper(this.getValueMapper());
        instance.setVirtual(this.isVirtual());
        instance.setWhen(this.getWhen());
    }

    protected RecordFieldMappingConfig newInstance(){
        return (RecordFieldMappingConfig) ClassHelper.newInstance(getClass());
    }
}
 // resume CPD analysis - CPD-ON
