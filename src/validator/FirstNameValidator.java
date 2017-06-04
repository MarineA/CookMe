package validator;

import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.validator.ValidatorException;

import java.util.regex.Matcher;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;

@FacesValidator(value="validators.firstName")
public class FirstNameValidator implements Validator {

	private Pattern fnPattern;
	private static final String FN_PATTERN = "^[a-zA-Z]{1,25}$";
	private Matcher matcher;
	
	public FirstNameValidator() {
		fnPattern = Pattern.compile(FN_PATTERN);
	}
	
	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {
		matcher=fnPattern.matcher(arg2.toString());
		if(!matcher.matches()){
			FacesMessage msg =	new FacesMessage("User Name Validation failed please follow the contraint"+FN_PATTERN);
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg); }
		
		
	}

}
