package com.jd.ssm.jdk8.factory;

import com.jd.ssm.jdk8.Person;
import com.jd.ssm.jdk8.PersonFactory;
import org.junit.Test;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Created by wangyingjie1 on 2017/1/23.
 */
public class PersonFactoryTest {

    @Test
    public void testCreate() {

        PersonFactory<Person> personFactory = Person::new;

        Person person = personFactory.create("Peter", "Parker");

        System.out.println(person);
    }


    @Test
    public void testCreate2() {

        Supplier<Person> personSupplier = Person::new;

        Person person = personSupplier.get();// new Person

        person.setFirstName("wang");
        person.setLastName("yingjie");
    }

    @Test
    public void testCreate3() {

        //通过 Consumer 接口给对象设置属性
        Consumer<Person> greeter = (p) -> System.out.println("Hello, " + p.firstName);

        greeter.accept(new Person("Luke", "Skywalker"));

    }



}
