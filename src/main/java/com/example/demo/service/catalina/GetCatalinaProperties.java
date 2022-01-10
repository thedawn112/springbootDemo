package com.example.demo.service.catalina;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Enumeration;
import java.util.Properties;

/**
 * @author ranran.mao
 * @date 2021/11/9 1:16
 */
public class GetCatalinaProperties {
    private static final Logger log = LoggerFactory.getLogger(GetCatalinaProperties.class);
    public static Properties properties = null;

    static {
        loadProperties();
    }

    private static void loadProperties() {
        File file = new File("src/main/resources/catalina.properties");
        InputStream inputStream = null;
        properties = new Properties();
        try {
            inputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Enumeration<?> enumeration = properties.propertyNames();
        while (enumeration.hasMoreElements()) {
            String name = (String) enumeration.nextElement();
            String value = properties.getProperty(name);
            if (value != null) {
                System.setProperty(name, value);
            }
        }
    }

    public static String getProperties(String name) {
        return properties.getProperty(name);
    }

    public static String replace(String str) {
        int pos_start = str.indexOf("${");
        if (pos_start >= 0) {
            StringBuilder builder = new StringBuilder();
            int pos_end = -1;
            while (pos_start >= 0) {
                builder.append(str, pos_end + 1, pos_start);
            }
        }
        return str;
    }

    public static void main(String[] args) {
        String properties1 = GetCatalinaProperties.getProperties("common.loader");
        System.out.println(properties1);
        StringBuilder builder = new StringBuilder();
        StringBuilder append = builder.append(properties1, 0, 1);
        System.out.println(append.toString());
        int i = properties1.indexOf("}", 3);
        System.out.println(i);
        //System.out.println(GetCatalinaProperties.replace(properties1));
    }
}
