package com.jd.rmi;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by wangyingjie1 on 2016/11/21.
 */
public class RmiServerTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("test/spring-config-rmi-hello-server.xml");

    }


    @Test
    public void testRmiServer() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("test/spring-config-rmi-hello-server.xml");
        //AopServiceBean aopService = context.getBean("aopService", AopServiceBean.class);

    }
}
