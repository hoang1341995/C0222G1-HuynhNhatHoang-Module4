package example.service;

import java.util.regex.Pattern;

public class ValidateEmail {
    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";

    public static boolean validateEmail(String email){
        return Pattern.matches(EMAIL_REGEX,email);
    }
}
