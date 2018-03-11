package com.jd.proxy;

import java.lang.reflect.Method;

/**
 * @desc
 * @author: wangyingjie1
 * @date: ${date}
 */
public class JDAgent implements JDInvocationHandler {

    private Communication target;

    // public JDAgent(Communication target) {
    //     this.target = target;
    // }

    public Object getInstance(Communication target) throws Exception {
        this.target = target;

        Class<?> clazz = target.getClass();

        //下半截，老师深入底层来给大家讲解字节码是如何重组的
        //用来生成一个新的对象（字节码重组来实现）
        return JDProxy.newProxyInstance(new JDClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("agent start===============");

        Object invoke = method.invoke(target, args);

        System.out.println("agent end  ===============");

        return invoke;
    }
}
