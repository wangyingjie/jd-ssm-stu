package com.jd.ssm.tx;

/**
 * Created by wangyingjie1 on 2016/11/19.
 */
public class Client {

    public static void main(String[] args) {

        TransactionSupport txs = new TransactionSupport();

        // 此处获取的是 txs 上面的链接
        MyConnection myConnection = txs.getMyConnection();
        // 此处对 myConnection 变量的 autoCommit 属性进行改变！ 猜想txs 里面的myConnection属性的autoCommit是否也会变化呢？？？？？？
        myConnection.setAutoCommit(true);

        //测试验证为： true
        System.out.println(txs.getMyConnection().isAutoCommit());

        //以上验证说明了一个问题：myConnection 指向了 txs.getMyConnection 的内存空间；这种赋值属于引用赋值，址传递。

        //测试 this 关键字
        txs.onBinding();
    }
}
