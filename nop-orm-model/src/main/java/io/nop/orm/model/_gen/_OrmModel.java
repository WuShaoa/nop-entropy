package io.nop.orm.model._gen;

import io.nop.commons.collections.KeyedList; //NOPMD NOSONAR - suppressed UnusedImports - Used for List Prop
import io.nop.core.lang.json.IJsonHandler;
import io.nop.orm.model.OrmModel;
import io.nop.commons.util.ClassHelper;



// tell cpd to start ignoring code - CPD-OFF
/**
 * generate from /nop/schema/orm/orm.xdef <p>
 * 
 */
@SuppressWarnings({"PMD.UselessOverridingMethod","PMD.UnusedLocalVariable",
    "PMD.UnnecessaryFullyQualifiedName","PMD.EmptyControlStatement","java:S116","java:S101","java:S1128","java:S1161"})
public abstract class _OrmModel extends io.nop.xlang.xdsl.AbstractDslModel {
    
    /**
     *  
     * xml name: description
     * 
     */
    private java.lang.String _description ;
    
    /**
     *  
     * xml name: dicts
     * 
     */
    private KeyedList<io.nop.api.core.beans.DictBean> _dicts = KeyedList.emptyList();
    
    /**
     *  
     * xml name: displayName
     * 
     */
    private java.lang.String _displayName ;
    
    /**
     *  
     * xml name: domains
     * 
     */
    private KeyedList<io.nop.orm.model.OrmDomainModel> _domains = KeyedList.emptyList();
    
    /**
     *  
     * xml name: entities
     * 
     */
    private KeyedList<io.nop.orm.model.OrmEntityModel> _entities = KeyedList.emptyList();
    
    /**
     *  
     * xml name: packages
     * 
     */
    private KeyedList<io.nop.orm.model.OrmPackageModel> _packages = KeyedList.emptyList();
    
    /**
     *  
     * xml name: version
     * 
     */
    private java.lang.String _version ;
    
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
     * xml name: dicts
     *  
     */
    
    public java.util.List<io.nop.api.core.beans.DictBean> getDicts(){
      return _dicts;
    }

    
    public void setDicts(java.util.List<io.nop.api.core.beans.DictBean> value){
        checkAllowChange();
        
        this._dicts = KeyedList.fromList(value, io.nop.api.core.beans.DictBean::getName);
           
    }

    
    public io.nop.api.core.beans.DictBean getDict(String name){
        return this._dicts.getByKey(name);
    }

    public boolean hasDict(String name){
        return this._dicts.containsKey(name);
    }

    public void addDict(io.nop.api.core.beans.DictBean item) {
        checkAllowChange();
        java.util.List<io.nop.api.core.beans.DictBean> list = this.getDicts();
        if (list == null || list.isEmpty()) {
            list = new KeyedList<>(io.nop.api.core.beans.DictBean::getName);
            setDicts(list);
        }
        list.add(item);
    }
    
    public java.util.Set<String> keySet_dicts(){
        return this._dicts.keySet();
    }

