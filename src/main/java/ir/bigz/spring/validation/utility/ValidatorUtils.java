package ir.bigz.spring.validation.utility;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public interface ValidatorUtils {

    boolean isValidNationalCode(String nationalCode);
}
