package ir.bigz.spring.validation.utility;

import ir.bigz.spring.validation.annotation.AccountCode;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Service
public class AccountNumberValidator implements ConstraintValidator<AccountCode, String> {

    private final AccountNumberValidation accountNumberValidation;

    public AccountNumberValidator(AccountNumberValidation accountNumberValidation) {
        this.accountNumberValidation = accountNumberValidation;
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return accountNumberValidation.isValid(s);
    }

    @Override
    public void initialize(AccountCode constraintAnnotation) {

    }
}
