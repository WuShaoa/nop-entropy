package io.nop.fsm.model._gen;

import io.nop.commons.collections.KeyedList; //NOPMD NOSONAR - suppressed UnusedImports - Used for List Prop
import io.nop.core.lang.json.IJsonHandler;
import io.nop.fsm.model.StateTransitionModel;
import io.nop.commons.util.ClassHelper;



// tell cpd to start ignoring code - CPD-OFF
/**
 * generate from /nop/schema/biz/state-machine.xdef <p>
 * 
 */
@SuppressWarnings({"PMD.UselessOverridingMethod","PMD.UnusedLocalVariable",
    "PMD.UnnecessaryFullyQualifiedName","PMD.EmptyControlStatement","java:S116","java:S101","java:S1128","java:S1161"})
public abstract class _StateTransitionModel extends io.nop.core.resource.component.AbstractComponentModel {
    
    /**
     *  
     * xml name: actions
     * 迁移到目标状态之后执行的action的列表
     */
    private java.util.Set<java.lang.String> _actions ;
    
    /**
     *  
     * xml name: event
     * 事件的名称。规定了如下特殊的名称：always表示自动触发，不需要收到事件。 *表示任意事件都导致触发。
     */
    private java.lang.String _event ;
    
    /**
     *  
     * xml name: id
     * 
     */
    private java.lang.String _id  = "@event";
    
    /**
     *  
     * xml name: in
     * 判断当前状态是否为指定状态。格式符合xstate的约定，例如 in="#closed"。 #表示从根路径开始
     */
    private java.lang.String _in ;
    
    /**
     *  
     * xml name: internal
     * 
     */
    private boolean _internal  = false;
    
    /**
     *  
     * xml name: invoke
     * 在迁移到目标状态之前执行
     */
    private io.nop.core.lang.eval.IEvalAction _invoke ;
    
    /**
     *  
     * xml name: target
     * 迁移到的目标状态。如果internal为true，则表示迁移到内部状态，不会触发entry/exit。如果target为空，则表示保持当前状态只触发监听器
     */
    private java.lang.String _target ;
    
    /**
     *  
     * xml name: when
     * 
     */
    private io.nop.core.lang.eval.IEvalPredicate _when ;
    
    /**
     * 
     * xml name: actions
     *  迁移到目标状态之后执行的action的列表
     */
    
    public java.util.Set<java.lang.String> getActions(){
      return _actions;
    }

    
    public void setActions(java.util.Set<java.lang.String> value){
        checkAllowChange();
        
        this._actions = value;
           
    }

    
    /**
     * 
     * xml name: event
     *  事件的名称。规定了如下特殊的名称：always表示自动触发，不需要收到事件。 *表示任意事件都导致触发。
     */
    
    public java.lang.String getEvent(){
      return _event;
    }

    
    public void setEvent(java.lang.String value){
        checkAllowChange();
        
        this._event = value;
           
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
     * xml name: in
     *  判断当前状态是否为指定状态。格式符合xstate的约定，例如 in="#closed"。 #表示从根路径开始
     */
    
    public java.lang.String getIn(){
      return _in;
    }

    
    public void setIn(java.lang.String value){
        checkAllowChange();
        
        this._in = value;
           
    }

    
    /**
     * 
     * xml name: internal
     *  
     */
    
    public boolean isInternal(){
      return _internal;
    }

    
    public void setInternal(boolean value){
        checkAllowChange();
        
        this._internal = value;
           
    }

    
    /**
     * 
     * xml name: invoke
     *  在迁移到目标状态之前执行
     */
    
    public io.nop.core.lang.eval.IEvalAction getInvoke(){
      return _invoke;
    }

    
    public void setInvoke(io.nop.core.lang.eval.IEvalAction value){
        checkAllowChange();
        
        this._invoke = value;
           
    }

    
    /**
     * 
     * xml name: target
     *  迁移到的目标状态。如果internal为true，则表示迁移到内部状态，不会触发entry/exit。如果target为空，则表示保持当前状态只触发监听器
     */
    
    public java.lang.String getTarget(){
      return _target;
    }

    
    public void setTarget(java.lang.String value){
        checkAllowChange();
        
        this._target = value;
           
    }

    
    /**
     * 
     * xml name: when
     *  
     */
    
    public io.nop.core.lang.eval.IEvalPredicate getWhen(){
      return _when;
    }

    
    public void setWhen(io.nop.core.lang.eval.IEvalPredicate value){
        checkAllowChange();
        
        this._when = value;
           
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
        
        out.putNotNull("actions",this.getActions());
        out.putNotNull("event",this.getEvent());
        out.putNotNull("id",this.getId());
        out.putNotNull("in",this.getIn());
        out.putNotNull("internal",this.isInternal());
        out.putNotNull("invoke",this.getInvoke());
        out.putNotNull("target",this.getTarget());
        out.putNotNull("when",this.getWhen());
    }

    public StateTransitionModel cloneInstance(){
        StateTransitionModel instance = newInstance();
        this.copyTo(instance);
        return instance;
    }

    protected void copyTo(StateTransitionModel instance){
        super.copyTo(instance);
        
        instance.setActions(this.getActions());
        instance.setEvent(this.getEvent());
        instance.setId(this.getId());
        instance.setIn(this.getIn());
        instance.setInternal(this.isInternal());
        instance.setInvoke(this.getInvoke());
        instance.setTarget(this.getTarget());
        instance.setWhen(this.getWhen());
    }

    protected StateTransitionModel newInstance(){
        return (StateTransitionModel) ClassHelper.newInstance(getClass());
    }
}
 // resume CPD analysis - CPD-ON
