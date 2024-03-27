package io.nop.xlang.xmeta.impl._gen;

import io.nop.commons.collections.KeyedList; //NOPMD NOSONAR - suppressed UnusedImports - Used for List Prop
import io.nop.core.lang.json.IJsonHandler;
import io.nop.xlang.xmeta.impl.ObjMetaImpl;
import io.nop.commons.util.ClassHelper;



// tell cpd to start ignoring code - CPD-OFF
/**
 * generate from [3:2:0:0]/nop/schema/xmeta.xdef <p>
 * schema节点的基类
 */
@SuppressWarnings({"PMD.UselessOverridingMethod","PMD.UnusedLocalVariable",
    "PMD.UnnecessaryFullyQualifiedName","PMD.EmptyControlStatement","java:S116","java:S101","java:S1128","java:S1161"})
public abstract class _ObjMetaImpl extends io.nop.xlang.xmeta.impl.ObjSchemaImpl {
    
    /**
     *  
     * xml name: checkNs
     * 
     */
    private java.util.Set<java.lang.String> _checkNs ;
    
    /**
     *  
     * xml name: defaultExtends
     * 
     */
    private java.lang.String _defaultExtends ;
    
    /**
     *  
     * xml name: defines
     * 
     */
    private KeyedList<io.nop.xlang.xmeta.ISchema> _defines = KeyedList.emptyList();
    
    /**
     *  
     * xml name: displayProp
     * 用于显示的字段，例如displayName等。选择控件会使用该字段
     */
    private java.lang.String _displayProp ;
    
    /**
     *  
     * xml name: entityName
     * 
     */
    private java.lang.String _entityName ;
    
    /**
     *  
     * xml name: filter
     * 过滤条件。会追加到GraphQL的query查询条件中。因为在update和view的时候也会使用检查这里的过滤条件，
     * 所以一般就是简单的等于条件的过滤，暂时不考虑更复杂的查询条件。更复杂的业务相关的查询条件应该写在Biz或者sql-lib文件中
     */
    private io.nop.core.lang.xml.XNode _filter ;
    
    /**
     *  
     * xml name: keys
     * 
     */
    private KeyedList<io.nop.xlang.xmeta.impl.ObjKeyModel> _keys = KeyedList.emptyList();
    
    /**
     *  
     * xml name: modelNameProp
     * 
     */
    private java.lang.String _modelNameProp ;
    
    /**
     *  
     * xml name: modelVersionProp
     * 
     */
    private java.lang.String _modelVersionProp ;
    
    /**
     *  
     * xml name: orderBy
     * 排序条件。追加到GraphQL的query查询条件中
     */
    private KeyedList<io.nop.api.core.beans.query.OrderFieldBean> _orderBy = KeyedList.emptyList();
    
    /**
     *  
     * xml name: parseForHtml
     * 
     */
    private java.lang.Boolean _parseForHtml ;
    
    /**
     *  
     * xml name: parseKeepComment
     * 
     */
    private java.lang.Boolean _parseKeepComment ;
    
    /**
     *  
     * xml name: parserClass
     * 
     */
    private java.lang.String _parserClass ;
    
    /**
     *  
     * xml name: primaryKey
     * 
     */
    private java.util.Set<java.lang.String> _primaryKey ;
    
    /**
     *  
     * xml name: propNs
     * 
     */
    private java.util.Set<java.lang.String> _propNs ;
    
    /**
     *  
     * xml name: selections
     * 
     */
    private KeyedList<io.nop.xlang.xmeta.impl.ObjSelectionMeta> _selections = KeyedList.emptyList();
    
    /**
     *  
     * xml name: tagSet
     * 
     */
    private java.util.Set<java.lang.String> _tagSet ;
    
    /**
     *  
     * xml name: tree
     * 树形结构
     */
    private io.nop.xlang.xmeta.impl.ObjTreeModel _tree ;
    
    /**
     *  
     * xml name: version
     * 
     */
    private java.lang.String _version ;
    
    /**
     *  
     * xml name: xmlName
     * 
     */
    private java.lang.String _xmlName ;
    
    /**
     * 
     * xml name: checkNs
     *  
     */
    
    public java.util.Set<java.lang.String> getCheckNs(){
      return _checkNs;
    }

    
    public void setCheckNs(java.util.Set<java.lang.String> value){
        checkAllowChange();
        
        this._checkNs = value;
           
    }

    
    /**
     * 
     * xml name: defaultExtends
     *  
     */
    
