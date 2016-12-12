package com.jd.ssm.web.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: ckm
 * Date: 2016/1/29
 * Time: 19:11
 */

//@Controller
//@RequestMapping("/mantest")
public class ManTestController {

    private final static Logger log = LoggerFactory.getLogger(ManTestController.class);

    //@ResponseBody
    //@RequestMapping(value = "/test")
    public String insertUserCode(Long orderId) {
        orderId = 1710003002000012301l;
        try {
            //userCodeService.getUserCode(orderId, "pop_10");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return String.valueOf(true);
    }


}
