package io.nop.core.model.validator._gen;

import io.nop.commons.collections.KeyedList; //NOPMD NOSONAR - suppressed UnusedImports - Used for List Prop
import io.nop.core.lang.json.IJsonHandler;
import io.nop.core.model.validator.ValidatorModel;
import io.nop.commons.util.ClassHelper;



// tell cpd to start ignoring code - CPD-OFF
/**
 * generate from /nop/schema/validator.xdef <p>
 * 
 */
@SuppressWarnings({"PMD.UselessOverridingMethod","PMD.UnusedLocalVariable",
    "PMD.UnnecessaryFullyQualifiedName","PMD.EmptyControlStatement","java:S116","java:S101","java:S1128","java:S1161"})
public abstract class _ValidatorModel extends io.nop.core.resource.component.AbstractComponentModel {
    
    /**
     *  
     * xml name: bizFatal
     * 
     */
    private java.lang.Boolean _bizFatal ;
    
    /**
     *  
     * xml name: checkLibPath
     * 在condition段以及check段中可以使用的判断标签
     */
    private String _checkLibPath ;
    
    /**
     *  
     * xml name: check
     * check检查不通过会抛出异常
     */
    private KeyedList<io.nop.core.model.validator.ValidatorCheckModel> _checks = KeyedList.emptyList();
    
    /**
     *  
     * xml name: condition
     * 
     */
    private io.nop.core.lang.xml.XNode _condition ;
    
    /**
     *  
     * xml name: errorCode
     * 
     */
    private java.lang.String _errorCode ;
    
    /**
     *  
     * xml name: errorDescription
     * 
     */
    private java.lang.String _errorDescription ;
    
    /**
     *  
     * xml name: errorParams
     * 
     */
    private java.util.Map<java.lang.String,java.lang.String> _errorParams ;
    
    /**
     *  
     * xml name: errorStatus
     * 
     */
    private java.lang.Integer _errorStatus ;
    
    /**
     *  
     * xml name: fatalSeverity
     * 当exception的severity大于等于fatalSeverity的时候会立刻中断，抛出异常。否则会收集所有异常信息，最后统一抛出
     */
    private int _fatalSeverity  = 0;
    
    /**
     *  
     * xml name: obj
     * 待验证的对象的构造表达式。例如 obj="${entity}"
     */
    private io.nop.core.lang.eval.IEvalAction _obj ;
    
    /**
     *  
     * xml name: severity
     * 值越大严重性越高
     */
    private int _severity  = 0;
    
    /**
     * 
     * xml name: bizFatal
     *  
     */
    
    public java.lang.Boolean getBizFatal(){
      return _bizFatal;
    }

    
    public void setBizFatal(java.lang.Boolean value){
        checkAllowChange();
        
        this._bizFatal = value;
           
    }

    
    /**
     * 
     * xml name: checkLibPath
     *  在condition段以及check段中可以使用的判断标签
     */
    
    public String getCheckLibPath(){
      return _checkLibPath;
    }

    
    public void setCheckLibPath(String value){
        checkAllowChange();
        
        this._checkLibPath = value;
           
    }

    
    /**
     * 
     * xml name: check
     *  check检查不通过会抛出异常
     */
    
    public java.util.List<io.nop.core.model.validator.ValidatorCheckModel> getChecks(){
      return _checks;
    }

    
    public void setChecks(java.util.List<io.nop.core.model.validator.ValidatorCheckModel> value){
        checkAllowChange();
        
        this._checks = KeyedList.fromList(value, io.nop.core.model.validator.ValidatorCheckModel::getId);
           
    }

    
    public io.nop.core.model.validator.ValidatorCheckModel getCheck(String name){
        return this._checks.getByKey(name);
    }

    public boolean hasCheck(String name){
        return this._checks.containsKey(name);
    }

    public void addCheck(io.nop.core.model.validator.ValidatorCheckModel item) {
        checkAllowChange();
        java.util.List<io.nop.core.model.validator.ValidatorCheckModel> list = this.getChecks();
        if (list == null || list.isEmpty()) {
            list = new KeyedList<>(io.nop.core.model.validator.ValidatorCheckModel::getId);
            setChecks(list);
        }
        list.add(item);
    }
    
    public java.util.Set<String> keySet_checks(){
        return this._checks.keySet();
    }

    public boolean hasChecks(){
        return !this._checks.isEmpty();
    }
    
    /**
     * 
     * xml name: condition
     *  
     */
    
