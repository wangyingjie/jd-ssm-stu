package com.jd.ssm.jdk8.converter;

import com.jd.ssm.jdk8.Converter;
import org.junit.Test;

/**
 * Created by wangyingjie1 on 2017/1/23.
 */
public class ConverterTest {

    @Test
    public void testConverter_1() {
        Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
        Integer converted = converter.convert("123");
        System.out.println(converted);    // 123
    }

    @Test
    public void testConverter_2() {
        //Java 8 允许你使用 :: 关键字来传递方法或者构造函数引用，以下的代码展示了如何引用一个静态方法
        Converter<String, Integer> converter = Integer::valueOf;
        Integer converted = converter.convert("123");
        System.out.println(converted);   // 123
    }

    @Test
    public void testConverter_3() {
        //Java 8 我们也可以引用一个对象的方法：
//        Converter<String, Integer> converter = String::new;
//        converter = something::startsWith;
//        String converted = converter.convert("Java");
//        System.out.println(converted);    // "J"
    }

}
