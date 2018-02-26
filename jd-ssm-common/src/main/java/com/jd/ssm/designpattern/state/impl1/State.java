//package com.jd.ssm.designpattern.state.impl1;
//
///**
// * Created by wangyingjie1 on 2016/11/19.
// * <p>
// * 开关状态类
// */
//public interface State {
//
//     void on(Switch s);
//
//     void off(Switch s);
//}
//
//class OnState implements State {
//
//    public void on(Switch s) {
//        System.out.println("已经打开！");
//    }
//
//    public void off(Switch s) {
//        System.out.println("关闭！");
//        s.setState(Switch.getState("off"));
//    }
//}
//
//
//class OffState implements State {
//
//    public void on(Switch s) {
//        System.out.println("打开！");
//        s.setState(Switch.getState("on"));
//    }
//
//    public void off(Switch s) {
//        System.out.println("已经关闭！");
//    }
//}