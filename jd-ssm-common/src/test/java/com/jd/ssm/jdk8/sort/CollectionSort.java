package com.jd.ssm.jdk8.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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


}
