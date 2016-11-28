package com.jd.ssm.peoplens;

import com.jd.ssm.namespace.People;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by wangyingjie1 on 2016/11/22.
 */
public class PeopleNamespaceHandlerTest implements PeopleNamespaceHandler {

    private static People p1;
    public static final People PEOPLE = people = p1;
    private static People people;

    @Override
    public int hashCode() {
//        com.jd.ssm.peoplens.PeopleNamespaceHandlerTest#funciton
//        doGetStr()
//        funciton()
        return super.hashCode();
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config-ns-people.xml");

        People p = (People) ctx.getBean("cutesource");

        Thread thread = new Thread();
        p1 = p;
        System.out.println(people);
    }

    public String doGetStr(String name) {
        return String.format("you name: %s", name);
    }

    public void funciton() {
        String zhangsan = doGetStr("xxx");
    }

    @Override
    public void method() {
        // 时限接口中的方法
    }

    public void studySmartKey(){
        // F12  快捷键视图切换
        // Alt + /  复制前一个单词（很有意思的一个快捷键）
        // Alt + Shit + /  复制后一个单词
        // Alt + 菜单名首字母会有惊喜
        // Ctrl + O 重写父类的方法
        // Ctrl + I   实现接口中的方法
        // Ctrl + Alt + Shift + T  为当前类提炼接口
        // Ctrl + Alt + c/v/p/f/m
        // Ctrl + J   代码模板提示快捷键

    }

}
