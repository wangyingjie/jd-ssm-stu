package com.jd.ssm.user;

/**
 * Created by wangyingjie1 on 2016/11/14.
 */
public class User {

    private String beanId;
    private int id;
    private String userName;
    private int age;
    private String sex;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBeanId() {
        return beanId;
    }

    public void setBeanId(String beanId) {
        this.beanId = beanId;
    }

    // TODO: 2016/11/15  Builder 模式的关键是本类的内部包含一个静态 public static 的内部类
    // builder 模式构建user对象
    public static class Builder {

        private int id;
        private String userName;
        private int age;
        private String sex;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setSex(String sex) {
            this.sex = sex;
            return this;
        }

        // 构建方法
        public User build() {
            User user = new User();
            user.setId(id);
            user.setUserName(userName);
            user.setAge(age);
            user.setSex(sex);
            return user;
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "beanId='" + beanId + '\'' +
                ", id=" + id +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }

    public static void main(String[] args) {

        // 测试Builder模式
        User user = new Builder().setId(111).setUserName("lisi").setAge(111).setSex("nv").build();

        System.out.println(user);
    }
}


