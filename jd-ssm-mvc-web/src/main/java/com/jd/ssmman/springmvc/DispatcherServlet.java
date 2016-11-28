package com.jd.ssmman.springmvc;

/**
 * Created by wangyingjie1 on 2016/11/28.
 * <p>
 * 模拟 Spring mvc DispatchServlet 实现方式
 */
public class DispatcherServlet extends FrameWorkServlet {

    //属性通过 BeanWarpper 反射进行设置值
    private String servletName;
    private String servletDescribe;

    public static void main(String[] args) {

        DispatcherServlet ds = new DispatcherServlet();

        ds.init();

        System.out.println(ds.getServletName() + "=====================" + ds.getServletDescribe());
    }

    /**
     * 初始化Spring mvc 的9大内置组件，使用的策略模式
     *
     * @param applicationContext
     */
    @Override
    protected void onRefresh(String applicationContext) {

        System.out.println(" init Spring mvc 9 大组件 ");

        initStrategies(applicationContext);
    }

    /**
     * 9 大组件初始化功能
     * Initialize the strategy objects that this servlet uses.
     * <p>May be overridden in subclasses in order to initialize further strategy objects.
     */
    protected void initStrategies(String applicationContext) {

        //initMultipartResolver(context);

        //initLocaleResolver(context);

        //initThemeResolver(context);

        //initHandlerMappings(context);

        //initHandlerAdapters(context);

        //initHandlerExceptionResolvers(context);

        //initRequestToViewNameTranslator(context);

        //initViewResolvers(context);

        //initFlashMapManager(context);
    }

    public String getServletName() {
        return servletName;
    }

    public void setServletName(String servletName) {
        this.servletName = servletName;
    }

    public String getServletDescribe() {
        return servletDescribe;
    }

    public void setServletDescribe(String servletDescribe) {
        this.servletDescribe = servletDescribe;
    }
}
