package com.jd.ssm.readfile;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by wangyingjie1 on 2016/10/28.
 *
 * 通过流的形式读取项目 resource 测试
 */
public class ReadFileTest1 {

    public static void main(String[] args) {

        //readPropertiesFile();

        readPropertiesFileBySpring();
    }

    private static void readPropertiesFile() {
        try {
            Properties properties = new Properties();
            properties.load(ReadFileTest1.class.getClassLoader().getResourceAsStream("velocity.properties"));

            System.out.println(properties);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void readPropertiesFileBySpring() {
        try {

            //todo  此处使用了spring的api，但是未读取到数据，该问题有待查找根本原因
            ClassPathResource resource = new ClassPathResource("file1.properties");
            Properties properties1 = PropertiesLoaderUtils.loadProperties(resource);
            System.out.println(properties1);


            Properties properties = PropertiesLoaderUtils.loadAllProperties("file.properties");
            System.out.println(properties);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void readPropertiesFileBySpring1() {
        try {

            //todo  此处使用了spring的api，但是未读取到数据，该问题有待查找根本原因
            ClassPathResource resource = new ClassPathResource("file1.properties", ReadFileTest1.class);
            Properties properties1 = PropertiesLoaderUtils.loadProperties(resource);
            System.out.println(properties1);

            Properties properties = PropertiesLoaderUtils.loadAllProperties("file.properties");
            System.out.println(properties);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
