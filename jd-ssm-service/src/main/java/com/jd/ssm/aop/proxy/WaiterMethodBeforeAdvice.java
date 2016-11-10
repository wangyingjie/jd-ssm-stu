package com.jd.ssm.aop.proxy;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by wangyingjie1 on 2016/11/9.
 */
public class WaiterMethodBeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        Object name = args[0];
        System.out.println("args=========>" + name);
        System.out.println("Hello " + name);
    }
}
