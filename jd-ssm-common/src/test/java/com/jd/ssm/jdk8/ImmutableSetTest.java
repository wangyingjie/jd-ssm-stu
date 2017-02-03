package com.jd.ssm.jdk8;

import com.google.common.base.Function;
import com.google.common.collect.*;
import com.google.common.primitives.Ints;
import org.junit.Test;

import java.util.Map;


/**
 * Created by wangyingjie1 on 2017/1/25.
 */
public class ImmutableSetTest {

    @Test
    public void testSet() {
        ImmutableSet digits = ImmutableSet.of("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine");
        Function<String, Integer> lengthFunction = new Function<String, Integer>() {
            public Integer apply(String string) {
                return string.length();
            }
        };

        //一个Map的key映射多个value值，值是一个List元素
        ImmutableListMultimap<Integer, String> digitsByLength = Multimaps.index(digits, lengthFunction);

        /*
        *  digitsByLength maps:
        *  3 => {"one", "two", "six"}
        *  4 => {"zero", "four", "five", "nine"}
        *  5 => {"three", "seven", "eight"}
        */

        System.out.println(digitsByLength);
    }

    @Test
    public void testInvertFrom() {
        ArrayListMultimap<String, Integer> multimap = ArrayListMultimap.create();
        multimap.putAll("b", Ints.asList(2, 4, 6));
        multimap.putAll("a", Ints.asList(4, 2, 1));
        multimap.putAll("c", Ints.asList(2, 5, 3));

        //TreeMultimap<Integer, String> inverse = Multimaps.invertFrom(multimap, TreeMultimap<Integer,String>.create());

        //注意我们选择的实现，因为选了TreeMultimap，得到的反转结果是有序的

        /*
        * inverse maps:
        *  1 => {"a"}
        *  2 => {"a", "b", "c"}
        *  3 => {"c"}
        *  4 => {"a", "b"}
        *  5 => {"c"}
        *  6 => {"b"}
        */


    }


    @Test
    public void testForMap() {
        Map<String, Integer> map = ImmutableMap.of("a", 1, "b", 2, "c", 3);

        SetMultimap<String, Integer> multimap = Multimaps.forMap(map);

        // multimap：["a" => {1}, "b" => {1}, "c" => {2}]

        System.out.println(multimap);

        //Multimap<Integer, String> inverse = Multimaps.invertFrom(multimap, HashMultimap<Integer, String>.create());

        // inverse：[1 => {"a","b"}, 2 => {"c"}]

    }


}
