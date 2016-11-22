package com.jd.customns;

import com.jd.ssm.user.User;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by wangyingjie1 on 2016/11/22.
 */
public class UserNamespaceTest {

    /**
     * 测试 spring 自定义标签的解析
     *
     * @see User
     */
    @Test
    public void testUserNamespace() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("customns/spring-config-customns.xml");
        User userBeanTest = context.getBean("userBeanTest", User.class);
        System.out.println("userBeanTest=============>" + userBeanTest);
    }


}
