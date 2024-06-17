package io.nop.xlang.xpl.xlib._gen;

import io.nop.commons.collections.KeyedList; //NOPMD NOSONAR - suppressed UnusedImports - Used for List Prop
import io.nop.core.lang.json.IJsonHandler;
import io.nop.xlang.xpl.xlib.XplTagSlot;
import io.nop.commons.util.ClassHelper;



// tell cpd to start ignoring code - CPD-OFF
/**
 * generate from /nop/schema/xlib.xdef <p>
 * 在普通标签上标记xpl:slot，表示将slot和该节点合并，然后再调用render
 */
@SuppressWarnings({"PMD.UselessOverridingMethod","PMD.UnusedLocalVariable",
    "PMD.UnnecessaryFullyQualifiedName","PMD.EmptyControlStatement","java:S116","java:S101","java:S1128","java:S1161"})
public abstract class _XplTagSlot extends io.nop.core.resource.component.AbstractComponentModel {
    
    /**
     *  
     * xml name: arg
     * 
     */
    private KeyedList<io.nop.xlang.xpl.xlib.XplTagSlotArg> _args = KeyedList.emptyList();
    
    /**
     *  
     * xml name: attr
     * 
     */
    private KeyedList<io.nop.xlang.xpl.xlib.XplTagAttribute> _attrs = KeyedList.emptyList();
    
    /**
     *  
     * xml name: deprecated
     * 
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
     * xml name: mandatory
     * 
     */
    private boolean _mandatory  = false;
    
    /**
     *  
     * xml name: multiple
     * 是否允许存在多个指定名称的slot。如果multiple为true，则实际传入的是列表对象
     */
    private boolean _multiple  = false;
    
    /**
     *  
     * xml name: name
     * 
     */
    private java.lang.String _name ;
    
    /**
     *  
     * xml name: outputMode
     * 当slotType=renderer的时候起作用。如果不设置，则缺省值与标签的outputMode相同。
     */
    private io.nop.xlang.ast.XLangOutputMode _outputMode ;
    
    /**
     *  
     * xml name: runtime
     * 
     */
    private boolean _runtime  = false;
    
    /**
     *  
     * xml name: schema
     * 
     */
    private java.lang.String _schema ;
    
    /**
     *  
     * xml name: slotType
     * slot是被编译为渲染函数还是直接作为XNode数据节点
     */
    private io.nop.xlang.xpl.XplSlotType _slotType ;
    
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
     * 
     */
    private java.lang.String _varName ;
    
    /**
     * 
     * xml name: arg
     *  
     */
    
    public java.util.List<io.nop.xlang.xpl.xlib.XplTagSlotArg> getArgs(){
      return _args;
    }

    
    public void setArgs(java.util.List<io.nop.xlang.xpl.xlib.XplTagSlotArg> value){
        checkAllowChange();
        
        this._args = KeyedList.fromList(value, io.nop.xlang.xpl.xlib.XplTagSlotArg::getName);
           
    }

    
    public io.nop.xlang.xpl.xlib.XplTagSlotArg getArg(String name){
        return this._args.getByKey(name);
    }

    public boolean hasArg(String name){
        return this._args.containsKey(name);
    }

    public void addArg(io.nop.xlang.xpl.xlib.XplTagSlotArg item) {
        checkAllowChange();
        java.util.List<io.nop.xlang.xpl.xlib.XplTagSlotArg> list = this.getArgs();
        if (list == null || list.isEmpty()) {
            list = new KeyedList<>(io.nop.xlang.xpl.xlib.XplTagSlotArg::getName);
            setArgs(list);
        }
        list.add(item);
    }
    
    public java.util.Set<String> keySet_args(){
        return this._args.keySet();
    }

    public boolean hasArgs(){
        return !this._args.isEmpty();
    }
    
    /**
     * 
     * xml name: attr
     *  
     */
    
    public java.util.List<io.nop.xlang.xpl.xlib.XplTagAttribute> getAttrs(){
      return _attrs;
    }

    
    public void setAttrs(java.util.List<io.nop.xlang.xpl.xlib.XplTagAttribute> value){
        checkAllowChange();
        
        this._attrs = KeyedList.fromList(value, io.nop.xlang.xpl.xlib.XplTagAttribute::getName);
           
    }

    
    public io.nop.xlang.xpl.xlib.XplTagAttribute getAttr(String name){
        return this._attrs.getByKey(name);
    }

