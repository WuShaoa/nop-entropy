package io.nop.xlang.xmeta.impl._gen;

import io.nop.commons.collections.KeyedList; //NOPMD NOSONAR - suppressed UnusedImports - Used for List Prop
import io.nop.core.lang.json.IJsonHandler;
import io.nop.xlang.xmeta.impl.ObjSchemaImpl;
import io.nop.commons.util.ClassHelper;



// tell cpd to start ignoring code - CPD-OFF
/**
 * generate from /nop/schema/schema/obj-schema.xdef <p>
 * schema节点的基类
 */
@SuppressWarnings({"PMD.UselessOverridingMethod","PMD.UnusedLocalVariable",
    "PMD.UnnecessaryFullyQualifiedName","PMD.EmptyControlStatement","java:S116","java:S101","java:S1128","java:S1161"})
public abstract class _ObjSchemaImpl extends io.nop.xlang.xmeta.impl.SchemaNodeImpl {
    
    /**
     *  
     * xml name: abstract
     * 
     */
    private java.lang.Boolean _abstract ;
    
    /**
     *  
     * xml name: extendsType
     * 
     */
    private io.nop.core.type.IGenericType _extendsType ;
    
    /**
     *  
     * xml name: implementsTypes
     * 
     */
    private java.util.List<io.nop.core.type.IGenericType> _implementsTypes ;
    
    /**
     *  
     * xml name: interface
     * 
     */
    private java.lang.Boolean _interface ;
    
    /**
     *  
     * xml name: maxProperties
     * 最多有多少个属性
     */
    private java.lang.Integer _maxProperties ;
    
    /**
     *  
     * xml name: minProperties
     * 最少有多少个属性。对应于json schema中的minProperties属性
     */
    private java.lang.Integer _minProperties ;
    
    /**
     *  
     * xml name: props
     * 
     */
    private KeyedList<io.nop.xlang.xmeta.impl.ObjPropMetaImpl> _props = KeyedList.emptyList();
    
    /**
     *  
     * xml name: supportExtends
     * 
     */
    private java.lang.Boolean _supportExtends ;
    
    /**
     *  
     * xml name: typeValue
     * 作为union的选项时，用于区分具体的子类型
     */
    private java.lang.String _typeValue ;
    
    /**
     *  
     * xml name: uniqueProp
     * 可以用于区分同类型的不同对象的唯一标识属性
     */
    private java.lang.String _uniqueProp ;
    
    /**
     *  
     * xml name: unknownAttr
     * schema包含如下几种情况：1. 简单数据类型 2. Map（命名属性集合） 3. List（顺序结构，重复结构） 4. Union（switch选择结构）
     * Map对应props配置,  List对应item配置, Union对应oneOf配置
     */
    private io.nop.xlang.xmeta.ISchema _unknownAttrSchema ;
    
    /**
     *  
     * xml name: unknownTag
     * schema包含如下几种情况：1. 简单数据类型 2. Map（命名属性集合） 3. List（顺序结构，重复结构） 4. Union（switch选择结构）
     * Map对应props配置,  List对应item配置, Union对应oneOf配置
     */
    private io.nop.xlang.xmeta.ISchema _unknownTagSchema ;
    
    /**
     * 
     * xml name: abstract
     *  
     */
    
    public java.lang.Boolean getAbstract(){
      return _abstract;
    }

    
    public void setAbstract(java.lang.Boolean value){
        checkAllowChange();
        
        this._abstract = value;
           
    }

    
    /**
     * 
     * xml name: extendsType
     *  
     */
    
    public io.nop.core.type.IGenericType getExtendsType(){
      return _extendsType;
    }

    
    public void setExtendsType(io.nop.core.type.IGenericType value){
        checkAllowChange();
        
        this._extendsType = value;
           
    }

    
    /**
     * 
     * xml name: implementsTypes
     *  
     */
    
    public java.util.List<io.nop.core.type.IGenericType> getImplementsTypes(){
      return _implementsTypes;
    }

    
    public void setImplementsTypes(java.util.List<io.nop.core.type.IGenericType> value){
        checkAllowChange();
        
        this._implementsTypes = value;
           
    }

    
    /**
     * 
     * xml name: interface
     *  
     */
    
    public java.lang.Boolean getInterface(){
      return _interface;
    }

    
    public void setInterface(java.lang.Boolean value){
        checkAllowChange();
        
        this._interface = value;
           
    }

    
    /**
     * 
     * xml name: maxProperties
     *  最多有多少个属性
     */
    
    public java.lang.Integer getMaxProperties(){
      return _maxProperties;
    }

    
    public void setMaxProperties(java.lang.Integer value){
        checkAllowChange();
        
        this._maxProperties = value;
           
    }

    
    /**
     * 
     * xml name: minProperties
     *  最少有多少个属性。对应于json schema中的minProperties属性
     */
    
    public java.lang.Integer getMinProperties(){
      return _minProperties;
    }

    
    public void setMinProperties(java.lang.Integer value){
        checkAllowChange();
        
        this._minProperties = value;
           
    }

    
    /**
     * 
     * xml name: props
     *  
     */
    
    public java.util.List<io.nop.xlang.xmeta.impl.ObjPropMetaImpl> getProps(){
      return _props;
    }

    
    public void setProps(java.util.List<io.nop.xlang.xmeta.impl.ObjPropMetaImpl> value){
        checkAllowChange();
        
        this._props = KeyedList.fromList(value, io.nop.xlang.xmeta.impl.ObjPropMetaImpl::getName);
           
    }

    
    public io.nop.xlang.xmeta.impl.ObjPropMetaImpl getProp(String name){
        return this._props.getByKey(name);
    }

