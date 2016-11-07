package com.jd.ssm.processor;

import org.junit.Test;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by wangyingjie1 on 2016/11/1.
 */
public class SimplePostProcessorTest {


    @Test
    public void testSimplePostProcessor(){

        ApplicationContext context = new ClassPathXmlApplicationContext("test/spring-config-myprocessor.xml");
        MyBeanFactoryPostProcessor beanFactoryPostProcessor = context.getBean("myBeanFactoryPostProcessor", MyBeanFactoryPostProcessor.class);

        beanFactoryPostProcessor.postProcessBeanFactory((ConfigurableListableBeanFactory) context.getAutowireCapableBeanFactory());

        Object simplePostProcessor = context.getBean("simplePostProcessor");

        System.out.println(simplePostProcessor);

    }

    @Test
    public void testPostProcessor(){
        ConfigurableListableBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("test/spring-config-myprocessor.xml")
        );
        BeanFactoryPostProcessor myBfpp = (BeanFactoryPostProcessor)beanFactory.getBean("myBeanFactoryPostProcessor");
        myBfpp.postProcessBeanFactory(beanFactory);
        System.out.println(beanFactory.getBean("simplePostProcessor"));
    }

}
