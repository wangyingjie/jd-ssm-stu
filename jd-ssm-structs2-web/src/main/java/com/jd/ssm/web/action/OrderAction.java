package com.jd.ssm.web.action;


import com.jd.ssm.web.base.BaseAction;

/**
 * Created with IntelliJ IDEA.
 * User: wangyingjie1
 * Date: 16-12-12
 * To change this template use File | Settings | File Templates.
 */
public class OrderAction extends BaseAction {


    public String save(){

        System.out.println("save===============================================");

        return "save";
    }

    public String list() throws Exception {

        System.out.println("list===============================================");

        return "list";
    }

}
