package com.jd.ssm.processor;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by wangyingjie1 on 2016/11/1.
 */
public class SimplePostProcessorTest {

    /**
     * 该测试用例测试的是使用注解 @Value 注入properties 属性，但是发现没起作用
     */
    @Test
    public void testAnnotationSimplePostProcessor(){

        AbstractApplicationContext context = new ClassPathXmlApplicationContext("test/spring-config-myprocessor.xml");
        MyBeanFactoryPostProcessor beanFactoryPostProcessor = context.getBean("myBeanFactoryPostProcsssor", MyBeanFactoryPostProcessor.class);

        beanFactoryPostProcessor.postProcessBeanFactory(context.getBeanFactory());

        SimplePostProcessor simplePostProcessor = context.getBean("simplePostProcessor", SimplePostProcessor.class);

        System.out.println(simplePostProcessor);

    }

    /**
     * 该测试用例测试的是使用 xml 配置，依赖set注入 properties 属性，测试用例ok
     */
    @Test
    public void testXmlConfigPostProcessor(){

        AbstractApplicationContext context = new ClassPathXmlApplicationContext("test/spring-config-myprocessor.xml");
        MyBeanFactoryPostProcessor beanFactoryPostProcessor = context.getBean("myBeanFactoryPostProcsssor", MyBeanFactoryPostProcessor.class);

        beanFactoryPostProcessor.postProcessBeanFactory(context.getBeanFactory());

        SimplePostProcessor simplePostProcessor = context.getBean("simplePostProcessor2", SimplePostProcessor.class);

        System.out.println(simplePostProcessor);

    }

}
