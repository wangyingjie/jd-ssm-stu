package com.jd.ssm.customns;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;

/**
 * Created by wangyingjie1 on 2016/11/22.
 */
public class UserNamespaceHandler extends NamespaceHandlerSupport implements EntityResolver {


    @Override
    public void init() {
        registerBeanDefinitionParser("user", new UserBeanDefinitionParser());
    }

    @Override
    public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {
        return null;
    }
}
