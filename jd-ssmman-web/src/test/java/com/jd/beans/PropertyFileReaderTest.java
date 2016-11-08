package com.jd.beans;

import org.junit.Test;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

/**
 * 参考文章
 *
 * @link  http://stackoverflow.com/questions/1771166/access-properties-file-programatically-with-spring
 *
 * Created by wangyingjie1 on 2016/11/8.
 */
public class PropertyFileReaderTest {


    @Test
    public void testPropertyFileReader() {
        try {
            Resource resource = new ClassPathResource("/important.properties");
            Properties props = PropertiesLoaderUtils.loadProperties(resource);

            Object msg = props.get("bean.msg");

            System.out.println("msg=========>" + msg);

        } catch (IOException e) {

            System.out.println("======== exception ==========" );
            e.printStackTrace();
        }
    }



    @Test
    public void testPropertiesLoaderUtilsReader() {
        try {
            Properties props = PropertiesLoaderUtils.loadAllProperties("/important.properties");
            PropertyPlaceholderConfigurer props2 = new PropertyPlaceholderConfigurer();
            props2.setProperties(props);

        } catch (IOException e) {

            System.out.println("======== exception ==========" );
            e.printStackTrace();
        }
    }

}
