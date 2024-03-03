package io.nop.orm.sql_lib._gen;

import io.nop.commons.collections.KeyedList; //NOPMD NOSONAR - suppressed UnusedImports - Used for List Prop
import io.nop.core.lang.json.IJsonHandler;
import io.nop.orm.sql_lib.NativeSqlItemModel;
import io.nop.commons.util.ClassHelper;



// tell cpd to start ignoring code - CPD-OFF
/**
 * generate from [72:10:0:0]/nop/schema/orm/sql-lib.xdef <p>
 * 
 */
@SuppressWarnings({"PMD.UselessOverridingMethod","PMD.UnusedLocalVariable",
    "PMD.UnnecessaryFullyQualifiedName","PMD.EmptyControlStatement","java:S116","java:S101","java:S1128","java:S1161"})
public abstract class _NativeSqlItemModel extends io.nop.orm.sql_lib.SqlItemModel {
    
    /**
     *  
     * xml name: colNameCamelCase
     * sql语句返回的列名是否按照下划线分隔变换成camelCase形式作为返回字段名
     */
    private boolean _colNameCamelCase  = false;
    
    /**
     *  
     * xml name: source
     * 
     */
    private io.nop.core.lang.sql.ISqlGenerator _source ;
    
    /**
     * 
     * xml name: colNameCamelCase
     *  sql语句返回的列名是否按照下划线分隔变换成camelCase形式作为返回字段名
     */
    
    public boolean isColNameCamelCase(){
      return _colNameCamelCase;
    }

    
    public void setColNameCamelCase(boolean value){
        checkAllowChange();
        
        this._colNameCamelCase = value;
           
    }

    
    /**
     * 
     * xml name: source
     *  
     */
    
    public io.nop.core.lang.sql.ISqlGenerator getSource(){
      return _source;
    }

    
    public void setSource(io.nop.core.lang.sql.ISqlGenerator value){
        checkAllowChange();
        
        this._source = value;
           
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
        
        out.putNotNull("colNameCamelCase",this.isColNameCamelCase());
        out.putNotNull("source",this.getSource());
    }

    public NativeSqlItemModel cloneInstance(){
        NativeSqlItemModel instance = newInstance();
        this.copyTo(instance);
        return instance;
    }

    protected void copyTo(NativeSqlItemModel instance){
        super.copyTo(instance);
        
        instance.setColNameCamelCase(this.isColNameCamelCase());
        instance.setSource(this.getSource());
    }

    protected NativeSqlItemModel newInstance(){
        return (NativeSqlItemModel) ClassHelper.newInstance(getClass());
    }
}
 // resume CPD analysis - CPD-ON
