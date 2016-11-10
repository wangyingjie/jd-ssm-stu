package com.jd.ssm.aop.proxy;


import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * Created by wangyingjie1 on 2016/11/9.
 */
public class WaiterAfterReturningAdvice implements AfterReturningAdvice {

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        Object name = args[0];
        System.out.println("args=========>" + name + "============>" + returnValue);
        System.out.println("Hello " + name);
    }
}
