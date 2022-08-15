package by.ivanchenko.carrental.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    private static final String ELECTRO = "Электро";
    public boolean emailValidation(String email) {

        Pattern patternEmail = Pattern.compile("([.[^@\\s]]+)@([.[^@\\s]]+)\\.([a-z]+)");
        Pattern patternAdmin = Pattern.compile("admin");
        Matcher matcherEmail = patternEmail.matcher(email);
        Matcher matcherAdmin = patternAdmin.matcher(email);
        boolean checkEmail = matcherEmail.matches();
        boolean checkAdmin = matcherAdmin.matches();
        return email != null && !email.isEmpty() && !checkEmail ^ !checkAdmin;
    }

    public boolean phoneValidation(String phone) {
        Pattern pattern = Pattern.compile("(\\+\\d{12})");
        Matcher matcher = pattern.matcher(phone);
        boolean checkPhone = matcher.matches();

        return phone != null && !phone.isEmpty() && checkPhone;
    }

    public boolean nameValidation(String name) {
        Pattern pattern = Pattern.compile("\\D+");
        Matcher matcher = pattern.matcher(name);
        boolean checkName = matcher.matches();

        return name != null && !name.isEmpty() && checkName;
    }

    public boolean passportValidation(String passport) {
        Pattern pattern = Pattern.compile("([A-Za-z]{2}\\d{7})");
        Matcher matcher = pattern.matcher(passport);
        boolean checkPassport = matcher.matches();

        return passport != null && !passport.isEmpty() && checkPassport;
    }

    public boolean priceValidation(int price) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(String.valueOf(price));
        boolean checkPrice = matcher.matches();
        return checkPrice;
    }

    public boolean electroCar(String fuel) {
        return fuel.equals(ELECTRO);
    }

    public boolean consumptionValidation(double consumption) {
        Pattern pattern = Pattern.compile("\\d+\\.\\d");
        Matcher matcher = pattern.matcher(String.valueOf(consumption));
        boolean checkConsumption = matcher.matches();
        return checkConsumption;
    }
}


