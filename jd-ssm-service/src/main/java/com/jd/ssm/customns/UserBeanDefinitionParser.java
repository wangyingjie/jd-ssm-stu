package com.jd.ssm.customns;

import com.jd.ssm.user.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

/**
 * Created by wangyingjie1 on 2016/11/22.
 */
public class UserBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

    /**
     * Determine the bean class corresponding to the supplied {@link Element}.
     * <p>Note that, for application classes, it is generally preferable to
     * override {@link #getBeanClassName} instead, in order to avoid a direct
     * dependence on the bean implementation class. The BeanDefinitionParser
     * and its NamespaceHandler can be used within an IDE plugin then, even
     * if the application classes are not available on the plugin's classpath.
     * @param element the {@code Element} that is being parsed
     * @return the {@link Class} of the bean that is being defined via parsing
     * the supplied {@code Element}, or {@code null} if none
     * @see #getBeanClassName
     */
    protected Class<?> getBeanClass(Element element) {
        return User.class;
    }


    /**
     * Parse the supplied {@link Element} and populate the supplied
     * {@link BeanDefinitionBuilder} as required.
     * <p>The default implementation does nothing.
     *
     * @param element the XML element being parsed
     * @param bean used to define the {@code BeanDefinition}
     */
    protected void doParse(Element element, BeanDefinitionBuilder bean) {

        String id = element.getAttribute("id");
        String userName = element.getAttribute("userName");
        String sex = element.getAttribute("sex");
        String age = element.getAttribute("age");

        if (StringUtils.hasText(id)){
            bean.addPropertyValue("id", id);
        }
        if (StringUtils.hasText(userName)){
            bean.addPropertyValue("userName", userName);
        }
        if (StringUtils.hasText(userName)){
            bean.addPropertyValue("sex", sex);
        }
        if (StringUtils.hasText(userName)){
            bean.addPropertyValue("age", age);
        }
    }
}
