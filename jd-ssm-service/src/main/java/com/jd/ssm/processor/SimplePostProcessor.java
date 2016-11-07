package com.jd.ssm.processor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by wangyingjie1 on 2016/11/7.
 */
@Service("simplePostProcessor")
public class SimplePostProcessor {

    @Value("${bean.processor}")
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "SimplePostProcessor{" +
                "value='" + value + '\'' +
                '}';
    }

}
