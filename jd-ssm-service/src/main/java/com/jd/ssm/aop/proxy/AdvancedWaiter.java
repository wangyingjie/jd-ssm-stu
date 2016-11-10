package com.jd.ssm.aop.proxy;

/**
 * Created by wangyingjie1 on 2016/11/9.
 */
public class AdvancedWaiter implements Waiter {

    @Override
    public void greetTo(String name) {
        System.out.println("greet to :" + name);
    }

    @Override
    public String service(String name) {
        System.out.println("service to :" + name);

        return "service is ok";
    }
}
