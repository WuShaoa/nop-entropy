package io.nop.dao.dialect.model._gen;

import io.nop.commons.collections.KeyedList; //NOPMD NOSONAR - suppressed UnusedImports - Used for List Prop
import io.nop.core.lang.json.IJsonHandler;
import io.nop.dao.dialect.model.SqlDataTypeModel;
import io.nop.commons.util.ClassHelper;



// tell cpd to start ignoring code - CPD-OFF
/**
 * generate from /nop/schema/orm/dialect.xdef <p>
 * 
 */
@SuppressWarnings({"PMD.UselessOverridingMethod","PMD.UnusedLocalVariable",
    "PMD.UnnecessaryFullyQualifiedName","PMD.EmptyControlStatement","java:S116","java:S101","java:S1128","java:S1161"})
public abstract class _SqlDataTypeModel extends io.nop.core.resource.component.AbstractComponentModel {
    
    /**
     *  
     * xml name: alias
     * 数据类型的别名列表，通过逗号分隔
     */
    private java.util.Set<java.lang.String> _alias ;
    
    /**
     *  
     * xml name: allowExceedPrecision
     * 
     */
    private boolean _allowExceedPrecision  = false;
    
    /**
     *  
     * xml name: allowPrecision
     * 类型定义是否已经隐含假定了precision，因此不允许在SQL类型定义中再指定precision。
     * allowPrecision为false时，precision仍然可以有值，它表示的是隐含定义的precision
     */
    private java.lang.Boolean _allowPrecision ;
    
    /**
     *  
     * xml name: code
     * 数据库中的类型名称。oracle数据库中对DATETIME和DATE类型是不区分的，但是这两者原则上应该映射为不同的StdSqlType，
     * 此时可以通过code来实现区分。即name为DATETIME和DATE，但是code设置为DATE
     */
    private java.lang.String _code ;
    
    /**
     *  
     * xml name: deprecated
     * 虽然数据库支持，但是应用程序并不会使用此类型。IDialect.stdToNativeType转换时会忽略此类型
     */
    private boolean _deprecated  = false;
    
    /**
     *  
     * xml name: jdbcBinder
     * 
     */
    private java.lang.String _jdbcBinder ;
    
    /**
     *  
     * xml name: name
     * 
     */
    private java.lang.String _name ;
    
    /**
     *  
     * xml name: precision
     * 
     */
    private java.lang.Integer _precision ;
    
    /**
     *  
     * xml name: scale
     * 
     */
    private java.lang.Integer _scale ;
    
    /**
     *  
     * xml name: stdSqlType
     * 
     */
    private io.nop.commons.type.StdSqlType _stdSqlType ;
    
    /**
     * 
     * xml name: alias
     *  数据类型的别名列表，通过逗号分隔
     */
    
    public java.util.Set<java.lang.String> getAlias(){
      return _alias;
    }

    
    public void setAlias(java.util.Set<java.lang.String> value){
        checkAllowChange();
        
        this._alias = value;
           
    }

    
    /**
     * 
     * xml name: allowExceedPrecision
     *  
     */
    
    public boolean isAllowExceedPrecision(){
      return _allowExceedPrecision;
    }

    
    public void setAllowExceedPrecision(boolean value){
        checkAllowChange();
        
        this._allowExceedPrecision = value;
           
    }

    
    /**
     * 
     * xml name: allowPrecision
     *  类型定义是否已经隐含假定了precision，因此不允许在SQL类型定义中再指定precision。
     * allowPrecision为false时，precision仍然可以有值，它表示的是隐含定义的precision
     */
    
    public java.lang.Boolean getAllowPrecision(){
      return _allowPrecision;
    }

    
    public void setAllowPrecision(java.lang.Boolean value){
        checkAllowChange();
        
        this._allowPrecision = value;
           
    }

    
    /**
     * 
     * xml name: code
     *  数据库中的类型名称。oracle数据库中对DATETIME和DATE类型是不区分的，但是这两者原则上应该映射为不同的StdSqlType，
     * 此时可以通过code来实现区分。即name为DATETIME和DATE，但是code设置为DATE
     */
    
    public java.lang.String getCode(){
      return _code;
    }

    
    public void setCode(java.lang.String value){
        checkAllowChange();
        
        this._code = value;
           
    }

    
    /**
     * 
     * xml name: deprecated
     *  虽然数据库支持，但是应用程序并不会使用此类型。IDialect.stdToNativeType转换时会忽略此类型
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
     * xml name: jdbcBinder
     *  
     */
    
    public java.lang.String getJdbcBinder(){
      return _jdbcBinder;
    }

    
    public void setJdbcBinder(java.lang.String value){
        checkAllowChange();
        
        this._jdbcBinder = value;
           
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
     * xml name: precision
     *  
     */
    
    public java.lang.Integer getPrecision(){
      return _precision;
    }

    
    public void setPrecision(java.lang.Integer value){
        checkAllowChange();
        
        this._precision = value;
           
    }

    
    /**
     * 
     * xml name: scale
     *  
     */
    
    public java.lang.Integer getScale(){
      return _scale;
    }

    
    public void setScale(java.lang.Integer value){
        checkAllowChange();
        
        this._scale = value;
           
    }

    
    /**
     * 
     * xml name: stdSqlType
     *  
     */
    
    public io.nop.commons.type.StdSqlType getStdSqlType(){
      return _stdSqlType;
    }

    
    public void setStdSqlType(io.nop.commons.type.StdSqlType value){
        checkAllowChange();
        
        this._stdSqlType = value;
           
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
        
        out.putNotNull("alias",this.getAlias());
        out.putNotNull("allowExceedPrecision",this.isAllowExceedPrecision());
        out.putNotNull("allowPrecision",this.getAllowPrecision());
        out.putNotNull("code",this.getCode());
        out.putNotNull("deprecated",this.isDeprecated());
        out.putNotNull("jdbcBinder",this.getJdbcBinder());
        out.putNotNull("name",this.getName());
        out.putNotNull("precision",this.getPrecision());
        out.putNotNull("scale",this.getScale());
        out.putNotNull("stdSqlType",this.getStdSqlType());
    }

    public SqlDataTypeModel cloneInstance(){
        SqlDataTypeModel instance = newInstance();
        this.copyTo(instance);
        return instance;
    }

    protected void copyTo(SqlDataTypeModel instance){
        super.copyTo(instance);
        
        instance.setAlias(this.getAlias());
        instance.setAllowExceedPrecision(this.isAllowExceedPrecision());
        instance.setAllowPrecision(this.getAllowPrecision());
        instance.setCode(this.getCode());
        instance.setDeprecated(this.isDeprecated());
        instance.setJdbcBinder(this.getJdbcBinder());
        instance.setName(this.getName());
        instance.setPrecision(this.getPrecision());
        instance.setScale(this.getScale());
        instance.setStdSqlType(this.getStdSqlType());
    }

    protected SqlDataTypeModel newInstance(){
        return (SqlDataTypeModel) ClassHelper.newInstance(getClass());
    }
}
 // resume CPD analysis - CPD-ON
