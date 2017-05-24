package validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value="validators.login")
public class LoginValidator implements Validator{
	
	private Pattern loginPattern;
	private static final String LOGIN_PATTERN = "[a-zA-Z0-9-._]";
	private Matcher matcher;
	
	public LoginValidator() {
		loginPattern = Pattern.compile(LOGIN_PATTERN);
	}

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2)
			throws ValidatorException {
		matcher=loginPattern.matcher(arg2.toString());
		if(!matcher.matches()){
			FacesMessage msg =	new FacesMessage("User Name Validation failed please follow the contraint"+LOGIN_PATTERN);
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg); }
		
	}

}
