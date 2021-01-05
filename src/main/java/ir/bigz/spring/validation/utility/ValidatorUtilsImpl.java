package ir.bigz.spring.validation.utility;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component("ValidatorUtilsImpl")
public class ValidatorUtilsImpl implements ValidatorUtils{

    @Override
    public boolean isValidNationalCode(String nationalCode) {
        boolean isValid = false;
        if (nationalCode != null && nationalCode.length() == 10) {
            if (StringUtils.isNumeric(nationalCode)) {
                AtomicInteger index = new AtomicInteger();
                int controllerConditionNumber = nationalCode.substring(0, 9).chars()
                        .map(i -> Integer.valueOf(Character.toString((char) i)) * (10 - index.getAndIncrement())).sum() % 11;
                int controllerNumber = Integer.valueOf(nationalCode.substring(9));
                isValid = (controllerConditionNumber < 2) ?
                        controllerConditionNumber == controllerNumber :
                        controllerNumber == (11 - controllerConditionNumber);
            }
        }
        return isValid;
    }
}
