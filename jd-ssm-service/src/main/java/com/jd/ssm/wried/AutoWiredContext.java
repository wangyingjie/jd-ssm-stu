package com.jd.ssm.wried;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @desc: Desc
 * @author: wangyingjie1
 * @date: 2018/2/26 15:34
 * To change this template use File | Settings | File and Code Templates | Includes | File Header.
 */
@Component
public class AutoWiredContext {

    @Autowired
    private List<IAutoWired> autoWiredList;

    public void autoPrint(){
        autoWiredList.get(0).wired();
    }

}
