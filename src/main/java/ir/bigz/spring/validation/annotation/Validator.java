package ir.bigz.spring.validation.annotation;

import ir.bigz.spring.validation.utility.ValidationValidator;
import ir.bigz.spring.validation.utility.Validations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = {ElementType.FIELD, ElementType.PARAMETER})
@Constraint(validatedBy = ValidationValidator.class)
public @interface Validator {

    String message() default "Invalid validation";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    Validations value();
}
