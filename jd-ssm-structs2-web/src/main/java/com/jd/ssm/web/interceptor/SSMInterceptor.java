package com.jd.ssm.web.interceptor;


import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SSMInterceptor implements Interceptor {

    /**
     * log
     */
    private final static Logger log = LoggerFactory.getLogger(SSMInterceptor.class);


    @Override
    public void destroy() {

        log.info("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
    }

    @Override
    public void init() {
        log.info("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
    }

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {

        log.info("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

        return null;
    }
}
