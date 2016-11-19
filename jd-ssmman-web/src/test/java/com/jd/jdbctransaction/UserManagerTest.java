package com.jd.jdbctransaction;

import com.jd.ssm.user.User;
import com.jd.ssm.user.UserManager;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by wangyingjie1 on 2016/11/15.
 * <p>
 * 测试 spring jdbc 事务管理器的使用方式
 */
public class UserManagerTest {

    private UserManager getUserManager() {
        // spring jdbc 事务管理器
        ApplicationContext context = new ClassPathXmlApplicationContext("test/spring-config-datasource-jdbc-transaction.xml");
        return context.getBean("userManager", UserManager.class);
    }

    private User getUser() {
        User user = new User();
        user.setUserName("张飞-tx");
        user.setAge(50);
        user.setSex("xxx");
        return user;
    }

    //1、测试单事务，无嵌套事务的情况
    @Test
    public void testInitSave() {
        UserManager userManager = getUserManager();
        for (int i = 0; i < 10; i++) {
            userManager.save(getUser());
        }
    }

    //1、测试单事务，无嵌套事务的情况
    @Test
    public void testSave() {
        UserManager userManager = getUserManager();
        userManager.save(getUser());
    }

    //2、测试单嵌套事务测试
    @Test
    public void testSaveNestTx() {
        UserManager userManager = getUserManager();
        userManager.saveNestTx(getUser());
    }

    //3、事务方法嵌套一个无事务的方法,且无事务的方法内部会抛异常，观察事务的回滚情况
    @Test
    public void testSaveNestNoTx() {
        UserManager userManager = getUserManager();
        userManager.saveNestNoTx(getUser());
    }

    //4、测试单无注解的更新方法：该方法会直接通过代理的方式执行，不会走到事务控制里面
    @Test
    public void testUpdate() {
        UserManager userManager = getUserManager();

        // 该方法执行会进入：org.springframework.aop.framework.JdkDynamicAopProxy.invoke()
        // invoke 方法执行的时候会去获取拦截链： Get the interception chain for this method.
        // List<Object> chain = this.advised.getInterceptorsAndDynamicInterceptionAdvice(method, targetClass);
        // 然而通过  userManager.update 方法、类、接口 均未匹配到拦截连，故 chain.size = 0 ;
        // 此时就直接通过代理反射执行了 update 方法，不会进入到 TransactionInterceptor.invoke 的方法里面

        userManager.update(10);
    }

    //5、无事务注解的方法调用一个事务的方法
    @Test
    public void testUpdateNoTxCallTx() {
        UserManager userManager = getUserManager();

        // 最外层的方法无注解属性，即使方法内部调用了带有注解的事务方法；
        // 整体方法也不会执行到  TransactionInterceptor.invoke 的方法里面，即内部方法的事务是不起作用的
        userManager.updateNoTxCallTx(5, getUser());
    }

}
