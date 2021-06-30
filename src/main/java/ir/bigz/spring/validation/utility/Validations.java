package ir.bigz.spring.validation.utility;

import java.util.regex.Pattern;

public enum Validations {
    EMAIL;

    private static final Pattern EmailPattern = Pattern.compile("^(?=.{1,64}@)[\\p{L}0-9_-]+(\\.[\\p{L}0-9_-]+)*@" +
            "[^-][\\p{L}0-9-]+(\\.[\\p{L}0-9-]+)*(\\.[\\p{L}]{2,})$");



    public static boolean apply(Validations validation, Object value){

        boolean pass = false;
        switch (validation){
            case EMAIL: pass = validateEmail(value.toString());
            break;
        }

        return pass;
    }

    private static boolean validateEmail(String val){
        return EmailPattern.matcher(val).matches();
    }
}
