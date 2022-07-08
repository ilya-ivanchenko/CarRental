package by.ivanchenko.carrental.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public boolean emailValidation(String email) {

        Pattern pattern = Pattern.compile("([.[^@\\s]]+)@([.[^@\\s]]+)\\.([a-z]+)" );
        Matcher matcher = pattern.matcher(email);
        boolean checkEmail = matcher.matches();

        if (email == null || email.isEmpty() || !checkEmail) {
            return  false;
        } else {
            return true;
        }
    }

    public boolean phoneValidation(String phone) {
        Pattern pattern = Pattern.compile("(\\+\\d{12})" );
        Matcher matcher = pattern.matcher(phone);
        boolean checkPhone = matcher.matches();

        if (phone == null || phone.isEmpty() || !checkPhone) {
            return  false;
        } else {
            return true;
        }
    }

    public boolean nameValidation(String name) {
        Pattern pattern = Pattern.compile("(\\D+)" );
        Matcher matcher = pattern.matcher(name);
        boolean checkName = matcher.matches();

        if (name == null || name.isEmpty() || !checkName) {
            return  false;
        } else {
            return true;
        }
    }
}


