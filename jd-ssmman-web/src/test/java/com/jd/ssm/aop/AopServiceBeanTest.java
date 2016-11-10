package com.jd.ssm.aop;

import com.jd.ssm.aop.proxy.AdvancedWaiter;
import com.jd.ssm.aop.proxy.Waiter;
import com.jd.ssm.aop.proxy.WaiterAfterReturningAdvice;
import com.jd.ssm.aop.proxy.WaiterMethodBeforeAdvice;
import com.jd.ssm.aop.test.AopServiceBean;
import com.jd.ssm.aop.user.impl.UserManager;
import org.junit.Test;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by wangyingjie1 on 2016/11/9.
 * <p>
 * 测试 spring aop 功能
 */
public class AopServiceBeanTest {

    /**
     * 测试 AopServiceBean 对应的注解方式实现的Aop
     * @see com.jd.ssm.aop.test.AopServiceBean
     */
    @Test
    public void testAnnotationAopServiceBean() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/test/spring-config-aop-annotation.xml");
        AopServiceBean aopService = context.getBean("aopService", AopServiceBean.class);

        aopService.test();
    }


    /**
     * 测试 UserManagerImpl 对应的Xml方式实现的Aop
     * @see com.jd.ssm.aop.user.impl.UserManagerImpl
     */
    @Test
    public void testXmlUserManager() {
        BeanFactory factory = new ClassPathXmlApplicationContext("/test/spring-config-aop-Xml.xml");
        UserManager userManager = (UserManager) factory.getBean("userManager");

        //可以查找张三
        //userManager.findUserById(1);
        //System.out.println("=====我==是==分==割==线=====");

        try {
            // 查不到数据，会抛异常，异常会被AfterThrowingAdvice捕获
            userManager.findUserById(0);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }



    /**
     * 测试 MethodBeforeAdvice 方法执行前代理
     * @see com.jd.ssm.aop.user.impl.UserManagerImpl
     */
    @Test
    public void testMethodBeforeAdvice() {
        Waiter waiter = new AdvancedWaiter();

        //1、此为切面
        MethodBeforeAdvice advice = new WaiterMethodBeforeAdvice();

        //2、代理工程
        ProxyFactoryBean proxy = new ProxyFactoryBean();

        //3、设置代理 target 对象
        proxy.setTarget(waiter);

        //4、添加切面
        proxy.addAdvice(advice);

        //5、获取到被代理对象
        Waiter proxyWaiter = (Waiter) proxy.getObject();
        proxyWaiter.greetTo("wang wu ");
    }


    /**
     * 测试 MethodBeforeAdvice 方法执行前代理
     * @see com.jd.ssm.aop.user.impl.UserManagerImpl
     */
    @Test
    public void testAfterReturningAdvice() {
        Waiter waiter = new AdvancedWaiter();

        //1、此为切面
        AfterReturningAdvice advice = new WaiterAfterReturningAdvice();

        //2、代理工程
        ProxyFactoryBean proxy = new ProxyFactoryBean();

        //3、设置代理 target 对象
        proxy.setTarget(waiter);

        //4、添加切面
        proxy.addAdvice(advice);

        //5、获取到被代理对象
        Waiter proxyWaiter = (Waiter) proxy.getObject();
        proxyWaiter.greetTo("wang wu ");
    }


}
