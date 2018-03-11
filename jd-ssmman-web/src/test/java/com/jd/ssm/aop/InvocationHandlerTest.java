package com.jd.ssm.aop;

import com.jd.ssm.aop.invocation.SimpleHandlerImpl;
import com.jd.ssm.aop.invocation.SimpleService;
import org.junit.Test;

/**
 * Created by wangyingjie1 on 2016/11/9.
 * <p>
 * 测试 spring aop 功能
 */
public class InvocationHandlerTest {

    // 被代理的方法无返回值
    @Test
    public void testProxySay() {

        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");

        SimpleHandlerImpl simpleHandler = new SimpleHandlerImpl();

        SimpleService simpleService = new SimpleService(simpleHandler);

        simpleService.say();

    }

    //被代理的方法有返回值
    @Test
    public void testProxyRunFast() {

        SimpleHandlerImpl simpleHandler = new SimpleHandlerImpl();

        SimpleService simpleService = new SimpleService(simpleHandler);

        simpleService.runFast();
    }


}
