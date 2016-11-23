package com.jd.ssm.peoplens;

import com.jd.ssm.namespace.People;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by wangyingjie1 on 2016/11/22.
 */
public class PeopleNamespaceHandlerTest {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config-ns-people.xml");

        People p = (People) ctx.getBean("cutesource");

        System.out.println(p);
    }

}
