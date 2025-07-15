package com.shejuti.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties prop;

    public static Properties initProperties() {
        prop = new Properties();
        try {
            // Get the environment from system property env
            String env = System.getProperty("env", "dev"); // default to dev
            FileInputStream ip = new FileInputStream("src/test/resources/config-" + env + ".properties"); // Loads the appropriate .properties file based on the environment
            prop.load(ip); // Loads key-value pairs (e.g., baseUrl=http://localhost:3000) into a Properties object
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
