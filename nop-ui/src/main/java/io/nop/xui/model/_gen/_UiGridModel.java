package io.nop.xui.model._gen;

import io.nop.commons.collections.KeyedList; //NOPMD NOSONAR - suppressed UnusedImports - Used for List Prop
import io.nop.core.lang.json.IJsonHandler;
import io.nop.xui.model.UiGridModel;
import io.nop.commons.util.ClassHelper;



// tell cpd to start ignoring code - CPD-OFF
/**
 * generate from /nop/schema/xui/grid.xdef <p>
 * 
 */
@SuppressWarnings({"PMD.UselessOverridingMethod","PMD.UnusedLocalVariable",
    "PMD.UnnecessaryFullyQualifiedName","PMD.EmptyControlStatement","java:S116","java:S101","java:S1128","java:S1161"})
public abstract class _UiGridModel extends io.nop.core.resource.component.AbstractComponentModel {
    
    /**
     *  
     * xml name: affixHeader
     * 固定表头
     */
    private java.lang.Boolean _affixHeader ;
    
    /**
     *  
     * xml name: affixRow
     * 
     */
    private java.util.List<java.lang.Object> _affixRow ;
    
    /**
     *  
     * xml name: affixRowClassName
     * 
     */
    private java.lang.String _affixRowClassName ;
    
    /**
     *  
     * xml name: affixRowClassNameExpr
     * 
     */
    private java.lang.String _affixRowClassNameExpr ;
    
    /**
     *  
     * xml name: api
     * 
     */
    private io.nop.xui.model.UiApiModel _api ;
    
    /**
     *  
     * xml name: checkOnItemClick
     * 点击数据行是否可以勾选当前行
     */
    private java.lang.Boolean _checkOnItemClick ;
    
    /**
     *  
     * xml name: className
     * 
     */
    private java.lang.String _className ;
    
    /**
     *  
     * xml name: cols
     * 
     */
    private KeyedList<io.nop.xui.model.UiGridColModel> _cols = KeyedList.emptyList();
    
    /**
     *  
     * xml name: columnNum
     * 
     */
    private java.lang.Integer _columnNum ;
    
    /**
     *  
     * xml name: combineFromIndex
     * 如果你不想从第一列开始合并单元格，可以配置 combineFromIndex，如果配置为 1，则会跳过第一列的合并。
     * 如果配置为 2，则会跳过第一列和第二列的合并，从第三行开始向右合并 combineNum 列。
     */
    private java.lang.Object _combineFromIndex ;
    
    /**
     *  
     * xml name: combineNum
     * 表示从左到右多少列内启动自动合并单元格，只要多行的同一个属性值是一样的，就会自动合并。
     */
    private java.lang.Integer _combineNum ;
    
    /**
     *  
     * xml name: displayName
     * 
     */
    private java.lang.String _displayName ;
    
    /**
     *  
     * xml name: editMode
     * 
     */
    private java.lang.String _editMode ;
    
    /**
     *  
     * xml name: filter
     * 
     */
    private io.nop.core.lang.xml.XNode _filter ;
    
    /**
     *  
     * xml name: footerClassName
     * 
     */
    private java.lang.String _footerClassName ;
    
    /**
     *  
     * xml name: headerClassName
     * 
     */
    private java.lang.String _headerClassName ;
    
    /**
     *  
     * xml name: id
     * 
     */
    private java.lang.String _id ;
    
    /**
     *  
     * xml name: initApi
     * 
     */
    private io.nop.xui.model.UiApiModel _initApi ;
    
    /**
     *  
     * xml name: itemCheckableOn
     * 
     */
    private java.lang.String _itemCheckableOn ;
    
    /**
     *  
     * xml name: multiple
     * 勾选 icon 是否为多选样式checkbox， 默认为radio
     */
    private java.lang.Boolean _multiple ;
    
    /**
     *  
     * xml name: objMeta
     * 
     */
    private java.lang.String _objMeta ;
    
    /**
     *  
     * xml name: orderBy
     * 
     */
    private KeyedList<io.nop.api.core.beans.query.OrderFieldBean> _orderBy = KeyedList.emptyList();
    
    /**
     *  
     * xml name: placeholder
     * 
     */
    private java.lang.String _placeholder ;
    
    /**
     *  
     * xml name: prefixRow
     * 
     */
    private java.util.List<java.lang.Object> _prefixRow ;
    
