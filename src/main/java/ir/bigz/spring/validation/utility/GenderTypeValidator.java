package ir.bigz.spring.validation.utility;

import ir.bigz.spring.validation.annotation.GenderType;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class GenderTypeValidator implements ConstraintValidator<GenderType, String> {

    List<String> allowed;

    @Override
    public void initialize(GenderType constraintAnnotation) {
        allowed = Arrays.asList(constraintAnnotation.allowed());
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        if(!allowed.contains(s.toLowerCase())){
            String error = "GenderType must be one of the following: " + allowed;
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(error).addConstraintViolation();
            return false;
        }
        return true;
    }
}
