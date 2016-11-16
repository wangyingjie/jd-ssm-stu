package com.jd.jdbctransaction;

import com.jd.ssm.user.User;
import com.jd.ssm.user.UserManager;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by wangyingjie1 on 2016/11/15.
 * <p>
 * 测试 spring jdbc 事务管理器的使用方式
 */
public class UserManagerTest {

    @Test
    public void testSave() {

        // spring jdbc 事务管理器
        ApplicationContext context = new ClassPathXmlApplicationContext("test/spring-config-datasource-jdbc-transaction.xml");
        UserManager userManager = context.getBean("userManager", UserManager.class);

        userManager.save(getUser());
    }

    private User getUser() {
        User user = new User();
        user.setUserName("spring-jdbc-tx");
        user.setAge(100);
        user.setSex("x");
        return user;
    }

}
