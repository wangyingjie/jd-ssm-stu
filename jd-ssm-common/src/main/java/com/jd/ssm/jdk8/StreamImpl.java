package com.jd.ssm.jdk8;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangyingjie1 on 2017/1/23.
 */
public class StreamImpl {

    public List<String> getList() {
        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");

        return stringCollection;
    }

    public void filter() {
        List<String> stringCollection = getList();

        stringCollection
                .stream()
                .filter((s) -> s.startsWith("a"))
                .forEach(System.out::println);
    }

    public void sort() {
        List<String> stringCollection = getList();

        stringCollection
                .stream()
                .sorted()//排序方法
                .filter((s) -> s.startsWith("a"))
                .forEach(System.out::println);
    }

    public void map() {
        List<String> stringCollection = getList();

        stringCollection
                .stream()
                .map(String::toUpperCase)
                .sorted((a, b) -> b.compareTo(a))
                .forEach(System.out::println);

    }


}
