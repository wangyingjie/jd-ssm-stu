package com.jd.ssm.wried.impl;

import com.jd.ssm.wried.IAutoWired;
import org.springframework.stereotype.Service;

/**
 * @desc: Desc
 * @author: wangyingjie1
 * @date: 2018/2/26 15:33
 * To change this template use File | Settings | File and Code Templates | Includes | File Header.
 */
@Service
public class AutoWiredImpl1 implements IAutoWired {

    @Override
    public void wired() {

        System.out.println(this.getClass().getCanonicalName());
    }

}
