package validator;

import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.validator.ValidatorException;

import java.util.regex.Matcher;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;

@FacesValidator(value="validators.email")
public class EmailValidator implements Validator{

	private Pattern emailPattern;
	private Matcher matcher;
	private static final String EMAIL_PATTERN = "^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)+$"; 
	
	public EmailValidator() {
		emailPattern = Pattern.compile(EMAIL_PATTERN);
	}
	
	



	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2)
			throws ValidatorException {
		matcher=emailPattern.matcher(arg2.toString());
		if(!matcher.matches()){
			FacesMessage msg =	new FacesMessage("Email validation failed please follow the contraint"+EMAIL_PATTERN);
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg); }
		
	}

}
