package com.jd.ssm.placeholder.impl;

import com.jd.ssm.placeholder.PlaceHolderService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by wangyingjie1 on 2016/11/4.
 */
@Service("placeHolderService")
public class PlaceHolderServiceImpl implements PlaceHolderService {

    @Value("${bean.msg}")
    private String beanMsg;



    @Override
    public void printValue() {

        System.out.println("bean.msg=======>" + beanMsg);


    }


}
