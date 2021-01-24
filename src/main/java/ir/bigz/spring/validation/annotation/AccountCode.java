package ir.bigz.spring.validation.annotation;

import ir.bigz.spring.validation.utility.AccountNumberValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Constraint(validatedBy = AccountNumberValidator.class)
public @interface AccountCode {

    String message() default "account-number is not valid";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
