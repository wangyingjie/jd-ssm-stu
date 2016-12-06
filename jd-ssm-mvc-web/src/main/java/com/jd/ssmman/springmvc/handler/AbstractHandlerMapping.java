package com.jd.ssmman.springmvc.handler;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ApplicationObjectSupport;

/**
 * Created by wangyingjie1 on 2016/11/30.
 * 实现 ApplicationObjectSupport 可以直接获取到 ApplicationContext 对象
 */
public class AbstractHandlerMapping extends ApplicationObjectSupport {

    public void testApplicationContext(){
        ApplicationContext applicationContext = this.getApplicationContext();

    }

    // 写完方法名和小括号，按 ctrl + shift + enter 会自动补补全
    public void testHandler() {

    }
}
