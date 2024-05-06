package io.nop.xlang.xpl.xlib._gen;

import io.nop.commons.collections.KeyedList; //NOPMD NOSONAR - suppressed UnusedImports - Used for List Prop
import io.nop.core.lang.json.IJsonHandler;
import io.nop.xlang.xpl.xlib.XplTagAttribute;
import io.nop.commons.util.ClassHelper;



// tell cpd to start ignoring code - CPD-OFF
/**
 * generate from [67:14:0:0]/nop/schema/xlib.xdef <p>
 * 
 */
@SuppressWarnings({"PMD.UselessOverridingMethod","PMD.UnusedLocalVariable",
    "PMD.UnnecessaryFullyQualifiedName","PMD.EmptyControlStatement","java:S116","java:S101","java:S1128","java:S1161"})
public abstract class _XplTagAttribute extends io.nop.core.resource.component.AbstractComponentModel {
    
    /**
     *  缺省值
     * xml name: defaultValue
     * 当外部调用标签时没有指定属性时会使用缺省值
     */
    private java.lang.String _defaultValue ;
    
    /**
     *  是否已废弃
     * xml name: deprecated
     * 已废弃的属性不推荐在程序中继续被使用
     */
    private boolean _deprecated  = false;
    
    /**
     *  
     * xml name: description
     * 
     */
    private java.lang.String _description ;
    
    /**
     *  
     * xml name: displayName
     * 
     */
    private java.lang.String _displayName ;
    
    /**
     *  
     * xml name: implicit
     * 
     */
    private boolean _implicit  = false;
    
    /**
     *  是否内部
     * xml name: internal
     * 内部属性不出现在IDE的提示信息中
     */
    private boolean _internal  = false;
    
    /**
     *  是否非空
     * xml name: mandatory
     * 是否必须设置该属性，且属性值不能是空值或者空字符串
     */
    private boolean _mandatory  = false;
    
    /**
     *  
     * xml name: name
     * 
     */
    private java.lang.String _name ;
    
    /**
     *  是否可选
     * xml name: optional
     * 如果不是可选属性，则调用时必须传入该属性，但是属性值允许为空
     */
    private boolean _optional  = false;
    
    /**
     *  是否运行时属性
     * xml name: runtime
     * 只有标签是宏标签时起作用。对于宏标签，非运行时属性必须是编译期可以确定的具体值，且在运行期不存在。
     * 而运行时属性在标签编译时对应于Expression类型，同时存在于运行期
     */
    private boolean _runtime  = false;
    
    /**
     *  
     * xml name: stdDomain
     * 
     */
    private java.lang.String _stdDomain ;
    
    /**
     *  
     * xml name: type
     * 
     */
    private io.nop.core.type.IGenericType _type ;
    
    /**
     *  
     * xml name: varName
     * 对应于表达式中可以使用的变量名。一般情况下变量名与属性名相同，但是如果属性名中存在特殊字符，例如on:click或者v-model，
     * 则将会转换为大小写混排的变量名，例如onClick和vModel。
     */
    private java.lang.String _varName ;
    
    /**
     * 缺省值
     * xml name: defaultValue
     *  当外部调用标签时没有指定属性时会使用缺省值
     */
    
    public java.lang.String getDefaultValue(){
      return _defaultValue;
    }

    
    public void setDefaultValue(java.lang.String value){
        checkAllowChange();
        
        this._defaultValue = value;
           
    }

    
    /**
     * 是否已废弃
     * xml name: deprecated
     *  已废弃的属性不推荐在程序中继续被使用
     */
    
    public boolean isDeprecated(){
      return _deprecated;
    }

    
    public void setDeprecated(boolean value){
        checkAllowChange();
        
        this._deprecated = value;
           
    }

    
    /**
     * 
     * xml name: description
     *  
     */
    
