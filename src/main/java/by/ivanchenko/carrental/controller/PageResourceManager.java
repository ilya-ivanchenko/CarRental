package by.ivanchenko.carrental.controller;
import java.util.ResourceBundle;

public class PageResourceManager {

    private static final String PAGE= "page";
    private static ResourceBundle bundle = ResourceBundle.getBundle(PAGE);

    public static String getValue(String key){
        return bundle.getString(key);                                            // извлекаем значение по ключу key
    }
}
