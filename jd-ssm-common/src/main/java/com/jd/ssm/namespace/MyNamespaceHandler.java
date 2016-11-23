package com.jd.ssm.namespace;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * Created by wangyingjie1 on 2016/11/22.
 */
public class MyNamespaceHandler extends NamespaceHandlerSupport {

    @Override
    public void init() {
        registerBeanDefinitionParser("people", new PeopleBeanDefinitionParser());
    }
}
