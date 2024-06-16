package io.nop.stream.cep.model._gen;

import io.nop.commons.collections.KeyedList; //NOPMD NOSONAR - suppressed UnusedImports - Used for List Prop
import io.nop.core.lang.json.IJsonHandler;
import io.nop.stream.cep.model.CepPatternPartModel;
import io.nop.commons.util.ClassHelper;



// tell cpd to start ignoring code - CPD-OFF
/**
 * generate from /nop/schema/stream/pattern.xdef <p>
 * 
 */
@SuppressWarnings({"PMD.UselessOverridingMethod","PMD.UnusedLocalVariable",
    "PMD.UnnecessaryFullyQualifiedName","PMD.EmptyControlStatement","java:S116","java:S101","java:S1128","java:S1161"})
public abstract class _CepPatternPartModel extends io.nop.core.resource.component.AbstractComponentModel {
    
    /**
     *  
     * xml name: allowCombinations
     * 
     */
    private boolean _allowCombinations  = false;
    
    /**
     *  
     * xml name: consecutive
     * 
     */
    private boolean _consecutive  = false;
    
    /**
     *  
     * xml name: followKind
     * 
     */
    private io.nop.stream.cep.model.FollowKind _followKind ;
    
    /**
     *  
     * xml name: greedy
     * 贪心匹配模式
     */
    private boolean _greedy  = false;
    
    /**
     *  
     * xml name: name
     * 
     */
    private java.lang.String _name ;
    
    /**
     *  
     * xml name: next
     * 
     */
    private java.lang.String _next ;
    
    /**
     *  
     * xml name: oneOrMore
     * 匹配一次或者多次
     */
    private boolean _oneOrMore  = false;
    
    /**
     *  
     * xml name: optional
     * 模式可选
     */
    private boolean _optional  = false;
    
    /**
     *  
     * xml name: subType
     * 
     */
    private java.lang.String _subType ;
    
    /**
     *  
     * xml name: times
     * 重复指定次数
     */
    private io.nop.api.core.beans.IntRangeBean _times ;
    
    /**
     *  
     * xml name: timesOrMore
     * 匹配指定次数或者更多次
     */
    private java.lang.Integer _timesOrMore ;
    
    /**
     *  
     * xml name: windowTime
     * 
     */
    private java.time.Duration _windowTime ;
    
    /**
     * 
     * xml name: allowCombinations
     *  
     */
    
    public boolean isAllowCombinations(){
      return _allowCombinations;
    }

    
    public void setAllowCombinations(boolean value){
        checkAllowChange();
        
        this._allowCombinations = value;
           
    }

    
    /**
     * 
     * xml name: consecutive
     *  
     */
    
    public boolean isConsecutive(){
      return _consecutive;
    }

    
    public void setConsecutive(boolean value){
        checkAllowChange();
        
        this._consecutive = value;
           
    }

    
    /**
     * 
     * xml name: followKind
     *  
     */
    
    public io.nop.stream.cep.model.FollowKind getFollowKind(){
      return _followKind;
    }

    
    public void setFollowKind(io.nop.stream.cep.model.FollowKind value){
        checkAllowChange();
        
        this._followKind = value;
           
    }

    
    /**
     * 
     * xml name: greedy
     *  贪心匹配模式
     */
    
    public boolean isGreedy(){
      return _greedy;
    }

    
    public void setGreedy(boolean value){
        checkAllowChange();
        
        this._greedy = value;
           
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
     * xml name: next
     *  
     */
    
    public java.lang.String getNext(){
      return _next;
    }

    
    public void setNext(java.lang.String value){
        checkAllowChange();
        
        this._next = value;
           
    }

    
    /**
     * 
     * xml name: oneOrMore
     *  匹配一次或者多次
     */
    
    public boolean isOneOrMore(){
      return _oneOrMore;
    }

    
    public void setOneOrMore(boolean value){
        checkAllowChange();
        
        this._oneOrMore = value;
           
    }

    
    /**
     * 
     * xml name: optional
     *  模式可选
     */
    
    public boolean isOptional(){
      return _optional;
    }

    
    public void setOptional(boolean value){
        checkAllowChange();
        
        this._optional = value;
           
    }

    
    /**
     * 
     * xml name: subType
     *  
     */
    
    public java.lang.String getSubType(){
      return _subType;
    }

    
    public void setSubType(java.lang.String value){
        checkAllowChange();
        
        this._subType = value;
           
    }

    
    /**
     * 
     * xml name: times
     *  重复指定次数
     */
    
    public io.nop.api.core.beans.IntRangeBean getTimes(){
      return _times;
    }

    
    public void setTimes(io.nop.api.core.beans.IntRangeBean value){
        checkAllowChange();
        
        this._times = value;
           
    }

    
    /**
     * 
     * xml name: timesOrMore
     *  匹配指定次数或者更多次
     */
    
    public java.lang.Integer getTimesOrMore(){
      return _timesOrMore;
    }

    
    public void setTimesOrMore(java.lang.Integer value){
        checkAllowChange();
        
        this._timesOrMore = value;
           
    }

    
    /**
     * 
     * xml name: windowTime
     *  
     */
    
    public java.time.Duration getWindowTime(){
      return _windowTime;
    }

    
    public void setWindowTime(java.time.Duration value){
        checkAllowChange();
        
        this._windowTime = value;
           
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
        
        out.putNotNull("allowCombinations",this.isAllowCombinations());
        out.putNotNull("consecutive",this.isConsecutive());
        out.putNotNull("followKind",this.getFollowKind());
        out.putNotNull("greedy",this.isGreedy());
        out.putNotNull("name",this.getName());
        out.putNotNull("next",this.getNext());
        out.putNotNull("oneOrMore",this.isOneOrMore());
        out.putNotNull("optional",this.isOptional());
        out.putNotNull("subType",this.getSubType());
        out.putNotNull("times",this.getTimes());
        out.putNotNull("timesOrMore",this.getTimesOrMore());
        out.putNotNull("windowTime",this.getWindowTime());
    }

    public CepPatternPartModel cloneInstance(){
        CepPatternPartModel instance = newInstance();
        this.copyTo(instance);
        return instance;
    }

    protected void copyTo(CepPatternPartModel instance){
        super.copyTo(instance);
        
        instance.setAllowCombinations(this.isAllowCombinations());
        instance.setConsecutive(this.isConsecutive());
        instance.setFollowKind(this.getFollowKind());
        instance.setGreedy(this.isGreedy());
        instance.setName(this.getName());
        instance.setNext(this.getNext());
        instance.setOneOrMore(this.isOneOrMore());
        instance.setOptional(this.isOptional());
        instance.setSubType(this.getSubType());
        instance.setTimes(this.getTimes());
        instance.setTimesOrMore(this.getTimesOrMore());
        instance.setWindowTime(this.getWindowTime());
    }

    protected CepPatternPartModel newInstance(){
        return (CepPatternPartModel) ClassHelper.newInstance(getClass());
    }
}
 // resume CPD analysis - CPD-ON
