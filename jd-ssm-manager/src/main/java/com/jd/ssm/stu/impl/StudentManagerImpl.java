package com.jd.ssm.stu.impl;

import com.jd.ssm.stu.Student;
import com.jd.ssm.stu.StudentDao;
import com.jd.ssm.stu.StudentManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by wangyingjie1 on 2016/12/20.
 */
@Service("studentManager")
public class StudentManagerImpl implements StudentManager {

    public StudentManagerImpl() {

        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" );
    }

    @Autowired
    private StudentDao studentDao;

    @Override
    @Transactional
    public int save(Student stu) {
        return studentDao.save(stu);
    }

    @Override
    @Transactional
    public int update(long id) {
        return studentDao.update(id);
    }
}