    public boolean hasProp(String name){
        return this._props.containsKey(name);
    }

    public void addProp(io.nop.xlang.xmeta.impl.ObjPropMetaImpl item) {
        checkAllowChange();
        java.util.List<io.nop.xlang.xmeta.impl.ObjPropMetaImpl> list = this.getProps();
        if (list == null || list.isEmpty()) {
            list = new KeyedList<>(io.nop.xlang.xmeta.impl.ObjPropMetaImpl::getName);
            setProps(list);
        }
        list.add(item);
    }
    
    public java.util.Set<String> keySet_props(){
        return this._props.keySet();
    }

    public boolean hasProps(){
        return !this._props.isEmpty();
    }
    
    /**
     * 
     * xml name: supportExtends
     *  
     */
    
    public java.lang.Boolean getSupportExtends(){
      return _supportExtends;
    }

    
    public void setSupportExtends(java.lang.Boolean value){
        checkAllowChange();
        
        this._supportExtends = value;
           
    }

    
    /**
     * 
     * xml name: typeValue
     *  作为union的选项时，用于区分具体的子类型
     */
    
    public java.lang.String getTypeValue(){
      return _typeValue;
    }

    
    public void setTypeValue(java.lang.String value){
        checkAllowChange();
        
        this._typeValue = value;
           
    }

    
    /**
     * 
     * xml name: uniqueProp
     *  可以用于区分同类型的不同对象的唯一标识属性
     */
    
    public java.lang.String getUniqueProp(){
      return _uniqueProp;
    }

    
    public void setUniqueProp(java.lang.String value){
        checkAllowChange();
        
        this._uniqueProp = value;
           
    }

    
    /**
     * 
     * xml name: unknownAttr
     *  schema包含如下几种情况：1. 简单数据类型 2. Map（命名属性集合） 3. List（顺序结构，重复结构） 4. Union（switch选择结构）
     * Map对应props配置,  List对应item配置, Union对应oneOf配置
     */
    
    public io.nop.xlang.xmeta.ISchema getUnknownAttrSchema(){
      return _unknownAttrSchema;
    }

    
    public void setUnknownAttrSchema(io.nop.xlang.xmeta.ISchema value){
        checkAllowChange();
        
        this._unknownAttrSchema = value;
           
    }

    
    /**
     * 
     * xml name: unknownTag
     *  schema包含如下几种情况：1. 简单数据类型 2. Map（命名属性集合） 3. List（顺序结构，重复结构） 4. Union（switch选择结构）
     * Map对应props配置,  List对应item配置, Union对应oneOf配置
     */
    
    public io.nop.xlang.xmeta.ISchema getUnknownTagSchema(){
      return _unknownTagSchema;
    }

    
    public void setUnknownTagSchema(io.nop.xlang.xmeta.ISchema value){
        checkAllowChange();
        
        this._unknownTagSchema = value;
           
    }

    

    @Override
    public void freeze(boolean cascade){
        if(frozen()) return;
        super.freeze(cascade);

        if(cascade){ //NOPMD - suppressed EmptyControlStatement - Auto Gen Code
        
           this._props = io.nop.api.core.util.FreezeHelper.deepFreeze(this._props);
            
           this._unknownAttrSchema = io.nop.api.core.util.FreezeHelper.deepFreeze(this._unknownAttrSchema);
            
           this._unknownTagSchema = io.nop.api.core.util.FreezeHelper.deepFreeze(this._unknownTagSchema);
            
        }
    }

    @Override
    protected void outputJson(IJsonHandler out){
        super.outputJson(out);
        
        out.putNotNull("abstract",this.getAbstract());
        out.putNotNull("extendsType",this.getExtendsType());
        out.putNotNull("implementsTypes",this.getImplementsTypes());
        out.putNotNull("interface",this.getInterface());
        out.putNotNull("maxProperties",this.getMaxProperties());
        out.putNotNull("minProperties",this.getMinProperties());
        out.putNotNull("props",this.getProps());
        out.putNotNull("supportExtends",this.getSupportExtends());
        out.putNotNull("typeValue",this.getTypeValue());
        out.putNotNull("uniqueProp",this.getUniqueProp());
        out.putNotNull("unknownAttrSchema",this.getUnknownAttrSchema());
        out.putNotNull("unknownTagSchema",this.getUnknownTagSchema());
    }

    public ObjSchemaImpl cloneInstance(){
        ObjSchemaImpl instance = newInstance();
        this.copyTo(instance);
        return instance;
    }

    protected void copyTo(ObjSchemaImpl instance){
        super.copyTo(instance);
        
        instance.setAbstract(this.getAbstract());
        instance.setExtendsType(this.getExtendsType());
        instance.setImplementsTypes(this.getImplementsTypes());
        instance.setInterface(this.getInterface());
        instance.setMaxProperties(this.getMaxProperties());
        instance.setMinProperties(this.getMinProperties());
        instance.setProps(this.getProps());
        instance.setSupportExtends(this.getSupportExtends());
        instance.setTypeValue(this.getTypeValue());
        instance.setUniqueProp(this.getUniqueProp());
        instance.setUnknownAttrSchema(this.getUnknownAttrSchema());
        instance.setUnknownTagSchema(this.getUnknownTagSchema());
    }

    protected ObjSchemaImpl newInstance(){
        return (ObjSchemaImpl) ClassHelper.newInstance(getClass());
    }
}
 // resume CPD analysis - CPD-ON
