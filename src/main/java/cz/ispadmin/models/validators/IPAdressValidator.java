package cz.ispadmin.models.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author Marki
 */
public class IPAdressValidator implements ConstraintValidator<IPAdress, String> {

  @Override
  public void initialize(IPAdress ipAdress) {
  }

  @Override
  public boolean isValid(String ipAdressField, ConstraintValidatorContext cxt) {
    if (ipAdressField == null)
      return true;
    
    boolean n;
    Pattern p = Pattern.compile("(\\d{1,3}\\.){3}\\d{1,3}");
    Matcher m = p.matcher(ipAdressField);
    n = m.find();

    return n;
  }

}
