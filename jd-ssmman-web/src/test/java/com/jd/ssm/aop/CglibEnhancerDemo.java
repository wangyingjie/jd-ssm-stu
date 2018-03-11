package com.jd.ssm.aop;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by wangyingjie1 on 2016/11/13.
 */
public class CglibEnhancerDemo {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(CglibEnhancerDemo.class);
        enhancer.setCallback(new MethodInterceptorImpl());

        CglibEnhancerDemo demo = (CglibEnhancerDemo) enhancer.create();

        demo.test();

        System.out.println(demo);
    }

    public void test() {
        System.out.println("cglib test()");
    }

    private static class MethodInterceptorImpl implements MethodInterceptor {

        @Override
        public Object intercept(Object obj, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

            System.out.println("Before invoke" + method);
            Object resultValue = methodProxy.invokeSuper(obj, objects);
            System.out.println("After invoke" + method);
            return resultValue;
        }
    }


}
