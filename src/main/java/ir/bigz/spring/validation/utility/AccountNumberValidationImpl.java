package ir.bigz.spring.validation.utility;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class AccountNumberValidationImpl implements AccountNumberValidation{

    private static final String ACCOUNT_PATTERN = "^\\d{4}-\\d{3}-\\d{6}-\\d$";
    private static final Pattern pattern = Pattern.compile(ACCOUNT_PATTERN);

    @Override
    public boolean isValid(String accountNumber) {
        Matcher matcher = pattern.matcher(accountNumber);
        return matcher.matches();
    }
}
