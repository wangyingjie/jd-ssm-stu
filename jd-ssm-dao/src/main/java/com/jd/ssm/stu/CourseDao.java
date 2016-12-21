package com.jd.ssm.stu;

/**
 * Created by wangyingjie1 on 2016/12/20.
 */
public interface CourseDao {

    int save(Course course);

    int update(long id);

}
