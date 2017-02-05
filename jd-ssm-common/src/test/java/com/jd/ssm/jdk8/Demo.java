package com.jd.ssm.jdk8;

import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

/**
 * Created by wangyingjie1 on 2017/2/2.
 */
public class Demo {

    public static void main(String[] args) {
        Runnable noArgs = () -> System.out.println("hello World");
        noArgs.run();

        Thread thread = new Thread(noArgs);
        thread.start();

        Runnable noArgs2 = () -> {
            System.out.println("hello World");
            System.out.println("hello World");
            System.out.println("hello World");
            System.out.println("hello World");
            System.out.println("hello World");
        };


        ActionListener listener = event -> {

        };

        binaryOperator();

        Predicate<Integer> predicate = (x) -> {
            return x > 5;
        };

        Map<String, Integer> map = new HashMap<>();

        IntPredicate intPredicate = (value)->{
            return value > 0;
        };

        intPredicate.test(-33434);

        //intPredicate.negate();

        //intPredicate.or(intPredicate);


    }

    private static void binaryOperator() {
        //创建了一个函数
        BinaryOperator<Long> add = (x, y) -> x + y;
        Long apply = add.apply(5L, 5L);
        System.out.println(apply);

        binaryAdd(add);
    }

    public static void binaryAdd(BinaryOperator<Long> add) {
        Long apply = add.apply(55L, 45L);
        System.out.println(apply);
    }

}
