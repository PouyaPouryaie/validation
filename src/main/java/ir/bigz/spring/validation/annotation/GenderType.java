package ir.bigz.spring.validation.annotation;

import ir.bigz.spring.validation.utility.GenderTypeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Constraint(validatedBy = GenderTypeValidator.class)
public @interface GenderType {

    String message() default "Invalid Gender";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String[] allowed() default {"man", "woman"};
}
