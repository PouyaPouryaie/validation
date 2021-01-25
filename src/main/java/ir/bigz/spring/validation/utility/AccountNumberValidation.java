package ir.bigz.spring.validation.utility;

import java.util.function.Predicate;
import java.util.regex.Pattern;

public interface AccountNumberValidation extends Predicate<String> {

    static AccountNumberValidation isAccountNumberValid(String regex){
        Pattern pattern = Pattern.compile(regex);
        return accountNumber -> {
            if(pattern.matcher(accountNumber).matches()){
                return true;
            }else{
                return false;
            }
        };
    }
}
