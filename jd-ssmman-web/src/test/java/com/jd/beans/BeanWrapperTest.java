package com.jd.beans;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.beans.PropertyValue;

import java.lang.reflect.Modifier;

/**
 * Created by wangyingjie1 on 2016/10/31.
 * <p>
 * Spring BeanWrapperImpl 工具类测试
 */
public class BeanWrapperTest {

    public static void main(String[] args) {

        User user = getUser();

        testBeanWrapper(user);

        testModifier();
    }

    private static void testBeanWrapper(User user) {
        BeanWrapper beanWrapper = PropertyAccessorFactory.forBeanPropertyAccess(user);

        beanWrapper.setPropertyValue("name", "lisi");

        System.out.println("change one user name========>" + user.getName());

        PropertyValue pv = new PropertyValue("name", "wangwu");

        beanWrapper.setPropertyValue(pv);

        System.out.println("change two user name========>" + user.getName());

        System.out.println(beanWrapper.getWrappedInstance() + "=====" + beanWrapper.getWrappedClass());
    }

    private static void testModifier() {
        System.out.println("User is public=======>" + Modifier.isPublic(User.class.getModifiers()));
    }


    private static User getUser() {
        User user = new User();
        user.setId(10000);
        user.setName("zhangsan");
        return user;
    }

}
