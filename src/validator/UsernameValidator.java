package validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value="validators.username")
public class UsernameValidator implements Validator{

	private Pattern usernamePattern;
	private Matcher matcher;
	private static final String USERNAME_PATTERN = "^[_A-Za-z0-9-@]+" ;
	
	public UsernameValidator() {
		usernamePattern = Pattern.compile(USERNAME_PATTERN);
		
	}

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2)
			throws ValidatorException {
		matcher=usernamePattern.matcher(arg2.toString());
		if(!matcher.matches()){
			FacesMessage msg =	new FacesMessage("User Name Validation failed please follow the contraint"+USERNAME_PATTERN);
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg); }
		
	}
	

}
