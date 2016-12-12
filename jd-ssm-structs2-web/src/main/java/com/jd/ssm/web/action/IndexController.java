package com.jd.ssm.web.action;


/**
 * Created with IntelliJ IDEA.
 * User: ckm
 * Date: 15-10-29
 * Time: 下午10:29
 * To change this template use File | Settings | File Templates.
 */
public class IndexController  {


    public String index(){

        System.out.printf("${structs.version}===============================================xxxxxxxxxxxxxxxxxxxxxxxxxxx");

        return "index";
    }
    

}
