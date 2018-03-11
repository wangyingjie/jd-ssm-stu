package com.jd.ssm.aop.invocation;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import static java.lang.reflect.Proxy.newProxyInstance;


/**
 * Created by wangyingjie1 on 2016/11/10.
 */
public class SimpleService {

    private SimpleHandler simpleHandler;
    private SimpleHandler simpleHandlerProxy;

    public SimpleService() {

    }

    public SimpleService(SimpleHandler simpleHandler) {
        this.simpleHandler = simpleHandler;

        // 注意：获取目标对象的接口  通用性更好
        Class<?>[] interfaces = simpleHandler.getClass().getInterfaces();

        //this.simpleHandlerProxy = (SimpleHandler) newProxyInstance(SimpleHandler.class.getClassLoader(), new Class[]{SimpleHandler.class}, new SimpleInvocationHandler());

        //classLoader 的通用获取方式
        //this.simpleHandlerProxy = (SimpleHandler) newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{SimpleHandler.class}, new SimpleInvocationHandler());

        this.simpleHandlerProxy = getProxy(interfaces);

        //generateProxyClazz();
    }

    private void generateProxyClazz() {
        try {
            //通过反编译工具可以查看源代码
            byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{SimpleHandler.class});


            String path = SimpleService.class.getResource("").getPath();
            System.out.println("path================>" + path);

            String fileName = path + "$Proxy0.class";
            FileOutputStream os = new FileOutputStream(fileName);
            os.write(bytes);
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private SimpleHandler getProxy(Class<?>[] interfaces) {
        return (SimpleHandler) newProxyInstance(SimpleHandler.class.getClassLoader(), interfaces, new SimpleInvocationHandler());
    }


    public void say() {
        simpleHandlerProxy.say();
    }

    public void smile() {
        simpleHandlerProxy.smile();
    }

    public boolean runFast() {
        return simpleHandlerProxy.runFast();
    }

    public SimpleHandler getSimpleHandler() {
        return simpleHandler;
    }

    public void setSimpleHandler(SimpleHandler simpleHandler) {
        this.simpleHandler = simpleHandler;
    }

    public SimpleHandler getSimpleHandlerProxy() {
        return simpleHandlerProxy;
    }

    public void setSimpleHandlerProxy(SimpleHandler simpleHandlerProxy) {
        this.simpleHandlerProxy = simpleHandlerProxy;
    }


    // 该类代理的是 SimpleHandler 接口的具体实现类
    private class SimpleInvocationHandler implements InvocationHandler {

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

            // method invoke() 方法介绍
            // 第一个参数代表的是：被代理的对象，
            // 第二个参数表示的是：被代理参数执行时的参数对象
            Object retValue = method.invoke(getSimpleHandler(), args);

            System.out.println("===================>" + retValue);

            return retValue;
        }

    }


}
