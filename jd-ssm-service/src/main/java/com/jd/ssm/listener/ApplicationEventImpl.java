package com.jd.ssm.listener;

import org.springframework.context.ApplicationEvent;

/**
 * Created by wangyingjie1 on 2016/11/8.
 */
public class ApplicationEventImpl extends ApplicationEvent {

    public String msg;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the component that published the event (never {@code null})
     */
    public ApplicationEventImpl(Object source) {
        super(source);
    }

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the component that published the event (never {@code null})
     * @param msg  the component that published the event (never {@code null})
     */
    public ApplicationEventImpl(Object source, String msg) {
        super(source);
        this.msg = msg;
    }

    public void print(){
        System.out.println("msg================>" + msg);
    }
}
