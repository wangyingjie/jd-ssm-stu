package com.jd.ssm.placeholder;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

/**
 * Created by wangyingjie1 on 2016/11/1.
 */
public class PlaceHolderTest {

    /**
     * Name of the {@link Environment} bean in the factory.
     */
    String ENVIRONMENT_BEAN_NAME = "environment";

    /**
     * Name of the System properties bean in the factory.
     * @see java.lang.System#getProperties()
     */
    String SYSTEM_PROPERTIES_BEAN_NAME = "systemProperties";

    /**
     * Name of the System environment bean in the factory.
     * @see java.lang.System#getenv()
     */
    String SYSTEM_ENVIRONMENT_BEAN_NAME = "systemEnvironment";



    @Test
    public void testPlaceHolder(){

        ApplicationContext context = new ClassPathXmlApplicationContext("test/spring-config-plcaceholder.xml");
        PlaceHolderService placeHolderService = context.getBean("placeHolderService", PlaceHolderService.class);
        placeHolderService.printValue();
    }
}
