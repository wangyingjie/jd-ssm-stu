package com.jd.ssm.customns;

import com.jd.ssm.user.User;
import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.beans.factory.parsing.BeanComponentDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
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

        String beanId = element.getAttribute("beanId");
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
        if (StringUtils.hasText(beanId)){
            bean.addPropertyValue("beanId", beanId);
        }
        if (StringUtils.hasText(userName)){
            bean.addPropertyValue("sex", sex);
        }
        if (StringUtils.hasText(userName)){
            bean.addPropertyValue("age", age);
        }
    }


    /**
     * Resolve the ID for the supplied .
     * <p>When using {@link #shouldGenerateId generation}, a name is generated automatically.
     * Otherwise, the ID is extracted from the "id" attribute, potentially with a
     * {@link #shouldGenerateIdAsFallback() fallback} to a generated id.
     * @param element the element that the bean definition has been built from
     * @param definition the bean definition to be registered
     * @param parserContext the object encapsulating the current state of the parsing process;
     * provides access to a {@link org.springframework.beans.factory.support.BeanDefinitionRegistry}
     * @return the resolved id
     * @throws BeanDefinitionStoreException if no unique name could be generated
     * for the given bean definition
     */
    @Override
    protected String resolveId(Element element, AbstractBeanDefinition definition, ParserContext parserContext) throws
            BeanDefinitionStoreException {
        String id = element.getAttribute(ID_ATTRIBUTE);
        if (StringUtils.hasText(id)) {
            return super.resolveId(element, definition, parserContext);
        } else {
            return this.getDefaultId();
        }
    }

    private String getDefaultId() {

        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

        return "userBeanTest";
    }

    /**
     * Hook method called after the primary parsing of a
     * {@link BeanComponentDefinition} but before the
     * {@link BeanComponentDefinition} has been registered with a
     * {@link org.springframework.beans.factory.support.BeanDefinitionRegistry}.
     * <p>Derived classes can override this method to supply any custom logic that
     * is to be executed after all the parsing is finished.
     * <p>The default implementation is a no-op.
     * @param componentDefinition the {@link BeanComponentDefinition} that is to be processed
     *
     *  解析后的后置处理器
     */
    protected void postProcessComponentDefinition(BeanComponentDefinition componentDefinition) {
    }

}
