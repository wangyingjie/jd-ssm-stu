package com.jd.ssm.jdk8;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;

/**
 * Created by wangyingjie1 on 2017/1/23.
 */
public class Person {

    public String firstName;
    public String lastName;
    public int age;
    public Sex sex;

    public Person() {
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        //this.lastName = lastName;
        this.lastName = Preconditions.checkNotNull(lastName, "lastName is null");
    }

    @Override
    public String toString() {

        System.out.println("xxxxx");
        final String first = "first";
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public int compareTo(Person that) {
        return ComparisonChain.start()
                .compare(this.firstName, that.firstName)
                .compare(this.lastName, that.lastName)
                .compare(this.sex, that.sex, Ordering.natural().nullsLast())
                .result();
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return 1;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    enum Sex {
        MALE, FEMALE
    }

    public static void main(String[] args) {
        Person person = new Person();
        boolean isEqual = Objects.equal(person, null);
        System.out.println(isEqual);
    }

}


