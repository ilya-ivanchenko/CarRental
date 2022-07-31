package by.ivanchenko.carrental.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public boolean emailValidation(String email) {

        Pattern patternEmail = Pattern.compile("([.[^@\\s]]+)@([.[^@\\s]]+)\\.([a-z]+)");
        Pattern patternAdmin = Pattern.compile("admin");
        Matcher matcherEmail = patternEmail.matcher(email);
        Matcher matcherAdmin = patternAdmin.matcher(email);
        boolean checkEmail = matcherEmail.matches();
        boolean checkAdmin = matcherAdmin.matches();
        if (email == null || email.isEmpty() || !(!checkEmail ^ !checkAdmin)) {
            return false;
        } else {
            return true;
        }
    }

    public boolean phoneValidation(String phone) {
        Pattern pattern = Pattern.compile("(\\+\\d{12})");
        Matcher matcher = pattern.matcher(phone);
        boolean checkPhone = matcher.matches();

        if (phone == null || phone.isEmpty() || !checkPhone) {
            return false;
        } else {
            return true;
        }
    }

    public boolean nameValidation(String name) {
        Pattern pattern = Pattern.compile("\\D+");
        Matcher matcher = pattern.matcher(name);
        boolean checkName = matcher.matches();

        if (name == null || name.isEmpty() || !checkName) {
            return false;
        } else {
            return true;
        }
    }

    public boolean passportValidation(String passport) {
        Pattern pattern = Pattern.compile("([A-Z]{2}\\d{7})");
        Matcher matcher = pattern.matcher(passport);
        boolean checkPassport = matcher.matches();

        if (passport == null || passport.isEmpty() || !checkPassport) {
            return false;
        } else {
            return true;
        }
    }

    public boolean priceValidation(int repairPrice) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(String.valueOf(repairPrice));
        boolean checkPrice = matcher.matches();

        if (!checkPrice) {
            return false;
        } else {
            return true;
        }
    }
}


