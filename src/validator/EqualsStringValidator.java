package validator;

import com.opensymphony.xwork2.validator.ValidationException;
import com.opensymphony.xwork2.validator.validators.FieldValidatorSupport;

public class EqualsStringValidator extends FieldValidatorSupport {

	String refStringName;

	public EqualsStringValidator() {
		super();
		// TODO Auto-generated constructor stub
		//System.out.println("dans le construc du cust valid");
	}

	public String getRefStringName() {
		return refStringName;
	}

	public void setRefStringName(String refStringName) {
		this.refStringName = refStringName;
	}

	@Override
	public void validate(Object arg0) throws ValidationException {
		// TODO Auto-generated method stub
		System.out.println("titi");
		String refStringValue="";
		if (getRefStringName()!=null){
		refStringValue = (String) getFieldValue(getRefStringName(), arg0);
		}
		String fieldName = getFieldName();
	    Object fieldValue = this.getFieldValue(fieldName, arg0);
	    //System.out.println("toto"+refStringValue+" "+fieldValue);
	    if(!fieldValue.equals(refStringValue)){
	    	 addFieldError(fieldName, arg0);
	    }
	}

}
