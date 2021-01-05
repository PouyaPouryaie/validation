package ir.bigz.spring.validation.utility;

import ir.bigz.spring.validation.annotation.NationalCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Service
public class NationalCodeValidator implements ConstraintValidator<NationalCode, String> {

    private final ValidatorUtils validatorUtils;

    @Autowired
    public NationalCodeValidator(@Qualifier("ValidatorUtilsImpl") ValidatorUtils validatorUtils) {
        this.validatorUtils = validatorUtils;
    }

    @Override
    public boolean isValid(String nationalCode, ConstraintValidatorContext constraintValidatorContext) {
        return validatorUtils.isValidNationalCode(nationalCode);
    }

    @Override
    public void initialize(NationalCode constraintAnnotation) {

    }
}
