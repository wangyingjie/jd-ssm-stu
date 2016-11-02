package com.jd.ssm.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by wangyingjie1 on 2016/11/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "/test/spring-config-example.xml")
public class TestCycleDependency {


    @Test
    public void testCycleDI(){


    }
}
