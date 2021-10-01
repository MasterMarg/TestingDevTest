package ru.mail.sergey_svotin;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfProperties {
    private static FileInputStream fileInputStream;
    private static Properties properties;
    static {
        try {
            fileInputStream = new FileInputStream("src/test/resources/conf.properties");
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null)
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    /**
     * This method allows to get access to saved properties/Метод для получения доступа к сохраненным параметрам
     * @param key is a String containing property's name/Строка, содержащая наименовние свойства
     * @return a String contains property's value/Строка, содержащая значение, хранимое в этом свойстве (String key)
     */
    public static String getProperty(String key){
        return properties.getProperty(key);
    }
}
