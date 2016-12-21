package com.jd.ssm.stu;

/**
 * Created by wangyingjie1 on 2016/12/20.
 */
public interface StudentManager {

    int save(Student stu);

    int saveStuAndCourse(Student stu, Course course);

    int update(long id);
}
