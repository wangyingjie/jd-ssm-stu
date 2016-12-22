package com.jd.cache;

import com.jd.ssm.cache.AccountService2;
import com.sun.management.OperatingSystemMXBean;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.management.ManagementFactory;
import java.text.DecimalFormat;

import static org.junit.Assert.assertNotNull;

/**
 * Created by wangyingjie1 on 2016/12/22.
 *
 *  参考博客：
 *      http://blog.csdn.net/a494303877/article/details/53780675
 *  Spring 缓存处理的上中下
 */
public class AccountService2ImplTest {

    private AccountService2 accountService2;
    private final Logger logger = LoggerFactory.getLogger(AccountService2ImplTest.class);

    @Before
    public void setUp() throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("test/spring-config-cache.xml");
        accountService2 = context.getBean("accountService2Impl", AccountService2.class);
    }

    @Test
    public void testInject() {
        assertNotNull(accountService2);
    }

    @Test
    public void testGetAccountByName() throws Exception {
        logger.info("first query...");
        accountService2.getAccountByName("accountName");
        logger.info("second query...");
        accountService2.getAccountByName("accountName");
    }


}
