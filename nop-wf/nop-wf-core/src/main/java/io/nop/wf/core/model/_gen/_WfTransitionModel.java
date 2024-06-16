package io.nop.wf.core.model._gen;

import io.nop.commons.collections.KeyedList; //NOPMD NOSONAR - suppressed UnusedImports - Used for List Prop
import io.nop.core.lang.json.IJsonHandler;
import io.nop.wf.core.model.WfTransitionModel;
import io.nop.commons.util.ClassHelper;



// tell cpd to start ignoring code - CPD-OFF
/**
 * generate from /nop/schema/wf/wf.xdef <p>
 * 
 */
@SuppressWarnings({"PMD.UselessOverridingMethod","PMD.UnusedLocalVariable",
    "PMD.UnnecessaryFullyQualifiedName","PMD.EmptyControlStatement","java:S116","java:S101","java:S1128","java:S1161"})
public abstract class _WfTransitionModel extends io.nop.core.resource.component.AbstractComponentModel {
    
    /**
     *  
     * xml name: appState
     * 设置步骤实例上的appState字段
     */
    private java.lang.String _appState ;
    
    /**
     *  
     * xml name: bizEntityState
     * 
     */
    private java.lang.String _bizEntityState ;
    
    /**
     *  
     * xml name: onAppStates
     * 当步骤的appState为指定值的时候才会触发transition
     */
    private java.util.Set<java.lang.String> _onAppStates ;
    
    /**
     *  
     * xml name: splitType
     * 分支类型，and表示每个分支都执行，or表示从上至下执行，只执行第一个满足条件的迁移目标。缺省为and
     */
    private io.nop.wf.core.model.WfSplitType _splitType ;
    
    /**
     *  
     * xml name: to-assigned
     * 
     */
    private io.nop.wf.core.model.WfTransitionToAssignedModel _toAssigned ;
    
    /**
     *  
     * xml name: to-empty
     * 迁移到空步骤。结束本步骤，但是没有创建新的步骤实例
     */
    private io.nop.wf.core.model.WfTransitionToEmptyModel _toEmpty ;
    
    /**
     *  
     * xml name: to-end
     * 
     */
    private io.nop.wf.core.model.WfTransitionToEndModel _toEnd ;
    
    /**
     *  
     * xml name: to-step
     * 
     */
    private KeyedList<io.nop.wf.core.model.WfTransitionToStepModel> _toSteps = KeyedList.emptyList();
    
    /**
     *  
     * xml name: wfAppState
     * 设置工作流实例wfRecord上的appState字段
     */
    private java.lang.String _wfAppState ;
    
    /**
     * 
     * xml name: appState
     *  设置步骤实例上的appState字段
     */
    
    public java.lang.String getAppState(){
      return _appState;
    }

    
    public void setAppState(java.lang.String value){
        checkAllowChange();
        
        this._appState = value;
           
    }

    
    /**
     * 
     * xml name: bizEntityState
     *  
     */
    
    public java.lang.String getBizEntityState(){
      return _bizEntityState;
    }

    
    public void setBizEntityState(java.lang.String value){
        checkAllowChange();
        
        this._bizEntityState = value;
           
    }

    
    /**
     * 
     * xml name: onAppStates
     *  当步骤的appState为指定值的时候才会触发transition
     */
    
    public java.util.Set<java.lang.String> getOnAppStates(){
      return _onAppStates;
    }

    
    public void setOnAppStates(java.util.Set<java.lang.String> value){
        checkAllowChange();
        
        this._onAppStates = value;
           
    }

    
    /**
     * 
     * xml name: splitType
     *  分支类型，and表示每个分支都执行，or表示从上至下执行，只执行第一个满足条件的迁移目标。缺省为and
     */
    
    public io.nop.wf.core.model.WfSplitType getSplitType(){
      return _splitType;
    }

    
    public void setSplitType(io.nop.wf.core.model.WfSplitType value){
        checkAllowChange();
        
        this._splitType = value;
           
    }

    
    /**
     * 
     * xml name: to-assigned
     *  
     */
    
    public io.nop.wf.core.model.WfTransitionToAssignedModel getToAssigned(){
      return _toAssigned;
    }

    
    public void setToAssigned(io.nop.wf.core.model.WfTransitionToAssignedModel value){
        checkAllowChange();
        
        this._toAssigned = value;
           
    }

    
    /**
     * 
     * xml name: to-empty
     *  迁移到空步骤。结束本步骤，但是没有创建新的步骤实例
     */
    
