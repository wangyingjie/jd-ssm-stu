package com.jd.code;

import javassist.*;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @desc: Desc
 * @author: wangyingjie1
 * @date: 2018/3/14 17:08
 */
public class ExampleTest {

    //获取类的简单信息
    @Test
    public void test01() throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("com.jd.code.bean.Lion");
        //得到字节码
        byte[] bytes = cc.toBytecode();
        System.out.println(Arrays.toString(bytes));
        System.out.println(cc.getName());//获取类名
        System.out.println(cc.getSimpleName());//获取简要类名
        System.out.println(cc.getSuperclass());//获取父类
        System.out.println(cc.getInterfaces());//获取接口
        System.out.println(cc.getMethods());//获取
    }

    //新生成一个方法
    @Test
    public void test02() throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("com.jd.code.bean.Lion");

        //第一种
        //CtMethod cm = CtMethod.make("public String getName(){return name;}", cc);

        //第二种
        //参数：返回值类型，方法名，参数，对象
        CtMethod cm = new CtMethod(CtClass.intType, "add", new CtClass[]{CtClass.intType, CtClass.intType}, cc);
        cm.setModifiers(Modifier.PUBLIC);//访问范围
        cm.setBody("{return $1+$2;}");
        //cc.removeMethod(m) 删除一个方法

        // 给方法添加异常
        CtClass type = ClassPool.getDefault().get("java.io.IOException");
        cm.addCatch("{ System.out.println($e); throw $e; }", type);
        cc.addMethod(cm);

        //通过反射调用方法
        Class clazz = cc.toClass();
        Object obj = clazz.newInstance();//通过调用无参构造器，生成新的对象
        Method m = clazz.getDeclaredMethod("add", int.class, int.class);

        Object result = m.invoke(obj, 2, 3);

        System.out.println(result);

        cc.writeFile("D:\\workspace_git_2\\jd-ssm-stu\\jd-ssmman-web\\src\\test\\java\\com\\jd\\code\\bean\\");
    }

    //修改已有的方法
    @Test
    public void test03() throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("com.jd.code.bean.Lion");

        CtMethod cm = cc.getDeclaredMethod("hello", new CtClass[]{pool.get("java.lang.String")});
        cm.insertBefore("System.out.println(\"调用前\");");//调用前
        cm.insertAt(29, "System.out.println(\"29\");");//行号
        cm.insertAfter("System.out.println(\"调用后\");");//调用后

        //通过反射调用方法
        Class clazz = cc.toClass();
        Object obj = clazz.newInstance();
        Method m = clazz.getDeclaredMethod("hello", String.class);
        Object result = m.invoke(obj, "张三");
        System.out.println(result);
    }

    //修改已有属性
    @Test
    public void test04() throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("com.jd.code.bean.Lion");

        //属性
        CtField cf = new CtField(CtClass.intType, "age", cc);
        cf.setModifiers(Modifier.PRIVATE);
        cc.addField(cf);
        //增加响应的get set方法
        cc.addMethod(CtNewMethod.getter("getAge", cf));
        cc.addMethod(CtNewMethod.setter("setAge", cf));

        //访问属性
        Class clazz = cc.toClass();
        Object obj = clazz.newInstance();
        Field field = clazz.getDeclaredField("age");
        System.out.println(field);
        Method m = clazz.getDeclaredMethod("setAge", int.class);
        m.invoke(obj, 16);
        Method m2 = clazz.getDeclaredMethod("getAge", null);
        Object resutl = m2.invoke(obj, null);
        System.out.println(resutl);
    }

    //操作构造方法
    @Test
    public void test05() throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("com.jd.code.bean.Lion");

        CtConstructor[] cons = cc.getConstructors();
        for (CtConstructor con : cons) {
            System.out.println(con);
        }
    }

    @Test
    public void test06() throws Exception  {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.makeClass("bean.User");

        //创建属性
        CtField field01 = CtField.make("private int id;",cc);
        CtField field02 = CtField.make("private String name;", cc);
        cc.addField(field01);
        cc.addField(field02);

        //创建方法
        CtMethod method01 = CtMethod.make("public String getName(){return name;}", cc);
        CtMethod method02 = CtMethod.make("public void setName(String name){this.name = name;}", cc);
        cc.addMethod(method01);
        cc.addMethod(method02);

        //添加有参构造器
        CtConstructor constructor = new CtConstructor(new CtClass[]{CtClass.intType,pool.get("java.lang.String")},cc);
        constructor.setBody("{this.id=id;this.name=name;}");
        cc.addConstructor(constructor);
        //无参构造器
        CtConstructor cons = new CtConstructor(null,cc);
        cons.setBody("{}");
        cc.addConstructor(cons);

        cc.writeFile("D:\\workspace_git_2\\jd-ssm-stu\\jd-ssmman-web\\src\\test\\java\\");

    }


}
