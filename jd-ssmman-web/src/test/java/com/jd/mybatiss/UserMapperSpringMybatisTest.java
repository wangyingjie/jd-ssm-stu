package com.jd.mybatiss;

import com.jd.ssm.user.User;
import com.jd.ssm.user.mapper.UserMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by wangyingjie1 on 2016/11/15.
 * <p>
 * 测试 spring 整合mybatis之后的编程方式
 */
public class UserMapperSpringMybatisTest {

    @Test
    public void testSave() {

        // spring 整合mybatis省略了通过 SqlSessionFactoryBuilder.build  sqlSessionFactory
        ApplicationContext context = new ClassPathXmlApplicationContext("test/spring-config-datasource-mybatis.xml");
        UserMapper userMapper = context.getBean("userMapper", UserMapper.class);

        userMapper.save(getUser());

    }

    private User getUser() {
        User user = new User();
        user.setUserName("spring-mybatis3");
        user.setAge(100);
        user.setSex("x");
        return user;
    }

    @Test
    public void testGetUserById() {

        ApplicationContext context = new ClassPathXmlApplicationContext("test/spring-config-datasource-mybatis.xml");
        UserMapper userMapper = context.getBean("userMapper", UserMapper.class);
        User user = userMapper.getUserById(4);

        System.out.println(user);
    }

}
