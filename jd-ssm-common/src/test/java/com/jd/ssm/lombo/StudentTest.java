package com.jd.ssm.lombo;

import com.jd.ssm.lombok.Student;
import org.junit.Test;

/**
 * Created by wangyingjie1 on 2017/1/26.
 */
public class StudentTest {

    @Test
    public void testStudent(){
        Student student = new Student();
        student.setName("xxxxxx");
        student.setSex(111);

        System.out.println(student);

        student.printLog();
    }



}
