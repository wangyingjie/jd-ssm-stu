package com.jd.beans;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by wangyingjie1 on 2016/11/2.
 */
public class MethodTest {

    public static void main(String[] args) {

        User user = new User();
        Method[] methods = user.getClass().getDeclaredMethods();

        for (Method md : methods) {
            if (md.getName().equals("sayHello")){

                exeMethod(user, md);

            }
        }
    }

    private static void exeMethod(User user, Method md) {
        try {
            md.invoke(user, "zhangsan");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
