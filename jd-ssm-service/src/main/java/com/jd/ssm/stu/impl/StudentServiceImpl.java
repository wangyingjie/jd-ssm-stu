package com.jd.ssm.stu.impl;

import com.jd.ssm.stu.Student;
import com.jd.ssm.stu.StudentManager;
import com.jd.ssm.stu.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by wangyingjie1 on 2016/12/20.
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Autowired
    @Qualifier("studentManager")
    private StudentManager studentManager;

    @Override
    public int save(Student stu) {

        System.out.println("studentManager================================>" + studentManager);

        return studentManager.save(stu);
    }
}
