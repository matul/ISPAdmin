/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.ispadmin.models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author Marki
 */
public class BirthValidator implements ConstraintValidator<Birth, String> {

    @Override
    public void initialize(Birth birth) {
    }

    @Override
    public boolean isValid(String birthField, ConstraintValidatorContext cxt) {
        if (birthField == null) {
            return false;
        }
        boolean n;
        Pattern p = Pattern.compile("^([1-9]|19|[12][0-8]|29(?=\\.([^2]|2\\.(([02468][048]|[13579][26])00|[0-9]{2}(0[48]|[2468][048]|[13579][26]))))|30(?=\\.[^2])|31(?=\\.([13578][02]?\\.)))\\.([1-9]|1[012])\\.[0-9]{4}$");
        Matcher m = p.matcher(birthField);
        n = m.find();

        return n;
    }

}
