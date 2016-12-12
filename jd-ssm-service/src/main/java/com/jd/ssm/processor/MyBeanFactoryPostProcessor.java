package com.jd.ssm.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionVisitor;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringValueResolver;

/**
 * Created by wangyingjie1 on 2016/11/7.
 * <p>
 * 自定义 BeanFactoryPostProcessor
 */
@Service("myBeanFactoryPostProcsssor")
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {


    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        //获取所有的定义的BeanNames
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();

        for (String beanName : beanDefinitionNames) {

            // All beanDefinition
            BeanDefinition bd = beanFactory.getBeanDefinition(beanName);

            //占位符解析器
            StringValueResolver valueResolver = new StringValueResolver() {
                @Override
                public String resolveStringValue(String strVal) {

                    //System.out.println("strVal======================>" + strVal);

                    if (strVal.contains("shit")) {

                        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

                        return "shit*****";
                    }
                    return strVal;
                }
            };

            BeanDefinitionVisitor visitor = new BeanDefinitionVisitor(valueResolver);

            visitor.visitBeanDefinition(bd);

        }

        System.out.println("over ^^^^^^^^^^^^^^^^^^^^");

    }


}
