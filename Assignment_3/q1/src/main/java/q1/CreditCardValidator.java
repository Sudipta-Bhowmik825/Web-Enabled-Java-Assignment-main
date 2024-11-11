package q1;
// CreditCardValidator.java (Custom Validator)
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("creditCardValidator")
public class CreditCardValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String creditCard = value.toString();

        // Basic credit card number validation (length and digits)
        if (creditCard.length() != 19 || !creditCard.matches("\\d{4} \\d{4} \\d{4} \\d{4}")) {
            FacesMessage msg = new FacesMessage("One or more digits of the number are incorrect.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
}
