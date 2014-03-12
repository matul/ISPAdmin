package cz.ispadmin.models.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author Marki
 */
public class PhoneValidator implements ConstraintValidator<Phone, String> {

    @Override
    public void initialize(Phone phone) {
    }

    @Override
    public boolean isValid(String phoneField, ConstraintValidatorContext cxt) {
        if (phoneField == null) {
            return false;
        }
        boolean n;
        n = phoneField.matches("^(\\+420|\\+421) ?[0-9]{3} ?[0-9]{3} ?[0-9]{3}$");
        return n;
    }
}