    public io.nop.wf.core.model.WfTransitionToEmptyModel getToEmpty(){
      return _toEmpty;
    }

    
    public void setToEmpty(io.nop.wf.core.model.WfTransitionToEmptyModel value){
        checkAllowChange();
        
        this._toEmpty = value;
           
    }

    
    /**
     * 
     * xml name: to-end
     *  
     */
    
    public io.nop.wf.core.model.WfTransitionToEndModel getToEnd(){
      return _toEnd;
    }

    
    public void setToEnd(io.nop.wf.core.model.WfTransitionToEndModel value){
        checkAllowChange();
        
        this._toEnd = value;
           
    }

    
    /**
     * 
     * xml name: to-step
     *  
     */
    
    public java.util.List<io.nop.wf.core.model.WfTransitionToStepModel> getToSteps(){
      return _toSteps;
    }

    
    public void setToSteps(java.util.List<io.nop.wf.core.model.WfTransitionToStepModel> value){
        checkAllowChange();
        
        this._toSteps = KeyedList.fromList(value, io.nop.wf.core.model.WfTransitionToStepModel::getStepName);
           
    }

    
    public io.nop.wf.core.model.WfTransitionToStepModel getToStep(String name){
        return this._toSteps.getByKey(name);
    }

    public boolean hasToStep(String name){
        return this._toSteps.containsKey(name);
    }

    public void addToStep(io.nop.wf.core.model.WfTransitionToStepModel item) {
        checkAllowChange();
        java.util.List<io.nop.wf.core.model.WfTransitionToStepModel> list = this.getToSteps();
        if (list == null || list.isEmpty()) {
            list = new KeyedList<>(io.nop.wf.core.model.WfTransitionToStepModel::getStepName);
            setToSteps(list);
        }
        list.add(item);
    }
    
    public java.util.Set<String> keySet_toSteps(){
        return this._toSteps.keySet();
    }

    public boolean hasToSteps(){
        return !this._toSteps.isEmpty();
    }
    
    /**
     * 
     * xml name: wfAppState
     *  设置工作流实例wfRecord上的appState字段
     */
    
    public java.lang.String getWfAppState(){
      return _wfAppState;
    }

    
    public void setWfAppState(java.lang.String value){
        checkAllowChange();
        
        this._wfAppState = value;
           
    }

    

    @Override
    public void freeze(boolean cascade){
        if(frozen()) return;
        super.freeze(cascade);

        if(cascade){ //NOPMD - suppressed EmptyControlStatement - Auto Gen Code
        
           this._toAssigned = io.nop.api.core.util.FreezeHelper.deepFreeze(this._toAssigned);
            
           this._toEmpty = io.nop.api.core.util.FreezeHelper.deepFreeze(this._toEmpty);
            
           this._toEnd = io.nop.api.core.util.FreezeHelper.deepFreeze(this._toEnd);
            
           this._toSteps = io.nop.api.core.util.FreezeHelper.deepFreeze(this._toSteps);
            
        }
    }

    @Override
    protected void outputJson(IJsonHandler out){
        super.outputJson(out);
        
        out.putNotNull("appState",this.getAppState());
        out.putNotNull("bizEntityState",this.getBizEntityState());
        out.putNotNull("onAppStates",this.getOnAppStates());
        out.putNotNull("splitType",this.getSplitType());
        out.putNotNull("toAssigned",this.getToAssigned());
        out.putNotNull("toEmpty",this.getToEmpty());
        out.putNotNull("toEnd",this.getToEnd());
        out.putNotNull("toSteps",this.getToSteps());
        out.putNotNull("wfAppState",this.getWfAppState());
    }

    public WfTransitionModel cloneInstance(){
        WfTransitionModel instance = newInstance();
        this.copyTo(instance);
        return instance;
    }

    protected void copyTo(WfTransitionModel instance){
        super.copyTo(instance);
        
        instance.setAppState(this.getAppState());
        instance.setBizEntityState(this.getBizEntityState());
        instance.setOnAppStates(this.getOnAppStates());
        instance.setSplitType(this.getSplitType());
        instance.setToAssigned(this.getToAssigned());
        instance.setToEmpty(this.getToEmpty());
        instance.setToEnd(this.getToEnd());
        instance.setToSteps(this.getToSteps());
        instance.setWfAppState(this.getWfAppState());
    }

    protected WfTransitionModel newInstance(){
        return (WfTransitionModel) ClassHelper.newInstance(getClass());
    }
}
 // resume CPD analysis - CPD-ON
