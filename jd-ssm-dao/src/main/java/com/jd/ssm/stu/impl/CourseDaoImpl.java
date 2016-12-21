package com.jd.ssm.stu.impl;

import com.jd.ssm.BaseDao;
import com.jd.ssm.stu.Course;
import com.jd.ssm.stu.CourseDao;
import org.springframework.stereotype.Repository;

/**
 * Created by wangyingjie1 on 2016/12/20.
 */
@Repository("courseDao")
public class CourseDaoImpl extends BaseDao implements CourseDao {

    @Override
    public int save(Course Course) {
        return execute("Course.save", Course);
    }

    @Override
    public int update(long id) {
        return execute("Course.update", id);
    }

}
