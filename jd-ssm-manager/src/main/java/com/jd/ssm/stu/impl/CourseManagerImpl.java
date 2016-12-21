package com.jd.ssm.stu.impl;

import com.jd.ssm.stu.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by wangyingjie1 on 2016/12/20.
 */
@Service("courseManager")
public class CourseManagerImpl implements CourseManager {

    public CourseManagerImpl() {

        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" );
    }

    @Autowired
    private CourseDao courseDao;

    @Override
    @Transactional
    public int save(Course course) {
        return courseDao.save(course);
    }

    @Override
    @Transactional
    public int update(long id) {
        return courseDao.update(id);
    }
}
