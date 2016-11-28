package com.jd.ssmman.springmvc;

/**
 * Created by wangyingjie1 on 2016/11/28.
 */
public class FrameWorkServlet extends HttpServletBean {

    @Override
    protected void initSerBean() {

        //初始化Spring的IOC bean 工厂
        //this.webApplicationContext = initWebApplicationContext();
        System.out.println("create 创建 Spring WebApplicationContext wac");
        System.out.println("初始化  wac.refresh() Spring Ioc 工厂得以初始化");

        //初始化 Spring mvc 的 9 大组件
        onRefresh("applicationContext");


        //留给子类扩展的方法
        //initFrameworkServlet();
    }

    protected void onRefresh(String applicationContext) {
    }
}
