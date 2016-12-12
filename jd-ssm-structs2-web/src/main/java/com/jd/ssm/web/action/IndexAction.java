package com.jd.ssm.web.action;


import com.jd.ssm.web.base.BaseAction;

/**
 * Created with IntelliJ IDEA.
 * User: ckm
 * Date: 15-10-29
 * Time: 下午10:29
 * To change this template use File | Settings | File Templates.
 */
public class IndexAction extends BaseAction {


    public String index(){

        System.out.println("index===============================================");

        return "success";
    }

    @Override
    public String execute() throws Exception {

        System.out.println("execute===============================================");

        return "success";
    }

}
