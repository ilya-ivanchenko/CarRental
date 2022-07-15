package by.ivanchenko.carrental.dao.impl.connection;

import java.util.ResourceBundle;

public class DBResourseManager {
    private static final String DB= "db";
    private  static  final DBResourseManager instance = new DBResourseManager();

    private ResourceBundle bundle = ResourceBundle.getBundle(DB);

    public  static DBResourseManager getInstance() {
        return instance;
    }

    public String getValue(String key){
        return bundle.getString(key);                                            // извлекаем значение по ключу key
    }
}
