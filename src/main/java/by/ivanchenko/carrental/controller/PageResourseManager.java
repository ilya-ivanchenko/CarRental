package by.ivanchenko.carrental.controller;
import java.util.ResourceBundle;

public class PageResourseManager {

    private static final String PAGE= "page";
    private static ResourceBundle bundle = ResourceBundle.getBundle(PAGE);   // чтение *.properties,  интернационализация  через этот класс

    public static String getValue(String key){
        return bundle.getString(key);                                            // извлекаем значение по ключу key
    }
}
