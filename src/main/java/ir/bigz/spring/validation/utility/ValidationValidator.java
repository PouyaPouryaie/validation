package ir.bigz.spring.validation.utility;

import ir.bigz.spring.validation.annotation.Validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidationValidator implements ConstraintValidator<Validator, String> {

    Validations validationsType;

    @Override
    public void initialize(Validator constraintAnnotation) {
        validationsType = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        if(!Validations.apply(validationsType, s)){
            String error = String.format("%s validation fail", validationsType.name());
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(error).addConstraintViolation();
            return false;
        }
        return true;
    }
}
