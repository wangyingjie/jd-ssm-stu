package com.jd.ssm.jdk8.sort;

import com.jd.ssm.jdk8.Person;
import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * Created by wangyingjie1 on 2017/1/23.
 */
public class CollectionSort {

    @Test
    public void testJDK17() {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });

        System.out.println(names);
    }

    @Test
    public void testJDK18() {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        Collections.sort(names, (String a, String b) -> {
            return b.compareTo(a);
        });

        System.out.println(names);
    }


    @Test
    public void testJDK18_1() {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        Collections.sort(names, (String a, String b) -> b.compareTo(a));

        System.out.println(names);
    }


    @Test
    public void testJDK18_2() {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

        Collections.sort(names, (a, b) -> b.compareTo(a));

        System.out.println(names);
    }

    @Test
    public void testJDK18_Map() {
        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        //循环遍历 Map
        map.forEach((key, value) -> {
            String value1 = map.get(key);
            System.out.println(value1);
        });

    }


    @Test
    public void testJDK18_List() {
        List<String> list = new ArrayList<>();
        list.add("xxxx1");
        list.add("xxxx2");
        list.add("xxxx3");
        list.add("xxxx4");

        list.forEach((element) -> {
            System.out.println(element);
        });
    }

    //Antoine de Saint-Exupéry 的一句名言：完美不是无法再增添加什么，而是无法再去掉什么。
    @Test
    public void testLambda_List() {
        // 集合遍历风格
        final List<String> friends =
                Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");

        friends.forEach(new Consumer<String>() {
            public void accept(final String name) {
                System.out.println(name);
            }
        });

        //lambda 表达式风格
        friends.forEach((final String name) -> System.out.println(name));

        //lambda 表达式风格
        friends.forEach((final String name) -> printlnEle(name));

        //lambda 表达式风格  自动类型推断
        friends.forEach((name) -> printlnEle(name));

        //lambda 表达式风格  单个参数类型可以不需要括号
        friends.forEach(name -> printlnEle(name));

        //lambda 表达式风格  极简版打印
        Consumer<String> action = getPrintln();

        friends.forEach(action);

        friends.forEach(getPrintln());
    }

    private Consumer<String> getPrintln() {
        return System.out::println;
    }

    private void printlnEle(String name) {
        System.out.println(name);
    }

    @Test
    public void testThread() {
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "===========." + "xxxxxxxxxxxxxxxxxx");
        }, "My new Thread ").start();
    }


    @Test
    public void testMap() {
        Map<String, String> statesAndCapitals = statesAndCapitals = new HashMap<>();
        statesAndCapitals.put("Alaska", "Anchorage");
        statesAndCapitals.put("California", "Sacramento");
        statesAndCapitals.put("Colorado", "Denver");
        statesAndCapitals.put("Florida", "Tallahassee");
        statesAndCapitals.put("Nevada", "Las Vegas");
        statesAndCapitals.put("New Mexico", "Sante Fe");
        statesAndCapitals.put("Utah", "Salt Lake City");
        statesAndCapitals.put("Wyoming", "Cheyenne");
        statesAndCapitals.put("New York", "sb");

        // JDK8的实现方法 不存在则取默认值
        final String capitalWisconsin = statesAndCapitals.getOrDefault("Wisconsin", "Unknown");

        // JDK8之前的实现方式
        String capitalMississippi = statesAndCapitals.get("Mississippi");
        if (capitalMississippi == null) {
            capitalMississippi = statesAndCapitals.put("Mississippi", "Jackson");
        }

        // JDK8的实现方式
        final String capitalNewYork = statesAndCapitals.putIfAbsent("New York", "Albany");

        String newYork = statesAndCapitals.get("New York");

        System.out.println(newYork);
    }

    @Test
    public void primaryOccurrence() {

        String[] numbers1 = new String[10];

        String[] numbers = {
                "111", "3333", "44", "44", "44", "77", "2"
        };

        List<String> l = Arrays.asList(numbers);
        Map<Integer, Integer> map = l.stream()
                .map(e -> new Integer(e))//自动映射
                .filter(e -> Primes.isPrime(e))//过滤
                .collect(Collectors.groupingBy(p -> p, Collectors.summingInt(p -> 1)));//分组、统计 mapper/reduce 过程

        System.out.println("primaryOccurrence result is: " + map);
    }


    public void boysAndGirls(List<Person> persons) {
        Map<Integer, Integer> result = persons.parallelStream().filter(p -> p.getAge()>=25 && p.getAge()<=35).
                collect(
                        Collectors.groupingBy(p->p.getSex(), Collectors.summingInt(p->1))
                );
        System.out.print("boysAndGirls result is " + result);

        //Runnable runnable = Person::new;
    }

    @Test
    public void testOptional() {
        Optional<String> optional = Optional.of("bam");

        optional.isPresent();           // true
        String string = optional.get();// "bam"
        String fallback = optional.orElse("fallback");// "bam"

        optional.ifPresent((s) -> System.out.println(s.charAt(0) + "==========" + s));
    }



}