    public java.lang.String getDefaultExtends(){
      return _defaultExtends;
    }

    
    public void setDefaultExtends(java.lang.String value){
        checkAllowChange();
        
        this._defaultExtends = value;
           
    }

    
    /**
     * 
     * xml name: defines
     *  
     */
    
    public java.util.List<io.nop.xlang.xmeta.ISchema> getDefines(){
      return _defines;
    }

    
    public void setDefines(java.util.List<io.nop.xlang.xmeta.ISchema> value){
        checkAllowChange();
        
        this._defines = KeyedList.fromList(value, io.nop.xlang.xmeta.ISchema::getName);
           
    }

    
    public io.nop.xlang.xmeta.ISchema getDefine(String name){
        return this._defines.getByKey(name);
    }

    public boolean hasDefine(String name){
        return this._defines.containsKey(name);
    }

    public void addDefine(io.nop.xlang.xmeta.ISchema item) {
        checkAllowChange();
        java.util.List<io.nop.xlang.xmeta.ISchema> list = this.getDefines();
        if (list == null || list.isEmpty()) {
            list = new KeyedList<>(io.nop.xlang.xmeta.ISchema::getName);
            setDefines(list);
        }
        list.add(item);
    }
    
    public java.util.Set<String> keySet_defines(){
        return this._defines.keySet();
    }

    public boolean hasDefines(){
        return !this._defines.isEmpty();
    }
    
    /**
     * 
     * xml name: displayProp
     *  用于显示的字段，例如displayName等。选择控件会使用该字段
     */
    
    public java.lang.String getDisplayProp(){
      return _displayProp;
    }

    
    public void setDisplayProp(java.lang.String value){
        checkAllowChange();
        
        this._displayProp = value;
           
    }

    
    /**
     * 
     * xml name: entityName
     *  
     */
    
    public java.lang.String getEntityName(){
      return _entityName;
    }

    
    public void setEntityName(java.lang.String value){
        checkAllowChange();
        
        this._entityName = value;
           
    }

    
    /**
     * 
     * xml name: filter
     *  过滤条件。会追加到GraphQL的query查询条件中。因为在update和view的时候也会使用检查这里的过滤条件，
     * 所以一般就是简单的等于条件的过滤，暂时不考虑更复杂的查询条件。更复杂的业务相关的查询条件应该写在Biz或者sql-lib文件中
     */
    
    public io.nop.core.lang.xml.XNode getFilter(){
      return _filter;
    }

    
    public void setFilter(io.nop.core.lang.xml.XNode value){
        checkAllowChange();
        
        this._filter = value;
           
    }

    
    /**
     * 
     * xml name: keys
     *  
     */
    
    public java.util.List<io.nop.xlang.xmeta.impl.ObjKeyModel> getKeys(){
      return _keys;
    }

    
    public void setKeys(java.util.List<io.nop.xlang.xmeta.impl.ObjKeyModel> value){
        checkAllowChange();
        
        this._keys = KeyedList.fromList(value, io.nop.xlang.xmeta.impl.ObjKeyModel::getName);
           
    }

    
    public io.nop.xlang.xmeta.impl.ObjKeyModel getKey(String name){
        return this._keys.getByKey(name);
    }

    public boolean hasKey(String name){
        return this._keys.containsKey(name);
    }

    public void addKey(io.nop.xlang.xmeta.impl.ObjKeyModel item) {
        checkAllowChange();
        java.util.List<io.nop.xlang.xmeta.impl.ObjKeyModel> list = this.getKeys();
        if (list == null || list.isEmpty()) {
            list = new KeyedList<>(io.nop.xlang.xmeta.impl.ObjKeyModel::getName);
            setKeys(list);
        }
        list.add(item);
    }
    
    public java.util.Set<String> keySet_keys(){
        return this._keys.keySet();
    }

    public boolean hasKeys(){
        return !this._keys.isEmpty();
    }
    
    /**
     * 
     * xml name: modelNameProp
     *  
     */
    
    public java.lang.String getModelNameProp(){
      return _modelNameProp;
    }

    
    public void setModelNameProp(java.lang.String value){
        checkAllowChange();
        
        this._modelNameProp = value;
           
    }

    
    /**
     * 
     * xml name: modelVersionProp
     *  
     */
    
