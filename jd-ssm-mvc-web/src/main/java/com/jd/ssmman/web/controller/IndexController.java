package com.jd.ssmman.web.controller;


import com.jd.ssmman.web.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: ckm
 * Date: 15-10-29
 * Time: 下午10:29
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class IndexController extends BaseController {


    @RequestMapping("/index")
    public String index(){

        System.out.println("Hello  world");

        // spring mvc 容器默认情况下会去 WEB-INF 下面查找：springmvc-servlet.xml 的配置文件 返回值
        //return "index.jsp";

        // 不包含 springmvc-servlet.xml 的配置文件 返回值
        return "index.jsp";
    }
    

}
