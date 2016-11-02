package com.jd.ssm.example;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by wangyingjie1 on 2016/11/1.
 */
public class CycleDependency {


    @Test
    public void testCycleDI(){

        ApplicationContext context = new ClassPathXmlApplicationContext("test/spring-config-example.xml");
        CycleService1 cycleService1 = context.getBean("cycleService1", CycleService1.class);
        cycleService1.method1();
    }
}