    /**
     *  
     * xml name: prefixRowClassName
     * 
     */
    private java.lang.String _prefixRowClassName ;
    
    /**
     *  
     * xml name: prefixRowClassNameExpr
     * 
     */
    private java.lang.String _prefixRowClassNameExpr ;
    
    /**
     *  
     * xml name: rowClassName
     * 
     */
    private java.lang.String _rowClassName ;
    
    /**
     *  
     * xml name: rowClassNameExpr
     * 
     */
    private java.lang.String _rowClassNameExpr ;
    
    /**
     *  
     * xml name: saveOrderApi
     * 
     */
    private io.nop.xui.model.UiApiModel _saveOrderApi ;
    
    /**
     *  
     * xml name: selectable
     * 是否支持选择
     */
    private java.lang.Boolean _selectable ;
    
    /**
     *  
     * xml name: selection
     * GraphQL查询所需要额外增加的查询字段
     */
    private io.nop.api.core.beans.FieldSelectionBean _selection ;
    
    /**
     *  
     * xml name: sortable
     * 如果设置了sortable为false，则忽略列上面的sortable配置，整个表格不支持sortable
     */
    private java.lang.Boolean _sortable ;
    
    /**
     *  
     * xml name: stopAutoRefreshWhen
     * 
     */
    private java.lang.String _stopAutoRefreshWhen ;
    
    /**
     *  
     * xml name: toolbarClassName
     * 
     */
    private java.lang.String _toolbarClassName ;
    
    /**
     * 
     * xml name: affixHeader
     *  固定表头
     */
    
    public java.lang.Boolean getAffixHeader(){
      return _affixHeader;
    }

    
    public void setAffixHeader(java.lang.Boolean value){
        checkAllowChange();
        
        this._affixHeader = value;
           
    }

    
    /**
     * 
     * xml name: affixRow
     *  
     */
    
    public java.util.List<java.lang.Object> getAffixRow(){
      return _affixRow;
    }

    
    public void setAffixRow(java.util.List<java.lang.Object> value){
        checkAllowChange();
        
        this._affixRow = value;
           
    }

    
    /**
     * 
     * xml name: affixRowClassName
     *  
     */
    
    public java.lang.String getAffixRowClassName(){
      return _affixRowClassName;
    }

    
    public void setAffixRowClassName(java.lang.String value){
        checkAllowChange();
        
        this._affixRowClassName = value;
           
    }

    
    /**
     * 
     * xml name: affixRowClassNameExpr
     *  
     */
    
    public java.lang.String getAffixRowClassNameExpr(){
      return _affixRowClassNameExpr;
    }

    
    public void setAffixRowClassNameExpr(java.lang.String value){
        checkAllowChange();
        
        this._affixRowClassNameExpr = value;
           
    }

    
    /**
     * 
     * xml name: api
     *  
     */
    
    public io.nop.xui.model.UiApiModel getApi(){
      return _api;
    }

    
    public void setApi(io.nop.xui.model.UiApiModel value){
        checkAllowChange();
        
        this._api = value;
           
    }

    
    /**
     * 
     * xml name: checkOnItemClick
     *  点击数据行是否可以勾选当前行
     */
    
    public java.lang.Boolean getCheckOnItemClick(){
      return _checkOnItemClick;
    }

    
    public void setCheckOnItemClick(java.lang.Boolean value){
        checkAllowChange();
        
        this._checkOnItemClick = value;
           
    }

    
    /**
     * 
     * xml name: className
     *  
     */
    
    public java.lang.String getClassName(){
      return _className;
    }

    
    public void setClassName(java.lang.String value){
        checkAllowChange();
        
        this._className = value;
           
    }

    
    /**
     * 
     * xml name: cols
     *  
     */
    
    public java.util.List<io.nop.xui.model.UiGridColModel> getCols(){
      return _cols;
    }

    
    public void setCols(java.util.List<io.nop.xui.model.UiGridColModel> value){
        checkAllowChange();
        
        this._cols = KeyedList.fromList(value, io.nop.xui.model.UiGridColModel::getId);
           
    }

    
    public io.nop.xui.model.UiGridColModel getCol(String name){
        return this._cols.getByKey(name);
    }

    public boolean hasCol(String name){
        return this._cols.containsKey(name);
    }

