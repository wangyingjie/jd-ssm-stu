package com.jd.ssm.dao;

import com.jd.ssm.user.User;
import com.jd.ssm.user.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by wangyingjie1 on 2016/11/14.
 */
public class UserDaoImplTest {

    @Test
    public void testSave() {

        ApplicationContext context = new ClassPathXmlApplicationContext("test/spring-config-datasource-jdbc.xml");

        UserDao userDao = context.getBean("userDao", UserDao.class);
        User user = getUser();

        userDao.save(user);
    }

    private User getUser() {
        User user = new User();
        user.setUserName("zhang san");
        user.setAge(100);
        user.setSex("女");
        return user;
    }

    @Test
    public void testGetAllUsers() {

        ApplicationContext context = new ClassPathXmlApplicationContext("test/spring-config-datasource-jdbc.xml");

        UserDao userDao = context.getBean("userDao", UserDao.class);

        List<User> userList = userDao.getAllUsers();

        System.out.println(userList);
    }

    @Test
    public void testGetByIdUser() {

        ApplicationContext context = new ClassPathXmlApplicationContext("test/spring-config-datasource-jdbc.xml");

        UserDao userDao = context.getBean("userDao", UserDao.class);

        User user = userDao.getByIdUser(2L);

        System.out.println(user);
    }

    @Test
    public void testGetForListUsers() {

        ApplicationContext context = new ClassPathXmlApplicationContext("test/spring-config-datasource-jdbc.xml");

        UserDao userDao = context.getBean("userDao", UserDao.class);

        //根据Spring封装的 queryForList 查询列表对象
        List<Integer> users = userDao.getIDForListSingleColumn("女");

        System.out.println(users);
    }

    @Test
    public void testGetColumn2Map() {

        ApplicationContext context = new ClassPathXmlApplicationContext("test/spring-config-datasource-jdbc.xml");

        UserDao userDao = context.getBean("userDao", UserDao.class);

        //根据Spring封装的 queryForList 查询列值映射map
        List<Map<String, Object>> column2Map = userDao.getColumn2Map();

        System.out.println(column2Map);

        //迭代List
        Iterator<Map<String, Object>> iterator = column2Map.iterator();
        while (iterator.hasNext()) {

            Map<String, Object> next = iterator.next();

            //遍历map
            travelMap(next);

            System.out.println("***************************************************");
        }
    }

    private void travelMap(Map<String, Object> map) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();

            System.out.println(key + "==========" + value);
        }
    }


    @Test
    public void testGetForMap() {

        ApplicationContext context = new ClassPathXmlApplicationContext("test/spring-config-datasource-jdbc.xml");

        UserDao userDao = context.getBean("userDao", UserDao.class);

        //根据Spring封装的 queryForList 查询列值映射map
        Map<String, Object> map = userDao.getForMap();

        //遍历map
        travelMap(map);

    }


}
