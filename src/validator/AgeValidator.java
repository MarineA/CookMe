package validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value="validators.age")
public class AgeValidator implements Validator{

	
	private Matcher matcher;
	private Pattern agePattern;
	private static final String AGE_PATTERN = "^[0-9]{1,2}$";
	
	
	public AgeValidator() {
		agePattern = Pattern.compile(AGE_PATTERN);
	}

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2)
			throws ValidatorException {
		matcher=agePattern.matcher(arg2.toString());
		if(!matcher.matches()){
			FacesMessage msg =	new FacesMessage("Age validation failed please follow the contraint"+AGE_PATTERN);
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg); }
		
	}

}
