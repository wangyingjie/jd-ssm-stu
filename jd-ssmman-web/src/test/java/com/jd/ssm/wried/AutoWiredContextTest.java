package com.jd.ssm.wried;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @desc: Desc
 * @author: wangyingjie1
 * @date: 2018/2/26 15:37
 * To change this template use File | Settings | File and Code Templates | Includes | File Header.
 */
public class AutoWiredContextTest {


    @Test
    public void autoPrint() {

        ApplicationContext context = new ClassPathXmlApplicationContext("test/spring-config-example-autowire.xml");
        AutoWiredContext autoWiredContext = context.getBean(AutoWiredContext.class);
        autoWiredContext.autoPrint();
    }

    //Introspector.decapitalize(shortClassName);

    //AnnotationConfigUtils.registerAnnotationConfigProcessors 会注入对 autowire 的注解解析的 BeanProcessor
    //org.springframework.context.annotation.AnnotationConfigUtils.registerAnnotationConfigProcessors(org.springframework.beans.factory.support.BeanDefinitionRegistry, java.lang.Object)
    //AutowiredAnnotationBeanPostProcessor

    //属性的自动注入
    //TypeConverterDelegate.convertIfNecessary(java.lang.String, java.lang.Object, java.lang.Object, java.lang.Class<T>, org.springframework.core.convert.TypeDescriptor)
}