    public void addCol(io.nop.xui.model.UiGridColModel item) {
        checkAllowChange();
        java.util.List<io.nop.xui.model.UiGridColModel> list = this.getCols();
        if (list == null || list.isEmpty()) {
            list = new KeyedList<>(io.nop.xui.model.UiGridColModel::getId);
            setCols(list);
        }
        list.add(item);
    }
    
    public java.util.Set<String> keySet_cols(){
        return this._cols.keySet();
    }

    public boolean hasCols(){
        return !this._cols.isEmpty();
    }
    
    /**
     * 
     * xml name: columnNum
     *  
     */
    
    public java.lang.Integer getColumnNum(){
      return _columnNum;
    }

    
    public void setColumnNum(java.lang.Integer value){
        checkAllowChange();
        
        this._columnNum = value;
           
    }

    
    /**
     * 
     * xml name: combineFromIndex
     *  如果你不想从第一列开始合并单元格，可以配置 combineFromIndex，如果配置为 1，则会跳过第一列的合并。
     * 如果配置为 2，则会跳过第一列和第二列的合并，从第三行开始向右合并 combineNum 列。
     */
    
    public java.lang.Object getCombineFromIndex(){
      return _combineFromIndex;
    }

    
    public void setCombineFromIndex(java.lang.Object value){
        checkAllowChange();
        
        this._combineFromIndex = value;
           
    }

    
    /**
     * 
     * xml name: combineNum
     *  表示从左到右多少列内启动自动合并单元格，只要多行的同一个属性值是一样的，就会自动合并。
     */
    
