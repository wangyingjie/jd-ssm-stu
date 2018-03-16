package com.jd.proxy;

import com.jd.proxy.helper.Phone;
import org.junit.Test;

/**
 * @desc  DecoratingClassLoader
 * @author: wangyingjie1
 * @date: ${date}
 */
public class JDProxyTest {

    @Test
    public void testProxy() {
        JDAgent agent = new JDAgent();
        try {
            Communication phoneProxy = (Communication) agent.getInstance(new Phone());
            phoneProxy.call();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