    public boolean hasDicts(){
        return !this._dicts.isEmpty();
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
     * xml name: domains
     *  
     */
    
    public java.util.List<io.nop.orm.model.OrmDomainModel> getDomains(){
      return _domains;
    }

    
    public void setDomains(java.util.List<io.nop.orm.model.OrmDomainModel> value){
        checkAllowChange();
        
        this._domains = KeyedList.fromList(value, io.nop.orm.model.OrmDomainModel::getName);
           
    }

    
    public io.nop.orm.model.OrmDomainModel getDomain(String name){
        return this._domains.getByKey(name);
    }

    public boolean hasDomain(String name){
        return this._domains.containsKey(name);
    }

    public void addDomain(io.nop.orm.model.OrmDomainModel item) {
        checkAllowChange();
        java.util.List<io.nop.orm.model.OrmDomainModel> list = this.getDomains();
        if (list == null || list.isEmpty()) {
            list = new KeyedList<>(io.nop.orm.model.OrmDomainModel::getName);
            setDomains(list);
        }
        list.add(item);
    }
    
    public java.util.Set<String> keySet_domains(){
        return this._domains.keySet();
    }

    public boolean hasDomains(){
        return !this._domains.isEmpty();
    }
    
    /**
     * 
     * xml name: entities
     *  
     */
    
    public java.util.List<io.nop.orm.model.OrmEntityModel> getEntities(){
      return _entities;
    }

    
    public void setEntities(java.util.List<io.nop.orm.model.OrmEntityModel> value){
        checkAllowChange();
        
        this._entities = KeyedList.fromList(value, io.nop.orm.model.OrmEntityModel::getName);
           
    }

    
    public io.nop.orm.model.OrmEntityModel getEntity(String name){
        return this._entities.getByKey(name);
    }

    public boolean hasEntity(String name){
        return this._entities.containsKey(name);
    }

    public void addEntity(io.nop.orm.model.OrmEntityModel item) {
        checkAllowChange();
        java.util.List<io.nop.orm.model.OrmEntityModel> list = this.getEntities();
        if (list == null || list.isEmpty()) {
            list = new KeyedList<>(io.nop.orm.model.OrmEntityModel::getName);
            setEntities(list);
        }
        list.add(item);
    }
    
    public java.util.Set<String> keySet_entities(){
        return this._entities.keySet();
    }

    public boolean hasEntities(){
        return !this._entities.isEmpty();
    }
    
    /**
     * 
     * xml name: packages
     *  
     */
    
    public java.util.List<io.nop.orm.model.OrmPackageModel> getPackages(){
      return _packages;
    }

    
    public void setPackages(java.util.List<io.nop.orm.model.OrmPackageModel> value){
        checkAllowChange();
        
        this._packages = KeyedList.fromList(value, io.nop.orm.model.OrmPackageModel::getName);
           
    }

    
    public io.nop.orm.model.OrmPackageModel getPackage(String name){
        return this._packages.getByKey(name);
    }

    public boolean hasPackage(String name){
        return this._packages.containsKey(name);
    }

    public void addPackage(io.nop.orm.model.OrmPackageModel item) {
        checkAllowChange();
        java.util.List<io.nop.orm.model.OrmPackageModel> list = this.getPackages();
        if (list == null || list.isEmpty()) {
            list = new KeyedList<>(io.nop.orm.model.OrmPackageModel::getName);
            setPackages(list);
        }
        list.add(item);
    }
    
    public java.util.Set<String> keySet_packages(){
        return this._packages.keySet();
    }

    public boolean hasPackages(){
        return !this._packages.isEmpty();
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

    

    @Override
    public void freeze(boolean cascade){
        if(frozen()) return;
        super.freeze(cascade);

        if(cascade){ //NOPMD - suppressed EmptyControlStatement - Auto Gen Code
        
           this._dicts = io.nop.api.core.util.FreezeHelper.deepFreeze(this._dicts);
            
           this._domains = io.nop.api.core.util.FreezeHelper.deepFreeze(this._domains);
            
           this._entities = io.nop.api.core.util.FreezeHelper.deepFreeze(this._entities);
            
           this._packages = io.nop.api.core.util.FreezeHelper.deepFreeze(this._packages);
            
        }
    }

    @Override
    protected void outputJson(IJsonHandler out){
        super.outputJson(out);
        
        out.putNotNull("description",this.getDescription());
        out.putNotNull("dicts",this.getDicts());
        out.putNotNull("displayName",this.getDisplayName());
        out.putNotNull("domains",this.getDomains());
        out.putNotNull("entities",this.getEntities());
        out.putNotNull("packages",this.getPackages());
        out.putNotNull("version",this.getVersion());
    }

    public OrmModel cloneInstance(){
        OrmModel instance = newInstance();
        this.copyTo(instance);
        return instance;
    }

    protected void copyTo(OrmModel instance){
        super.copyTo(instance);
        
        instance.setDescription(this.getDescription());
        instance.setDicts(this.getDicts());
        instance.setDisplayName(this.getDisplayName());
        instance.setDomains(this.getDomains());
        instance.setEntities(this.getEntities());
        instance.setPackages(this.getPackages());
        instance.setVersion(this.getVersion());
    }

    protected OrmModel newInstance(){
        return (OrmModel) ClassHelper.newInstance(getClass());
    }
}
 // resume CPD analysis - CPD-ON
