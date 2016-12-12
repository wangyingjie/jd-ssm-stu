package com.jd.ssm.web.action;


import com.jd.ssm.web.base.BaseAction;

/**
 * Created with IntelliJ IDEA.
 * User: ckm
 * Date: 15-10-29
 * Time: 下午10:29
 * To change this template use File | Settings | File Templates.
 */
public class OrderAction extends BaseAction {


    public String save(){

        System.out.println("index===============================================");

        return "success";
    }

    public String list() throws Exception {

        System.out.println("execute===============================================");

        return "success";
    }

}
