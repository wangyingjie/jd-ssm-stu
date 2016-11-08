package com.jd.ssm.orderstatus;

/**
 * Created by zhangqian on 2015/12/5.
 */
public class PayTypeParam {
    /**
     * 在线
     */
    private long online;
    /**
     * 余额
     */
    private long balance;
    /**
     * 全品京券
     */
    private long qpJingCoupon;
    /**
     * 全品东券
     */
    private long qpDongCoupon;
    /**
     * 限品京券
     */
    private long xpJingCoupon;
    /**
     * 限品东券
     */
    private long xpDongCoupon;
    /**
     * 京豆
     */
    private long jingBean;

    public long getOnline() {
        return online;
    }

    public void setOnline(long online) {
        this.online = online;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public long getQpJingCoupon() {
        return qpJingCoupon;
    }

    public void setQpJingCoupon(long qpJingCoupon) {
        this.qpJingCoupon = qpJingCoupon;
    }

    public long getQpDongCoupon() {
        return qpDongCoupon;
    }

    public void setQpDongCoupon(long qpDongCoupon) {
        this.qpDongCoupon = qpDongCoupon;
    }

    public long getXpJingCoupon() {
        return xpJingCoupon;
    }

    public void setXpJingCoupon(long xpJingCoupon) {
        this.xpJingCoupon = xpJingCoupon;
    }

    public long getXpDongCoupon() {
        return xpDongCoupon;
    }

    public void setXpDongCoupon(long xpDongCoupon) {
        this.xpDongCoupon = xpDongCoupon;
    }

    public long getJingBean() {
        return jingBean;
    }

    public void setJingBean(long jingBean) {
        this.jingBean = jingBean;
    }
}
