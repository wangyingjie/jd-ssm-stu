package com.jd.ssm.jdk8;

/**
 * Created by wangyingjie1 on 2017/1/23.
 */
// 构造函数引用工厂
public interface PersonFactory<P extends Person> {

    P create(String firstName, String lastName);
}

//class Person {
//
//    String firstName;
//    String lastName;
//
//    Person() {
//    }
//
//    Person(String firstName, String lastName) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//    }
//
//    @Override
//    public String toString() {
//        return "Person{" +
//                "firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                '}';
//    }
//}