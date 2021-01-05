package ir.bigz.spring.validation.annotation;

import ir.bigz.spring.validation.utility.NationalCodeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NationalCodeValidator.class)
public @interface NationalCode {

    String message() default "nationalCode is invalid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
