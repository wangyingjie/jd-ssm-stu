package com.jd.beans;

import org.junit.Test;
import org.springframework.beans.ConfigurablePropertyAccessor;
import org.springframework.beans.DirectFieldAccessor;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.core.convert.TypeDescriptor;

/**
 * Created by wangyingjie1 on 2016/11/8.
 */
public class DirectFieldAccessorTest {

    // Spring  提供的 DirectFieldAccessor 测试
    @Test
    public void testDirectFieldAccessor() {
        User user = new User();
        user.setId(1111);
        user.setName("wangwu");

        DirectFieldAccessor accessor = new DirectFieldAccessor(user);

        TypeDescriptor id = accessor.getPropertyTypeDescriptor("id");

        System.out.println(id.getName());

        Object idValue = accessor.getPropertyValue("id");
        System.out.println("idValue=========>" +idValue);


    }

    // Spring提供的门面工厂方法测试
    @Test
    public void testPropertyAccessorFactory() {
        User user = new User();
        user.setId(1111);
        user.setName("wangwu");

        ConfigurablePropertyAccessor configurablePropertyAccessor = PropertyAccessorFactory.forDirectFieldAccess(user);

        //DirectFieldAccessor accessor = new DirectFieldAccessor(user);

        TypeDescriptor id = configurablePropertyAccessor.getPropertyTypeDescriptor("id");

        System.out.println(id.getName());

        Object idValue = configurablePropertyAccessor.getPropertyValue("id");
        System.out.println("idValue=========>" +idValue);

    }

}