    public java.lang.String getModelVersionProp(){
      return _modelVersionProp;
    }

    
    public void setModelVersionProp(java.lang.String value){
        checkAllowChange();
        
        this._modelVersionProp = value;
           
    }

    
    /**
     * 
     * xml name: orderBy
     *  排序条件。追加到GraphQL的query查询条件中
     */
    
    public java.util.List<io.nop.api.core.beans.query.OrderFieldBean> getOrderBy(){
      return _orderBy;
    }

    
    public void setOrderBy(java.util.List<io.nop.api.core.beans.query.OrderFieldBean> value){
        checkAllowChange();
        
        this._orderBy = KeyedList.fromList(value, io.nop.api.core.beans.query.OrderFieldBean::getName);
           
    }

    
    public io.nop.api.core.beans.query.OrderFieldBean getField(String name){
        return this._orderBy.getByKey(name);
    }

    public boolean hasField(String name){
        return this._orderBy.containsKey(name);
    }

    public void addField(io.nop.api.core.beans.query.OrderFieldBean item) {
        checkAllowChange();
        java.util.List<io.nop.api.core.beans.query.OrderFieldBean> list = this.getOrderBy();
        if (list == null || list.isEmpty()) {
            list = new KeyedList<>(io.nop.api.core.beans.query.OrderFieldBean::getName);
            setOrderBy(list);
        }
        list.add(item);
    }
    
    public java.util.Set<String> keySet_orderBy(){
        return this._orderBy.keySet();
    }

    public boolean hasOrderBy(){
        return !this._orderBy.isEmpty();
    }
    
    /**
     * 
     * xml name: parseForHtml
     *  
     */
    
    public java.lang.Boolean getParseForHtml(){
      return _parseForHtml;
    }

    
    public void setParseForHtml(java.lang.Boolean value){
        checkAllowChange();
        
        this._parseForHtml = value;
           
    }

    
    /**
     * 
     * xml name: parseKeepComment
     *  
     */
    
    public java.lang.Boolean getParseKeepComment(){
      return _parseKeepComment;
    }

    
    public void setParseKeepComment(java.lang.Boolean value){
        checkAllowChange();
        
        this._parseKeepComment = value;
           
    }

    
    /**
     * 
     * xml name: parserClass
     *  
     */
    
    public java.lang.String getParserClass(){
      return _parserClass;
    }

    
    public void setParserClass(java.lang.String value){
        checkAllowChange();
        
        this._parserClass = value;
           
    }

    
    /**
     * 
     * xml name: primaryKey
     *  
     */
    
    public java.util.Set<java.lang.String> getPrimaryKey(){
      return _primaryKey;
    }

    
    public void setPrimaryKey(java.util.Set<java.lang.String> value){
        checkAllowChange();
        
        this._primaryKey = value;
           
    }

    
    /**
     * 
     * xml name: propNs
     *  
     */
    
    public java.util.Set<java.lang.String> getPropNs(){
      return _propNs;
    }

    
    public void setPropNs(java.util.Set<java.lang.String> value){
        checkAllowChange();
        
        this._propNs = value;
           
    }

    
    /**
     * 
     * xml name: selections
     *  
     */
    
    public java.util.List<io.nop.xlang.xmeta.impl.ObjSelectionMeta> getSelections(){
      return _selections;
    }

    
    public void setSelections(java.util.List<io.nop.xlang.xmeta.impl.ObjSelectionMeta> value){
        checkAllowChange();
        
        this._selections = KeyedList.fromList(value, io.nop.xlang.xmeta.impl.ObjSelectionMeta::getId);
           
    }

    
    public io.nop.xlang.xmeta.impl.ObjSelectionMeta getSelection(String name){
        return this._selections.getByKey(name);
    }

    public boolean hasSelection(String name){
        return this._selections.containsKey(name);
    }

    public void addSelection(io.nop.xlang.xmeta.impl.ObjSelectionMeta item) {
        checkAllowChange();
        java.util.List<io.nop.xlang.xmeta.impl.ObjSelectionMeta> list = this.getSelections();
        if (list == null || list.isEmpty()) {
            list = new KeyedList<>(io.nop.xlang.xmeta.impl.ObjSelectionMeta::getId);
            setSelections(list);
        }
        list.add(item);
    }
    
    public java.util.Set<String> keySet_selections(){
        return this._selections.keySet();
    }

