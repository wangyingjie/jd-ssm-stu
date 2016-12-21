package com.jd.jdbctransaction;

import com.jd.ssm.stu.Student;
import com.jd.ssm.stu.StudentManager;
import com.jd.ssm.user.UserManager;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by wangyingjie1 on 2016/12/20.
 */
public class StudentManagerTest {

    private StudentManager getUserManager() {
        // spring jdbc 事务管理器
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        return context.getBean("studentManager", StudentManager.class);
    }

    //1、测试单事务，无嵌套事务的情况
    @Test
    public void testInitSave() {
        StudentManager studentManager = getUserManager();
        //for (int i = 0; i < 10; i++) {
        studentManager.save(getStudent());
        //}
    }

    private Student getStudent() {
        Student student = new Student();
        student.setAge(10);
        student.setSex("nan");
        student.setStuName("sun yang");
        return student;
    }

}
