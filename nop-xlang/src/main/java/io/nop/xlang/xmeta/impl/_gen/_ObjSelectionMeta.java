package io.nop.xlang.xmeta.impl._gen;

import io.nop.commons.collections.KeyedList; //NOPMD NOSONAR - suppressed UnusedImports - Used for List Prop
import io.nop.core.lang.json.IJsonHandler;
import io.nop.xlang.xmeta.impl.ObjSelectionMeta;
import io.nop.commons.util.ClassHelper;



// tell cpd to start ignoring code - CPD-OFF
/**
 * generate from /nop/schema/xmeta.xdef <p>
 * 字段选择集合。
 */
@SuppressWarnings({"PMD.UselessOverridingMethod","PMD.UnusedLocalVariable",
    "PMD.UnnecessaryFullyQualifiedName","PMD.EmptyControlStatement","java:S116","java:S101","java:S1128","java:S1161"})
public abstract class _ObjSelectionMeta extends io.nop.core.resource.component.AbstractComponentModel {
    
    /**
     *  
     * xml name: displayName
     * 
     */
    private java.lang.String _displayName ;
    
    /**
     *  
     * xml name: id
     * 
     */
    private java.lang.String _id ;
    
    /**
     *  
     * xml name: 
     * 
     */
    private io.nop.api.core.beans.FieldSelectionBean _mapping ;
    
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
     * xml name: 
     *  
     */
    
    public io.nop.api.core.beans.FieldSelectionBean getMapping(){
      return _mapping;
    }

    
    public void setMapping(io.nop.api.core.beans.FieldSelectionBean value){
        checkAllowChange();
        
        this._mapping = value;
           
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
        
        out.putNotNull("displayName",this.getDisplayName());
        out.putNotNull("id",this.getId());
        out.putNotNull("mapping",this.getMapping());
    }

    public ObjSelectionMeta cloneInstance(){
        ObjSelectionMeta instance = newInstance();
        this.copyTo(instance);
        return instance;
    }

    protected void copyTo(ObjSelectionMeta instance){
        super.copyTo(instance);
        
        instance.setDisplayName(this.getDisplayName());
        instance.setId(this.getId());
        instance.setMapping(this.getMapping());
    }

    protected ObjSelectionMeta newInstance(){
        return (ObjSelectionMeta) ClassHelper.newInstance(getClass());
    }
}
 // resume CPD analysis - CPD-ON
