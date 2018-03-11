package com.jd.proxy;

import java.lang.reflect.Method;

/**
 * @desc
 * @author: wangyingjie1
 * @date: ${date}
 */
public interface JDInvocationHandler {

    Object invoke(Object proxy, Method method, Object[] args) throws Throwable;

}