    public java.lang.String getDescription(){
      return _description;
    }

    
    public void setDescription(java.lang.String value){
        checkAllowChange();
        
        this._description = value;
           
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
     * xml name: implicit
     *  
     */
    
    public boolean isImplicit(){
      return _implicit;
    }

    
    public void setImplicit(boolean value){
        checkAllowChange();
        
        this._implicit = value;
           
    }

    
    /**
     * 是否内部
     * xml name: internal
     *  内部属性不出现在IDE的提示信息中
     */
    
    public boolean isInternal(){
      return _internal;
    }

    
    public void setInternal(boolean value){
        checkAllowChange();
        
        this._internal = value;
           
    }

    
    /**
     * 是否非空
     * xml name: mandatory
     *  是否必须设置该属性，且属性值不能是空值或者空字符串
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
     * 是否可选
     * xml name: optional
     *  如果不是可选属性，则调用时必须传入该属性，但是属性值允许为空
     */
    
    public boolean isOptional(){
      return _optional;
    }

    
    public void setOptional(boolean value){
        checkAllowChange();
        
        this._optional = value;
           
    }

    
    /**
     * 是否运行时属性
     * xml name: runtime
     *  只有标签是宏标签时起作用。对于宏标签，非运行时属性必须是编译期可以确定的具体值，且在运行期不存在。
     * 而运行时属性在标签编译时对应于Expression类型，同时存在于运行期
     */
    
    public boolean isRuntime(){
      return _runtime;
    }

    
    public void setRuntime(boolean value){
        checkAllowChange();
        
        this._runtime = value;
           
    }

    
    /**
     * 
     * xml name: stdDomain
     *  
     */
    
    public java.lang.String getStdDomain(){
      return _stdDomain;
    }

    
    public void setStdDomain(java.lang.String value){
        checkAllowChange();
        
        this._stdDomain = value;
           
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
     * xml name: varName
     *  对应于表达式中可以使用的变量名。一般情况下变量名与属性名相同，但是如果属性名中存在特殊字符，例如on:click或者v-model，
     * 则将会转换为大小写混排的变量名，例如onClick和vModel。
     */
    
    public java.lang.String getVarName(){
      return _varName;
    }

    
    public void setVarName(java.lang.String value){
        checkAllowChange();
        
        this._varName = value;
           
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
        
        out.putNotNull("defaultValue",this.getDefaultValue());
        out.putNotNull("deprecated",this.isDeprecated());
        out.putNotNull("description",this.getDescription());
        out.putNotNull("displayName",this.getDisplayName());
        out.putNotNull("implicit",this.isImplicit());
        out.putNotNull("internal",this.isInternal());
        out.putNotNull("mandatory",this.isMandatory());
        out.putNotNull("name",this.getName());
        out.putNotNull("optional",this.isOptional());
        out.putNotNull("runtime",this.isRuntime());
        out.putNotNull("stdDomain",this.getStdDomain());
        out.putNotNull("type",this.getType());
        out.putNotNull("varName",this.getVarName());
    }

    public XplTagAttribute cloneInstance(){
        XplTagAttribute instance = newInstance();
        this.copyTo(instance);
        return instance;
    }

    protected void copyTo(XplTagAttribute instance){
        super.copyTo(instance);
        
        instance.setDefaultValue(this.getDefaultValue());
        instance.setDeprecated(this.isDeprecated());
        instance.setDescription(this.getDescription());
        instance.setDisplayName(this.getDisplayName());
        instance.setImplicit(this.isImplicit());
        instance.setInternal(this.isInternal());
        instance.setMandatory(this.isMandatory());
        instance.setName(this.getName());
        instance.setOptional(this.isOptional());
        instance.setRuntime(this.isRuntime());
        instance.setStdDomain(this.getStdDomain());
        instance.setType(this.getType());
        instance.setVarName(this.getVarName());
    }

    protected XplTagAttribute newInstance(){
        return (XplTagAttribute) ClassHelper.newInstance(getClass());
    }
}
 // resume CPD analysis - CPD-ON
