package com.jd.ssm.jdk8;

import com.jd.ssm.lombok.Student;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by wangyingjie1 on 2017/2/4.
 */
public class ThreadLocalDemo {

    // java7 以前的版本
    private ThreadLocal<Student> initThreadLocal1 = new ThreadLocal<Student>(){
        @Override
        protected Student initialValue() {
            return new Student();
        }
    };

    // java8 lamdba
    private ThreadLocal<Student> initThreadLocal2 = ThreadLocal.withInitial(() -> new Student());


    public static List<String> allToUpper(List<String> words){
        return words.stream()
                .map(string -> toUpperCase(string))
                .peek(action -> System.out.println(action))//可以单步调试流对象的执行
                .collect(Collectors.toList());
    }

    private static String toUpperCase(String string) {
        return string.toUpperCase();
    }

    //通过方法引用重构之后，测试用例只需要测试 toUpperCase() 方法
    public static List<String> allToUpper2(List<String> words){
        return words.stream()
                .map(ThreadLocalDemo::toUpperCase)
                .collect(Collectors.toList());
    }
}
