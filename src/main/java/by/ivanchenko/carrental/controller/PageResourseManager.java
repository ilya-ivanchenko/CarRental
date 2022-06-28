package by.ivanchenko.carrental.controller;
import java.util.ResourceBundle;

public class PageResourseManager {
    private static final String PAGE= "page";
    private  static  final PageResourseManager instance = new PageResourseManager();

    private ResourceBundle bundle = ResourceBundle.getBundle(PAGE);   // чтение *.properties,  интернационализация  через этот класс

    public  static PageResourseManager getInstance() {
        return instance;
    }

    public String getValue(String key){
        return bundle.getString(key);                                            // извлекаем значение по ключу key
    }
}
