/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.ispadmin.models.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author Marki
 */
public class MacAdressValidator implements ConstraintValidator<MacAdress, String> {
    @Override
    public void initialize(MacAdress macAdress) {
    }

    @Override
    public boolean isValid(String macAdressField, ConstraintValidatorContext cxt) {
        if (macAdressField == null) {
            return false;
        }
        boolean n;
        Pattern p = Pattern.compile("^[\\d|a-f|A-F][\\d|a-f|A-F](([:][\\d|a-f|A-F][\\d|a-f|A-F]){5}|([-][\\d|a-f|A-F][\\d|a-f|A-F]){5})$");
        Matcher m = p.matcher(macAdressField);
        n = m.find();

        return n;
    }
}
