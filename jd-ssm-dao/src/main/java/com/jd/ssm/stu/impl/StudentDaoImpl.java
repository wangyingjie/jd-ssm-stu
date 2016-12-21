package com.jd.ssm.stu.impl;

import com.jd.ssm.BaseDao;
import com.jd.ssm.stu.Student;
import com.jd.ssm.stu.StudentDao;
import org.springframework.stereotype.Repository;

/**
 * Created by wangyingjie1 on 2016/12/20.
 */
@Repository("studentDao")
public class StudentDaoImpl extends BaseDao implements StudentDao {

    @Override
    public int save(Student stu) {
        return execute("Student.save", stu);
    }

    @Override
    public int update(long id) {
        return execute("Student.update", id);
    }

}
