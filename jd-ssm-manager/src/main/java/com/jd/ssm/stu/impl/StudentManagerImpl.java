package com.jd.ssm.stu.impl;

import com.jd.ssm.stu.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by wangyingjie1 on 2016/12/20.
 */
@Service("studentManager")
public class StudentManagerImpl implements StudentManager {

    public StudentManagerImpl() {

        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
    }

    @Autowired
    private StudentDao studentDao;

    // 测试 Manager 调用 Manager 事务嵌套事务的情况
    @Autowired
    @Qualifier("courseManager")
    private CourseManager courseManager;

    @Override
    @Transactional
    public int save(Student stu) {
        return studentDao.save(stu);
    }

    @Override
    @Transactional
    public int saveStuAndCourse(Student stu, Course course) {

        int cnt1 = save(stu);

        int cnt2 = courseManager.save(course);

        return cnt1 + cnt2;
    }

    @Override
    @Transactional
    public int update(long id) {
        return studentDao.update(id);
    }
}
