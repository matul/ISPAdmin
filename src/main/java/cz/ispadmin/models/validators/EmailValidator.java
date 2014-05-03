package cz.ispadmin.models.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Marki
 */
public class EmailValidator implements ConstraintValidator<Email, String> {

  @Override
  public void initialize(Email email) {
  }

  @Override
  public boolean isValid(String emailField, ConstraintValidatorContext cxt) {
    if (emailField == null)
      return true;

    boolean n;
    Pattern p = Pattern.compile("^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$");
    Matcher m = p.matcher(emailField);
    n = m.find();

    return n;
  }

}