    public io.nop.core.lang.xml.XNode getCondition(){
      return _condition;
    }

    
    public void setCondition(io.nop.core.lang.xml.XNode value){
        checkAllowChange();
        
        this._condition = value;
           
    }

    
    /**
     * 
     * xml name: errorCode
     *  
     */
    
    public java.lang.String getErrorCode(){
      return _errorCode;
    }

    
    public void setErrorCode(java.lang.String value){
        checkAllowChange();
        
        this._errorCode = value;
           
    }

    
    /**
     * 
     * xml name: errorDescription
     *  
     */
    
    public java.lang.String getErrorDescription(){
      return _errorDescription;
    }

    
    public void setErrorDescription(java.lang.String value){
        checkAllowChange();
        
        this._errorDescription = value;
           
    }

    
    /**
     * 
     * xml name: errorParams
     *  
     */
    
    public java.util.Map<java.lang.String,java.lang.String> getErrorParams(){
      return _errorParams;
    }

    
    public void setErrorParams(java.util.Map<java.lang.String,java.lang.String> value){
        checkAllowChange();
        
        this._errorParams = value;
           
    }

    
    public boolean hasErrorParams(){
        return this._errorParams != null && !this._errorParams.isEmpty();
    }
    
    /**
     * 
     * xml name: errorStatus
     *  
     */
    
    public java.lang.Integer getErrorStatus(){
      return _errorStatus;
    }

    
    public void setErrorStatus(java.lang.Integer value){
        checkAllowChange();
        
        this._errorStatus = value;
           
    }

    
    /**
     * 
     * xml name: fatalSeverity
     *  当exception的severity大于等于fatalSeverity的时候会立刻中断，抛出异常。否则会收集所有异常信息，最后统一抛出
     */
    
    public int getFatalSeverity(){
      return _fatalSeverity;
    }

    
    public void setFatalSeverity(int value){
        checkAllowChange();
        
        this._fatalSeverity = value;
           
    }

    
    /**
     * 
     * xml name: obj
     *  待验证的对象的构造表达式。例如 obj="${entity}"
     */
    
    public io.nop.core.lang.eval.IEvalAction getObj(){
      return _obj;
    }

    
    public void setObj(io.nop.core.lang.eval.IEvalAction value){
        checkAllowChange();
        
        this._obj = value;
           
    }

    
    /**
     * 
     * xml name: severity
     *  值越大严重性越高
     */
    
    public int getSeverity(){
      return _severity;
    }

    
    public void setSeverity(int value){
        checkAllowChange();
        
        this._severity = value;
           
    }

    

    @Override
    public void freeze(boolean cascade){
        if(frozen()) return;
        super.freeze(cascade);

        if(cascade){ //NOPMD - suppressed EmptyControlStatement - Auto Gen Code
        
           this._checks = io.nop.api.core.util.FreezeHelper.deepFreeze(this._checks);
            
        }
    }

    @Override
    protected void outputJson(IJsonHandler out){
        super.outputJson(out);
        
        out.putNotNull("bizFatal",this.getBizFatal());
        out.putNotNull("checkLibPath",this.getCheckLibPath());
        out.putNotNull("checks",this.getChecks());
        out.putNotNull("condition",this.getCondition());
        out.putNotNull("errorCode",this.getErrorCode());
        out.putNotNull("errorDescription",this.getErrorDescription());
        out.putNotNull("errorParams",this.getErrorParams());
        out.putNotNull("errorStatus",this.getErrorStatus());
        out.putNotNull("fatalSeverity",this.getFatalSeverity());
        out.putNotNull("obj",this.getObj());
        out.putNotNull("severity",this.getSeverity());
    }

    public ValidatorModel cloneInstance(){
        ValidatorModel instance = newInstance();
        this.copyTo(instance);
        return instance;
    }

    protected void copyTo(ValidatorModel instance){
        super.copyTo(instance);
        
        instance.setBizFatal(this.getBizFatal());
        instance.setCheckLibPath(this.getCheckLibPath());
        instance.setChecks(this.getChecks());
        instance.setCondition(this.getCondition());
        instance.setErrorCode(this.getErrorCode());
        instance.setErrorDescription(this.getErrorDescription());
        instance.setErrorParams(this.getErrorParams());
        instance.setErrorStatus(this.getErrorStatus());
        instance.setFatalSeverity(this.getFatalSeverity());
        instance.setObj(this.getObj());
        instance.setSeverity(this.getSeverity());
    }

    protected ValidatorModel newInstance(){
        return (ValidatorModel) ClassHelper.newInstance(getClass());
    }
}
 // resume CPD analysis - CPD-ON
