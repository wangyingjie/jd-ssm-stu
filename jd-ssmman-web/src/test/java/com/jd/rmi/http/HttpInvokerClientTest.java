package com.jd.rmi.http;

import com.jd.ssm.rmi.HelloRmiService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by wangyingjie1 on 2016/11/21.
 */
public class HttpInvokerClientTest {

    @Test
    public void testRmiClient() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("test/spring-config-rmi-httpinvoker-client.xml");
        HelloRmiService helloRmi = context.getBean("helloRmiServiceClient", HelloRmiService.class);
        int add = helloRmi.getAdd(10, 20);

        System.out.println("add=================>" + add);
    }
}
