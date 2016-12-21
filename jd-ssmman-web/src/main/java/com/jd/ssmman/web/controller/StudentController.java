package com.jd.ssmman.web.controller;


import com.jd.ssm.stu.Course;
import com.jd.ssm.stu.Student;
import com.jd.ssm.stu.StudentManager;
import com.jd.ssm.stu.StudentService;
import com.jd.ssm.user.User;
import com.jd.ssm.user.UserManager;
import com.jd.ssmman.web.base.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created with IntelliJ IDEA.
 * User: ckm
 * Date: 15-10-29
 * Time: 下午10:29
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/student")
public class StudentController extends BaseController {

    @Autowired
    @Qualifier("studentManager")
    private StudentManager studentManager;

    @Autowired
    @Qualifier("studentService")
    private StudentService studentService;



    @RequestMapping("/save")
    public String save() {

        Student student = getStudent();

        //studentManager.save(student);

        studentService.save(student);

        return "index";
    }


    @RequestMapping("/saveStuAndCourse")
    public String saveStuAndCourse() {

        Student student = getStudent();

        Course course = getCourse();

        studentService.saveStuAndCourse(student, course);

        return "index";
    }

    private Course getCourse() {
        Course course = new Course();
        course.setCourseName("野史");
        course.setTeacher("易中天");
        return course;
    }

    private Student getStudent() {
        Student student = new Student();
        student.setId(ThreadLocalRandom.current().nextInt(100000000));
        student.setAge(10);
        student.setSex("nan");
        student.setStuName("sun yang");
        return student;
    }


}
