package com.jd.ssm.stu;

/**
 * Created by wangyingjie1 on 2016/12/20.
 */
public interface StudentService {

    int save(Student stu);

    int saveStuAndCourse(Student stu, Course course);

}
