package com.jd.ssm.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

/**
 * Created by wangyingjie1 on 2016/11/8.
 */
@Service("applicationListenerImpl")
public class ApplicationListenerImpl implements ApplicationListener<ApplicationEventImpl> {

    @Override
    public void onApplicationEvent(ApplicationEventImpl event) {
        System.out.println("onApplicationEvent executed starting");
        event.print();
        System.out.println("onApplicationEvent executed ending");
    }
}
