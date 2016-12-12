package com.jd.ssm.web.base;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * Created by wangyingjie1 on 2016/12/12.
 */
public class BaseAction extends ActionSupport {

    private static final Log log = LogFactory.getLog(BaseAction.class);
    //private CookieUtils cookieUtils;
    protected HttpServletResponse response;
    protected HttpServletRequest request;
    public static final int PAGE_SIZE = 20;
    protected String refer;
    protected int page;

    public BaseAction() {
    }

    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }

    /*public String getCookieValue(String name) {
        return this.cookieUtils.getCookieValue(this.request, name);
    }

    public LoginContext getLoginContext() {
        return LoginContext.getLoginContext();
    }

    public void setCookie(String name, String value) {
        this.cookieUtils.setCookie(this.response, name, value);
    }

    public void deleteCookie(String name) {
        this.cookieUtils.deleteCookie(this.response, name);
    }*/

    public String getRemoteIP() {
        String ip = this.request.getRemoteAddr();
        if(this.request.getHeader("x-forwarded-for") != null && !"unknown".equalsIgnoreCase(this.request.getHeader("x-forwarded-for"))) {
            ip = ip + "," + this.request.getHeader("x-forwarded-for");
        }

        return ip;
    }

    public String getRefer() {
        return this.refer;
    }

    public void setRefer(String refer) {
        this.refer = refer;
    }

    public void initRefer(String refer) {
        if(StringUtils.isBlank(this.refer)) {
            this.refer = this.request.getHeader("Referer");
            if(StringUtils.isBlank(this.refer)) {
                this.refer = refer;
            }
        }

    }

    public void initRefer() {
        this.initRefer("list.action");
    }

    public boolean isChain() {
        return !this.isNotChain();
    }

    public boolean isNotChain() {
        List chainHistory = (List) ActionContext.getContext().get("CHAIN_HISTORY");
        return chainHistory == null || chainHistory.isEmpty();
    }

    public boolean getChain() {
        return this.isChain();
    }

    public void setPage(int page) {
        if(page <= 0) {
            page = 1;
        }

        this.page = page;
    }

    public int getPage() {
        return this.page;
    }

    /*protected void toVm(Result result) {
        ValueStack context = ActionContext.getContext().getValueStack();
        context.set("textProvider", this);
        context.set("datePickerLocale", this.getDatePickerLocale());
        context.set("result", result);
        Set set = result.keySet();
        Iterator resultCode = set.iterator();

        String text;
        while(resultCode.hasNext()) {
            text = (String)resultCode.next();
            context.set(text, result.get(text));
        }

        String resultCode1 = result.getResultCode();
        if(StringUtils.isNotBlank(resultCode1)) {
            String[] params = result.getResultCodeParams();
            if(params != null && params.length > 0) {
                text = this.getText(resultCode1, params);
            } else {
                text = this.getText(resultCode1);
            }

            if(result.getSuccess()) {
                this.addActionMessage(text);
            } else {
                this.addActionError(text);
            }
        }
    }*/

    private String getDatePickerLocale() {
        String locale = this.getLocale().toString().toLowerCase();
        String[] arr = locale.split("_");
        if(arr[0].equals("en")) {
            locale = arr[0];
        } else {
            locale = arr[0] + "-" + arr[1];
        }

        return locale;
    }

    /*public void setCookieUtils(CookieUtils cookieUtils) {
        this.cookieUtils = cookieUtils;
    }*/

    protected void fromChain() {
        ValueStack stack = ActionContext.getContext().getValueStack();
        this.setActionErrors((Collection)stack.findValue("getActionErrors"));
        this.setActionMessages((Collection)stack.findValue("getActionMessages"));
        this.setFieldErrors((Map)stack.findValue("getFieldErrors"));
    }

    protected void toChain() {
        ValueStack stack = ActionContext.getContext().getValueStack();
        stack.set("getActionErrors", this.getActionErrors());
        stack.set("getActionMessages", this.getActionMessages());
        stack.set("getFieldErrors", this.getFieldErrors());
    }
}