    public java.lang.Integer getCombineNum(){
      return _combineNum;
    }

    
    public void setCombineNum(java.lang.Integer value){
        checkAllowChange();
        
        this._combineNum = value;
           
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
     * xml name: editMode
     *  
     */
    
    public java.lang.String getEditMode(){
      return _editMode;
    }

    
    public void setEditMode(java.lang.String value){
        checkAllowChange();
        
        this._editMode = value;
           
    }

    
    /**
     * 
     * xml name: filter
     *  
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
     * xml name: footerClassName
     *  
     */
    
    public java.lang.String getFooterClassName(){
      return _footerClassName;
    }

    
    public void setFooterClassName(java.lang.String value){
        checkAllowChange();
        
        this._footerClassName = value;
           
    }

    
    /**
     * 
     * xml name: headerClassName
     *  
     */
    
    public java.lang.String getHeaderClassName(){
      return _headerClassName;
    }

    
    public void setHeaderClassName(java.lang.String value){
        checkAllowChange();
        
        this._headerClassName = value;
           
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
     * xml name: initApi
     *  
     */
    
    public io.nop.xui.model.UiApiModel getInitApi(){
      return _initApi;
    }

    
    public void setInitApi(io.nop.xui.model.UiApiModel value){
        checkAllowChange();
        
        this._initApi = value;
           
    }

    
    /**
     * 
     * xml name: itemCheckableOn
     *  
     */
    
    public java.lang.String getItemCheckableOn(){
      return _itemCheckableOn;
    }

    
    public void setItemCheckableOn(java.lang.String value){
        checkAllowChange();
        
        this._itemCheckableOn = value;
           
    }

    
    /**
     * 
     * xml name: multiple
     *  勾选 icon 是否为多选样式checkbox， 默认为radio
     */
    
    public java.lang.Boolean getMultiple(){
      return _multiple;
    }

    
    public void setMultiple(java.lang.Boolean value){
        checkAllowChange();
        
        this._multiple = value;
           
    }

    
    /**
     * 
     * xml name: objMeta
     *  
     */
    
    public java.lang.String getObjMeta(){
      return _objMeta;
    }

    
    public void setObjMeta(java.lang.String value){
        checkAllowChange();
        
        this._objMeta = value;
           
    }

    
    /**
     * 
     * xml name: orderBy
     *  
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
     * xml name: placeholder
     *  
     */
    
    public java.lang.String getPlaceholder(){
      return _placeholder;
    }

    
    public void setPlaceholder(java.lang.String value){
        checkAllowChange();
        
        this._placeholder = value;
           
    }

    
    /**
     * 
     * xml name: prefixRow
     *  
     */
    
    public java.util.List<java.lang.Object> getPrefixRow(){
      return _prefixRow;
    }

    
    public void setPrefixRow(java.util.List<java.lang.Object> value){
        checkAllowChange();
        
        this._prefixRow = value;
           
    }

    
    /**
     * 
     * xml name: prefixRowClassName
     *  
     */
    
    public java.lang.String getPrefixRowClassName(){
      return _prefixRowClassName;
    }

    
    public void setPrefixRowClassName(java.lang.String value){
        checkAllowChange();
        
        this._prefixRowClassName = value;
           
    }

    
    /**
     * 
     * xml name: prefixRowClassNameExpr
     *  
     */
    
    public java.lang.String getPrefixRowClassNameExpr(){
      return _prefixRowClassNameExpr;
    }

    
    public void setPrefixRowClassNameExpr(java.lang.String value){
        checkAllowChange();
        
        this._prefixRowClassNameExpr = value;
           
    }

    
    /**
     * 
     * xml name: rowClassName
     *  
     */
    
    public java.lang.String getRowClassName(){
      return _rowClassName;
    }

    
    public void setRowClassName(java.lang.String value){
        checkAllowChange();
        
        this._rowClassName = value;
           
    }

    
    /**
     * 
     * xml name: rowClassNameExpr
     *  
     */
    
    public java.lang.String getRowClassNameExpr(){
      return _rowClassNameExpr;
    }

    
    public void setRowClassNameExpr(java.lang.String value){
        checkAllowChange();
        
        this._rowClassNameExpr = value;
           
    }

    
    /**
     * 
     * xml name: saveOrderApi
     *  
     */
    
    public io.nop.xui.model.UiApiModel getSaveOrderApi(){
      return _saveOrderApi;
    }

    
    public void setSaveOrderApi(io.nop.xui.model.UiApiModel value){
        checkAllowChange();
        
        this._saveOrderApi = value;
           
    }

    
    /**
     * 
     * xml name: selectable
     *  是否支持选择
     */
    
    public java.lang.Boolean getSelectable(){
      return _selectable;
    }

    
    public void setSelectable(java.lang.Boolean value){
        checkAllowChange();
        
        this._selectable = value;
           
    }

    
    /**
     * 
     * xml name: selection
     *  GraphQL查询所需要额外增加的查询字段
     */
    
    public io.nop.api.core.beans.FieldSelectionBean getSelection(){
      return _selection;
    }

    
    public void setSelection(io.nop.api.core.beans.FieldSelectionBean value){
        checkAllowChange();
        
        this._selection = value;
           
    }

    
    /**
     * 
     * xml name: sortable
     *  如果设置了sortable为false，则忽略列上面的sortable配置，整个表格不支持sortable
     */
    
    public java.lang.Boolean getSortable(){
      return _sortable;
    }

    
    public void setSortable(java.lang.Boolean value){
        checkAllowChange();
        
        this._sortable = value;
           
    }

    
    /**
     * 
     * xml name: stopAutoRefreshWhen
     *  
     */
    
    public java.lang.String getStopAutoRefreshWhen(){
      return _stopAutoRefreshWhen;
    }

    
    public void setStopAutoRefreshWhen(java.lang.String value){
        checkAllowChange();
        
        this._stopAutoRefreshWhen = value;
           
    }

    
    /**
     * 
     * xml name: toolbarClassName
     *  
     */
    
    public java.lang.String getToolbarClassName(){
      return _toolbarClassName;
    }

    
    public void setToolbarClassName(java.lang.String value){
        checkAllowChange();
        
        this._toolbarClassName = value;
           
    }

    

    @Override
    public void freeze(boolean cascade){
        if(frozen()) return;
        super.freeze(cascade);

        if(cascade){ //NOPMD - suppressed EmptyControlStatement - Auto Gen Code
        
           this._api = io.nop.api.core.util.FreezeHelper.deepFreeze(this._api);
            
           this._cols = io.nop.api.core.util.FreezeHelper.deepFreeze(this._cols);
            
           this._initApi = io.nop.api.core.util.FreezeHelper.deepFreeze(this._initApi);
            
           this._orderBy = io.nop.api.core.util.FreezeHelper.deepFreeze(this._orderBy);
            
           this._saveOrderApi = io.nop.api.core.util.FreezeHelper.deepFreeze(this._saveOrderApi);
            
        }
    }

    @Override
    protected void outputJson(IJsonHandler out){
        super.outputJson(out);
        
        out.putNotNull("affixHeader",this.getAffixHeader());
        out.putNotNull("affixRow",this.getAffixRow());
        out.putNotNull("affixRowClassName",this.getAffixRowClassName());
        out.putNotNull("affixRowClassNameExpr",this.getAffixRowClassNameExpr());
        out.putNotNull("api",this.getApi());
        out.putNotNull("checkOnItemClick",this.getCheckOnItemClick());
        out.putNotNull("className",this.getClassName());
        out.putNotNull("cols",this.getCols());
        out.putNotNull("columnNum",this.getColumnNum());
        out.putNotNull("combineFromIndex",this.getCombineFromIndex());
        out.putNotNull("combineNum",this.getCombineNum());
        out.putNotNull("displayName",this.getDisplayName());
        out.putNotNull("editMode",this.getEditMode());
        out.putNotNull("filter",this.getFilter());
        out.putNotNull("footerClassName",this.getFooterClassName());
        out.putNotNull("headerClassName",this.getHeaderClassName());
        out.putNotNull("id",this.getId());
        out.putNotNull("initApi",this.getInitApi());
        out.putNotNull("itemCheckableOn",this.getItemCheckableOn());
        out.putNotNull("multiple",this.getMultiple());
        out.putNotNull("objMeta",this.getObjMeta());
        out.putNotNull("orderBy",this.getOrderBy());
        out.putNotNull("placeholder",this.getPlaceholder());
        out.putNotNull("prefixRow",this.getPrefixRow());
        out.putNotNull("prefixRowClassName",this.getPrefixRowClassName());
        out.putNotNull("prefixRowClassNameExpr",this.getPrefixRowClassNameExpr());
        out.putNotNull("rowClassName",this.getRowClassName());
        out.putNotNull("rowClassNameExpr",this.getRowClassNameExpr());
        out.putNotNull("saveOrderApi",this.getSaveOrderApi());
        out.putNotNull("selectable",this.getSelectable());
        out.putNotNull("selection",this.getSelection());
        out.putNotNull("sortable",this.getSortable());
        out.putNotNull("stopAutoRefreshWhen",this.getStopAutoRefreshWhen());
        out.putNotNull("toolbarClassName",this.getToolbarClassName());
    }

    public UiGridModel cloneInstance(){
        UiGridModel instance = newInstance();
        this.copyTo(instance);
        return instance;
    }

    protected void copyTo(UiGridModel instance){
        super.copyTo(instance);
        
        instance.setAffixHeader(this.getAffixHeader());
        instance.setAffixRow(this.getAffixRow());
        instance.setAffixRowClassName(this.getAffixRowClassName());
        instance.setAffixRowClassNameExpr(this.getAffixRowClassNameExpr());
        instance.setApi(this.getApi());
        instance.setCheckOnItemClick(this.getCheckOnItemClick());
        instance.setClassName(this.getClassName());
        instance.setCols(this.getCols());
        instance.setColumnNum(this.getColumnNum());
        instance.setCombineFromIndex(this.getCombineFromIndex());
        instance.setCombineNum(this.getCombineNum());
        instance.setDisplayName(this.getDisplayName());
        instance.setEditMode(this.getEditMode());
        instance.setFilter(this.getFilter());
        instance.setFooterClassName(this.getFooterClassName());
        instance.setHeaderClassName(this.getHeaderClassName());
        instance.setId(this.getId());
        instance.setInitApi(this.getInitApi());
        instance.setItemCheckableOn(this.getItemCheckableOn());
        instance.setMultiple(this.getMultiple());
        instance.setObjMeta(this.getObjMeta());
        instance.setOrderBy(this.getOrderBy());
        instance.setPlaceholder(this.getPlaceholder());
        instance.setPrefixRow(this.getPrefixRow());
        instance.setPrefixRowClassName(this.getPrefixRowClassName());
        instance.setPrefixRowClassNameExpr(this.getPrefixRowClassNameExpr());
        instance.setRowClassName(this.getRowClassName());
        instance.setRowClassNameExpr(this.getRowClassNameExpr());
        instance.setSaveOrderApi(this.getSaveOrderApi());
        instance.setSelectable(this.getSelectable());
        instance.setSelection(this.getSelection());
        instance.setSortable(this.getSortable());
        instance.setStopAutoRefreshWhen(this.getStopAutoRefreshWhen());
        instance.setToolbarClassName(this.getToolbarClassName());
    }

    protected UiGridModel newInstance(){
        return (UiGridModel) ClassHelper.newInstance(getClass());
    }
}
 // resume CPD analysis - CPD-ON
