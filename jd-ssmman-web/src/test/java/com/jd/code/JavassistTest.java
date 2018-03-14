package com.jd.code;

import javassist.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @desc: Desc
 * @author: wangyingjie1
 * @date: 2018/3/14 13:41
 */
public class JavassistTest {

    public static final String path = "D:\\workspace_git_2\\jd-ssm-stu\\jd-ssmman-web\\src\\test\\java\\com\\jd\\code\\";

    @Test
    public void makeNewClass() throws IOException, CannotCompileException {
        ClassPool classPool = ClassPool.getDefault();
        CtClass cc = classPool.makeClass("Test");

        byte[] bytes = cc.toBytecode();
        FileOutputStream fos = new FileOutputStream(path + "Test3.class");
        fos.write(bytes);
        fos.flush();
        fos.close();
    }

    @Test
    public void makeComplexClass() throws Exception {
        ClassPool classPool = ClassPool.getDefault();

        classPool.appendClassPath("java.lang.Runnable");

        Loader cl = new Loader(classPool);
        // cl.

        cl.loadClass("java.lang.Runnable");

        // classPool.importPackage("java.awt.*");

        CtClass cc = classPool.makeClass("Complex");

        // impl interface  如果是Java自带的类则直接从 classPool 获取即可, 如果是自定义的接口则需要 make
        //CtClass runnable = classPool.makeInterface("Runnable");

        cc.addInterface(classPool.get("java.lang.Runnable"));

        // override run
        final CtMethod ctMethod = CtMethod.make("public voi0d run(){System.out.println(\"Hello world.\");}", cc);
        cc.addMethod(ctMethod);

        final Class clazz = cc.toClass();

        final Object instance = clazz.newInstance();
        final Method method = clazz.getDeclaredMethod("run");
        final Object invoke = method.invoke(instance, null);
        System.out.println("return========>" + invoke);

        byte[] bytes = cc.toBytecode();
        FileOutputStream fos = new FileOutputStream(path + "Complex.class");
        fos.write(bytes);
        fos.flush();
        fos.close();
    }

    @Test
    public void loadClazz() throws Exception {
        ClassPool pool = ClassPool.getDefault();
        Loader cl = new Loader(pool);

        CtClass ct = pool.get("com.jd.code.bean.Lion");

        ct.setSuperclass(pool.get("com.jd.code.bean.Animal"));

        Class c = cl.loadClass("com.jd.code.bean.Lion");
        Object rect = c.newInstance();

        final Object instance = ct.toClass().newInstance();

        System.out.println(rect + "==============" + instance.getClass().getSuperclass());
    }

    @Test
    public void readClassFile() throws IOException, CannotCompileException {
        FileInputStream fis = new FileInputStream(path + "Test2.class");
        ClassPool classPool = ClassPool.getDefault();
        CtClass cc = classPool.makeClass(fis);

        // rename
        cc.setName("JavassistRocks2");

        byte[] bytes = cc.toBytecode();
        System.out.println(Arrays.toString(bytes));
        System.out.println(new String(bytes));

        FileOutputStream fos = new FileOutputStream(path + "JavassistRocks2.class");
        fos.write(cc.toBytecode());
        fos.flush();
        fos.close();
    }


    @Test
    public void byteArrayClassPath() throws IOException, NotFoundException {
        FileInputStream fis = new FileInputStream(path + "Test2.class");
        String result = "";
        byte[] bytes = new byte[1024];

        while (fis.read(bytes) != -1) {
            result += new String(bytes);
        }

        ClassPool cp = ClassPool.getDefault();
        cp.insertClassPath(new ByteArrayClassPath("Test2", result.getBytes()));
        CtClass cc = cp.get("Test2");
        System.out.println(cc.getSimpleName());
    }


    @Test
    public void insertBefore() throws IOException, NotFoundException, CannotCompileException {
        FileInputStream fis = new FileInputStream(path + "Helper.class");
        ClassPool classPool = ClassPool.getDefault();
        CtClass cc = classPool.makeClass(fis);
        CtMethod ctMethod = cc.getDeclaredMethod("main");
        ctMethod.insertBefore("System.out.println($1.length);");
        cc.setName("JavaassistInsertBefore");
        FileOutputStream fos = new FileOutputStream(path + "JavaassistInsertBefore.class");
        fos.write(cc.toBytecode());
        fos.flush();
        fos.close();
    }


    @Test
    public void newMethodAndField() throws IOException, CannotCompileException {
        FileInputStream fis = new FileInputStream(path + "Helper.class");
        ClassPool classPool = ClassPool.getDefault();
        CtClass cc = classPool.makeClass(fis);
        CtMethod cm = CtNewMethod.make("public void fuckingWorld(String str){System.out.println(\"Fucking:\" + str);}", cc);
        cc.addMethod(cm);
        cc.setName("JavassistNewMethod");

        final CtField ctField = CtField.make("private long id;", cc);
        // 设置属性的初始化值一定要考虑数据类型
        cc.addField(ctField, "1000L");
        // cc.addInterface();

        final CtField ctField2 = CtField.make("private String name;", cc);
        // 设置属性的初始化值一定要考虑数据类型
        cc.addField(ctField2, "\"HelloWorld\"");
        // cc.addInterface();

        FileOutputStream fos = new FileOutputStream(path + "JavassistNewMethod.class");
        fos.write(cc.toBytecode());
        fos.flush();
        fos.close();
    }

    @Test
    public void newInterface() throws IOException, CannotCompileException {
        FileInputStream fis = new FileInputStream(path + "Helper.class");
        ClassPool classPool = ClassPool.getDefault();
        CtClass cc = classPool.makeClass(fis);

        cc.setName("JavassistNewInterface");

        final CtClass runnable = classPool.makeInterface("Runnable");

        //CtClass anInterface = CtClass.

        cc.addInterface(runnable);

        FileOutputStream fos = new FileOutputStream(path + "JavassistNewInterface.class");
        fos.write(cc.toBytecode());
        fos.flush();
        fos.close();
    }
}
