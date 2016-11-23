package com.jd.ssm.customns;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * Created by wangyingjie1 on 2016/11/22.
 */
public class UserNamespaceHandler extends NamespaceHandlerSupport {


    @Override
    public void init() {
        registerBeanDefinitionParser("user", new UserBeanDefinitionParser());
    }

}
