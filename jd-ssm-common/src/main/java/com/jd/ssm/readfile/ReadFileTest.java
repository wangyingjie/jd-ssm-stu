package com.jd.readfile;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by wangyingjie1 on 2016/10/28.
 *
 * 通过流的形式读取项目 resource 测试
 */
public class ReadFileTest {

    public static void main(String[] args) {

        //readPropertiesFile();

        readPropertiesFileBySpring();
    }

    private static void readPropertiesFile() {
        try {
            Properties properties = new Properties();
            properties.load(ReadFileTest.class.getClassLoader().getResourceAsStream("velocity.properties"));

            System.out.println(properties);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void readPropertiesFileBySpring() {
        try {
            ClassPathResource resource = new ClassPathResource("file.properties", ReadFileTest.class);

            Properties properties = PropertiesLoaderUtils.loadProperties(resource);
            System.out.println(properties);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
