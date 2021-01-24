package ir.bigz.spring.validation.utility;

import org.springframework.stereotype.Service;

@Service
public interface AccountNumberValidation {

    boolean isValid(String accountNumber);
}