    public boolean hasAttr(String name){
        return this._attrs.containsKey(name);
    }

    public void addAttr(io.nop.xlang.xpl.xlib.XplTagAttribute item) {
        checkAllowChange();
        java.util.List<io.nop.xlang.xpl.xlib.XplTagAttribute> list = this.getAttrs();
        if (list == null || list.isEmpty()) {
            list = new KeyedList<>(io.nop.xlang.xpl.xlib.XplTagAttribute::getName);
            setAttrs(list);
        }
        list.add(item);
    }
    
    public java.util.Set<String> keySet_attrs(){
        return this._attrs.keySet();
    }

    public boolean hasAttrs(){
        return !this._attrs.isEmpty();
    }
    
    /**
     * 
     * xml name: deprecated
     *  
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
     * xml name: multiple
     *  是否允许存在多个指定名称的slot。如果multiple为true，则实际传入的是列表对象
     */
    
    public boolean isMultiple(){
      return _multiple;
    }

    
    public void setMultiple(boolean value){
        checkAllowChange();
        
        this._multiple = value;
           
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
     * xml name: outputMode
     *  当slotType=renderer的时候起作用。如果不设置，则缺省值与标签的outputMode相同。
     */
    
    public io.nop.xlang.ast.XLangOutputMode getOutputMode(){
      return _outputMode;
    }

    
    public void setOutputMode(io.nop.xlang.ast.XLangOutputMode value){
        checkAllowChange();
        
        this._outputMode = value;
           
    }

    
    /**
     * 
     * xml name: runtime
     *  
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
     * xml name: schema
     *  
     */
    
    public java.lang.String getSchema(){
      return _schema;
    }

    
    public void setSchema(java.lang.String value){
        checkAllowChange();
        
        this._schema = value;
           
    }

    
    /**
     * 
     * xml name: slotType
     *  slot是被编译为渲染函数还是直接作为XNode数据节点
     */
    
    public io.nop.xlang.xpl.XplSlotType getSlotType(){
      return _slotType;
    }

    
    public void setSlotType(io.nop.xlang.xpl.XplSlotType value){
        checkAllowChange();
        
        this._slotType = value;
           
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
     *  
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
        
           this._args = io.nop.api.core.util.FreezeHelper.deepFreeze(this._args);
            
           this._attrs = io.nop.api.core.util.FreezeHelper.deepFreeze(this._attrs);
            
        }
    }

    @Override
    protected void outputJson(IJsonHandler out){
        super.outputJson(out);
        
        out.putNotNull("args",this.getArgs());
        out.putNotNull("attrs",this.getAttrs());
        out.putNotNull("deprecated",this.isDeprecated());
        out.putNotNull("description",this.getDescription());
        out.putNotNull("displayName",this.getDisplayName());
        out.putNotNull("mandatory",this.isMandatory());
        out.putNotNull("multiple",this.isMultiple());
        out.putNotNull("name",this.getName());
        out.putNotNull("outputMode",this.getOutputMode());
        out.putNotNull("runtime",this.isRuntime());
        out.putNotNull("schema",this.getSchema());
        out.putNotNull("slotType",this.getSlotType());
        out.putNotNull("stdDomain",this.getStdDomain());
        out.putNotNull("type",this.getType());
        out.putNotNull("varName",this.getVarName());
    }

    public XplTagSlot cloneInstance(){
        XplTagSlot instance = newInstance();
        this.copyTo(instance);
        return instance;
    }

    protected void copyTo(XplTagSlot instance){
        super.copyTo(instance);
        
        instance.setArgs(this.getArgs());
        instance.setAttrs(this.getAttrs());
        instance.setDeprecated(this.isDeprecated());
        instance.setDescription(this.getDescription());
        instance.setDisplayName(this.getDisplayName());
        instance.setMandatory(this.isMandatory());
        instance.setMultiple(this.isMultiple());
        instance.setName(this.getName());
        instance.setOutputMode(this.getOutputMode());
        instance.setRuntime(this.isRuntime());
        instance.setSchema(this.getSchema());
        instance.setSlotType(this.getSlotType());
        instance.setStdDomain(this.getStdDomain());
        instance.setType(this.getType());
        instance.setVarName(this.getVarName());
    }

    protected XplTagSlot newInstance(){
        return (XplTagSlot) ClassHelper.newInstance(getClass());
    }
}
 // resume CPD analysis - CPD-ON
