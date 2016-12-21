package com.jd.ssm.stu;

/**
 * Created by wangyingjie1 on 2016/12/20.
 */
public interface StudentDao {

    int save(Student stu);

    int update(long id);

}
