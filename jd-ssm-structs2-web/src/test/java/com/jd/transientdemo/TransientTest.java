package com.jd.transientdemo;

import java.io.*;

/**
 * Created by wangyingjie1 on 2016/12/19.
 */
public class TransientTest {

    public static void main(String[] args) throws Exception {

        Tran tranSrc = getTran();

        System.out.println("tranSrc=======>" + tranSrc);

        writeTranObject(tranSrc);

        Tran tranTarget = readTranObject();

        System.out.println("tranTarget==========>" + tranTarget);

    }

    private static Tran readTranObject() throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File("0xjh000")));
        Tran tranTarget = (Tran) in.readObject();
        in.close();
        return tranTarget;
    }

    private static void writeTranObject(Tran tranSrc) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File("0xjh000")));
        out.writeObject(tranSrc);
        out.close();
    }

    private static Tran getTran() {
        Tran tran = new Tran();
        tran.setTid(1000000);
        //tran.setName("zhangsan");
        tran.setContent("^^^^^^^^^^^^^^ Content ^^^^^^^^^^^^^^");
        return tran;
    }


}

class Tran implements /*Serializable*/ Externalizable {

    private int tid;

    // 使用 transient 修饰的属性，在序列化的时候不会被序列化，但是如果实现了 Externalizable 指定了该属性则依然会被序列化
    private transient String name = "实现了 Externalizable 接口无论如何都会并序列化";
    private  String content;

    private static int age = 10;

    public Tran() {
    }

    public Tran(int tid, String name) {
        this.tid = tid;
        this.name = name;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getAge() {
        return age;
    }

    public static void setAge(int age) {
        Tran.age = age;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Tran{" +
                "tid=" + tid +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(content);
        out.writeObject(name);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
       in.readObject();
    }
}