package com.jd.ssm.web.action;


import com.jd.ssm.user.User;
import com.jd.ssm.web.base.BaseAction;

/**
 * Created with IntelliJ IDEA.
 * User: ckm
 * Date: 15-10-29
 * Time: 下午10:29
 * To change this template use File | Settings | File Templates.
 */
public class IndexAction extends BaseAction {

    private User user;

    private String context = "HelloWorld";

    public String index(){

        System.out.println("index===============================================");

        return "success";
    }

    @Override
    public String execute() throws Exception {

        System.out.println("execute===============================================");

        return "success";
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
