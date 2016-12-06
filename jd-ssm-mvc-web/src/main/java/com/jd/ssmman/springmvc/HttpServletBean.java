package com.jd.ssmman.springmvc;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;

/**
 * Created by wangyingjie1 on 2016/11/28.
 */
public class HttpServletBean {

    public void init(){

        // 实现了Servlet的 init 方法，在这个方法内部实例化了  DispatcherServlet 实现，并使用了 spring 的beanWrapper工具类
        System.out.println("com.jd.ssmman.model.HttpServletBean.init===========>" + this);

        BeanWrapper bw = PropertyAccessorFactory.forBeanPropertyAccess(this);

        // 此处已经将 DispatcherServlet 的属性进行了设置
        bw.setPropertyValue("servletName", "dsServlet  xxxxxx");
        bw.setPropertyValue("servletDescribe", "dsServletDescribe  xxxxxx");

        // 留给子类去实现 Spring的 ioc 工厂，该工作有 FrameWorkServlet 负责完成
        initSerBean();
    }

    protected void initSerBean() {

    }
}
