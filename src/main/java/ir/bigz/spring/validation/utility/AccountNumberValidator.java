package ir.bigz.spring.validation.utility;

import ir.bigz.spring.validation.annotation.AccountCode;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Service
public class AccountNumberValidator implements ConstraintValidator<AccountCode, String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        return (s.getBytes().length == 16) ?
                AccountNumberValidation.isAccountNumberValid("^\\d{4}-\\d{2}-\\d{6}-\\d$").test(s) :
                (s.getBytes().length == 17 && AccountNumberValidation.isAccountNumberValid("^\\d{4}-\\d{3}-\\d{6}-\\d$")
                .test(s));

    }

    @Override
    public void initialize(AccountCode constraintAnnotation) {

    }
}
