package com.shejuti.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties prop;

    public static Properties initProperties() {
        prop = new Properties();
        try {
            // Get the environment from system property
            String env = System.getProperty("env", "dev"); // default to dev
            FileInputStream ip = new FileInputStream("src/test/resources/config-" + env + ".properties");
            prop.load(ip);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prop;
    }

    public static String get(String key) {
        if (prop == null) {
            initProperties();
        }
        return prop.getProperty(key);
    }
}