    public boolean hasSelections(){
        return !this._selections.isEmpty();
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
     * xml name: tree
     *  树形结构
     */
    
    public io.nop.xlang.xmeta.impl.ObjTreeModel getTree(){
      return _tree;
    }

    
    public void setTree(io.nop.xlang.xmeta.impl.ObjTreeModel value){
        checkAllowChange();
        
        this._tree = value;
           
    }

    
    /**
     * 
     * xml name: version
     *  
     */
    
    public java.lang.String getVersion(){
      return _version;
    }

    
    public void setVersion(java.lang.String value){
        checkAllowChange();
        
        this._version = value;
           
    }

    
    /**
     * 
     * xml name: xmlName
     *  
     */
    
    public java.lang.String getXmlName(){
      return _xmlName;
    }

    
    public void setXmlName(java.lang.String value){
        checkAllowChange();
        
        this._xmlName = value;
           
    }

    

    @Override
    public void freeze(boolean cascade){
        if(frozen()) return;
        super.freeze(cascade);

        if(cascade){ //NOPMD - suppressed EmptyControlStatement - Auto Gen Code
        
           this._defines = io.nop.api.core.util.FreezeHelper.deepFreeze(this._defines);
            
           this._keys = io.nop.api.core.util.FreezeHelper.deepFreeze(this._keys);
            
           this._orderBy = io.nop.api.core.util.FreezeHelper.deepFreeze(this._orderBy);
            
           this._selections = io.nop.api.core.util.FreezeHelper.deepFreeze(this._selections);
            
           this._tree = io.nop.api.core.util.FreezeHelper.deepFreeze(this._tree);
            
        }
    }

    @Override
    protected void outputJson(IJsonHandler out){
        super.outputJson(out);
        
        out.putNotNull("checkNs",this.getCheckNs());
        out.putNotNull("defaultExtends",this.getDefaultExtends());
        out.putNotNull("defines",this.getDefines());
        out.putNotNull("displayProp",this.getDisplayProp());
        out.putNotNull("entityName",this.getEntityName());
        out.putNotNull("filter",this.getFilter());
        out.putNotNull("keys",this.getKeys());
        out.putNotNull("modelNameProp",this.getModelNameProp());
        out.putNotNull("modelVersionProp",this.getModelVersionProp());
        out.putNotNull("orderBy",this.getOrderBy());
        out.putNotNull("parseForHtml",this.getParseForHtml());
        out.putNotNull("parseKeepComment",this.getParseKeepComment());
        out.putNotNull("parserClass",this.getParserClass());
        out.putNotNull("primaryKey",this.getPrimaryKey());
        out.putNotNull("propNs",this.getPropNs());
        out.putNotNull("selections",this.getSelections());
        out.putNotNull("tagSet",this.getTagSet());
        out.putNotNull("tree",this.getTree());
        out.putNotNull("version",this.getVersion());
        out.putNotNull("xmlName",this.getXmlName());
    }

    public ObjMetaImpl cloneInstance(){
        ObjMetaImpl instance = newInstance();
        this.copyTo(instance);
        return instance;
    }

    protected void copyTo(ObjMetaImpl instance){
        super.copyTo(instance);
        
        instance.setCheckNs(this.getCheckNs());
        instance.setDefaultExtends(this.getDefaultExtends());
        instance.setDefines(this.getDefines());
        instance.setDisplayProp(this.getDisplayProp());
        instance.setEntityName(this.getEntityName());
        instance.setFilter(this.getFilter());
        instance.setKeys(this.getKeys());
        instance.setModelNameProp(this.getModelNameProp());
        instance.setModelVersionProp(this.getModelVersionProp());
        instance.setOrderBy(this.getOrderBy());
        instance.setParseForHtml(this.getParseForHtml());
        instance.setParseKeepComment(this.getParseKeepComment());
        instance.setParserClass(this.getParserClass());
        instance.setPrimaryKey(this.getPrimaryKey());
        instance.setPropNs(this.getPropNs());
        instance.setSelections(this.getSelections());
        instance.setTagSet(this.getTagSet());
        instance.setTree(this.getTree());
        instance.setVersion(this.getVersion());
        instance.setXmlName(this.getXmlName());
    }

    protected ObjMetaImpl newInstance(){
        return (ObjMetaImpl) ClassHelper.newInstance(getClass());
    }
}
 // resume CPD analysis - CPD-ON
