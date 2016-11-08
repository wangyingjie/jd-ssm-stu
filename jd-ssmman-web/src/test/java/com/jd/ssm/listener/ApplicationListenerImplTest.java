package com.jd.ssm.listener;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by wangyingjie1 on 2016/11/1.
 */
public class ApplicationListenerImplTest {

    /**
     * 该测试用例测试的是使用注解 @Value 注入properties 属性，但是发现没起作用
     */
    @Test
    public void testAnnotationSimplePostProcessor(){

        AbstractApplicationContext context = new ClassPathXmlApplicationContext("test/spring-config-listener.xml");
        ApplicationEventImpl event = new ApplicationEventImpl("wangyingjie", "Hello");

        context.publishEvent(event);
    }

}
