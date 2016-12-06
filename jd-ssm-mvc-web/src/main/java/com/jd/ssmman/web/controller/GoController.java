package com.jd.ssmman.web.controller;

import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.Locale;

/**
 * Created by wangyingjie1 on 2016/11/28.
 */
@Controller
public class GoController implements EnvironmentAware {


    private final Log log = LogFactory.getLog(GoController.class);
    private Environment environment;

    //处理head 类型的  "/" 请求
    @RequestMapping(value = {"/"}, method = {RequestMethod.HEAD})
    public String head() {

        System.out.println("go.jsp  Welcome");

        return "go.jsp";
    }


    //处理 GET  类型的  "/" 、 "index" 请求
    @RequestMapping(value = {"/index", "/"}, method = {RequestMethod.GET})
    public String index(Model model) throws Exception {

        // 1、 Locale 属性可以直接从线程变量里面取到
        Locale locale = LocaleContextHolder.getLocale();
        System.out.println("locale=======>" + locale);

        // 2、 RequestAttributes 属性可以直接从线程变量里面取到
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        System.out.println("requestAttributes ================> " + requestAttributes);


        model.addAttribute("msg", "GO  Go  GO  Go !!!!!!");
        //model.addAttribute("locale", locale);

        return "go.jsp";
    }

    @Override
    public void setEnvironment(Environment environment) {
        // StandardServletEnvironment
        System.out.println("environment============>" + environment);
        this.environment = environment;
    }
}
