package com.personal.saucedemo.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {
    static Properties properties;
    static {

        properties = new Properties();
        FileInputStream fis;

        {
            try {
                System.out.println(new java.io.File(".").getCanonicalPath());
                fis = new FileInputStream("./src/main/resources/configurations.properties");
                properties.load(fis);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

}
