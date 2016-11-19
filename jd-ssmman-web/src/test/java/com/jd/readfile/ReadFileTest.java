package com.jd.readfile;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by wangyingjie1 on 2016/10/28.
 *
 * 通过流的形式读取项目 resource 测试
 */
public class ReadFileTest {

    public static void main(String[] args) {
        readPropertiesFile();
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
}
