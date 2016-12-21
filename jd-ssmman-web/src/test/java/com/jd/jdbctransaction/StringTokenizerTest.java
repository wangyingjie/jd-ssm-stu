package com.jd.jdbctransaction;

import org.junit.Test;

import java.util.StringTokenizer;

/**
 * Created by wangyingjie1 on 2016/12/21.
 */
public class StringTokenizerTest {

    @Test
    public void testStrTokenNextElement() {
        String str = "this   is     so       easy!";
        StringTokenizer stk = new StringTokenizer(str);

        System.out.println(stk);
        while (stk.hasMoreTokens()) {
            System.out.println("|"+stk.nextElement()+"|");
        }
    }

    @Test
    public void testStrTokenNextToken() {
        String str = "this   is     so       easy!";
        StringTokenizer stk = new StringTokenizer(str);

        while (stk.hasMoreTokens()) {
            System.out.println(stk.nextToken());
        }
    }
}
