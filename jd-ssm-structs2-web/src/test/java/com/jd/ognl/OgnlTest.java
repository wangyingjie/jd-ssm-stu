package com.jd.ognl;

import com.jd.ssm.user.User;
import ognl.Ognl;
import ognl.OgnlException;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangyingjie1 on 2016/12/14.
 * <p>
 * Ognl 表达式引擎测试
 *
 * Ognl  Java 对象与 Web 展示数据的流转翻译器
 *
 * Ognl 三要素：表达式、Root对象、上下文环境
 */
public class OgnlTest {


    @Test
    public void testGetValue() throws Exception {
        User user = getUser();

        Map<String, Object> context = new HashMap<>();
        context.put("beanId", "userbeanId");

        // 通过Ognl表达式获取root对象上的属性值
        Object userName = Ognl.getValue(Ognl.parseExpression("userName"), user);
        System.out.println("userName=======>" + userName);

        Object contextValue = Ognl.getValue(Ognl.parseExpression("#beanId"), context, user);
        System.out.println("contextValue=======>" + contextValue + "=======" + user.getBeanId());

        // 表达式的计算
        Object ctv = Ognl.getValue(Ognl.parseExpression("#beanId + userName"), context, user);
        System.out.println("ctv=============>" + ctv);
    }

    private User getUser() {
        //创建root 对象
        User user = new User();
        user.setId(111);
        user.setUserName("zhangsan");
        return user;
    }

    @Test
    public void testSetValue() throws OgnlException {
        User user = getUser();

        // 给user对象能设置值，不仅是简单类型，可以支持对象类型
        //Ognl.setValue("group.name", user, "大生活研发组");
        Ognl.setValue("age", user, 200);
        Ognl.setValue("sex", user, "男女男");

        System.out.println("user===========>" + user);
    }

}
