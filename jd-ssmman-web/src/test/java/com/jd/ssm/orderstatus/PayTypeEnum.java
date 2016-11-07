package com.jd.ssm.orderstatus;


/**
 * Created with IntelliJ IDEA.
 * User: ckm
 * Date: 2015/11/23
 * Time: 20:13
 * <p/>
 * 支付类型
 */
public enum PayTypeEnum {

    //支付方式:权值   在线:1    余额:2    全品京券:4  全品东券:8  限品京券:16 限品东券:32 京豆:64
    /**
     * 在线
     */
    ONLINE(1, "在线"),
    /**
     * 余额
     */
    CREDIT(2, "余额"),
    /**
     * 在线+余额
     */
    ONLINE_CREDIT(3, "在线+余额"),
    /**
     * 全品京券
     */
    QP_JING_COUPON(4, "全品京券"),
    /**
     * 在线+全品京券
     */
    ONLINE_QP_JING_COUPON(5, "在线+全品京券"),
    /**
     * 余额+全品京券
     */
    CREDIT_QP_JING_COUPON(6, "余额+全品京券"),
    /**
     * 在线+余额+全品京券
     */
    ONLINE_CREDIT_QP_JING_COUPON(7, "在线+余额+全品京券"),
    /**
     * 全品东券
     */
    QP_DONG_COUPON(8, "全品东券"),
    /**
     * 在线+全品东券
     */
    ONLINE_QP_DONG_COUPON(9, "在线+全品东券"),
    /**
     * 余额+全品东券
     */
    CREDIT_QP_DONG_COUPON(10, "余额+全品东券"),
    /**
     * 在线+余额+全品东券
     */
    ONLINE_CREDIT_QP_DONG_COUPON(11, "在线+余额+全品东券"),
    /**
     * 限品京券
     */
    XP_JING_COUPON(16, "限品京券"),
    /**
     * 在线+限品京券
     */
    ONLINE_XP_JING_COUPON(17, "在线+限品京券"),
    /**
     * 余额+限品京券
     */
    CREDIT_XP_JING_COUPON(18, "余额+限品京券"),
    /**
     * 在线+余额+限品京券
     */
    ONLINE_CREDIT_XP_JING_COUPON(19, "在线+余额+限品京券"),
    /**
     * 限品东券
     */
    XP_DONG_COUPON(32, "限品东券"),
    /**
     * 在线+限品东券
     */
    ONLINE_XP_DONG_COUPON(33, "在线+限品东券"),
    /**
     * 余额+限品东券
     */
    CREDIT_XP_DONG_COUPON(34, "余额+限品东券"),
    /**
     * 在线+余额+限品东券
     */
    ONLINE_CREDIT_XP_DONG_COUPON(35, "在线+余额+限品东券"),
    /**
     * 京豆
     */
    JING_BEAN(64, "京豆"),
    /**
     * 在线+京豆
     */
    ONLINE_JING_BEAN(65, "在线+京豆");


    private int type;
    private String value;

    PayTypeEnum(int type, String value) {
        this.type = type;
        this.value = value;
    }


    public static String getValue(int type) {
        for (PayTypeEnum p : PayTypeEnum.values()) {
            if (p.getType() == type) {
                return p.getValue();
            }
        }
        return "";
    }

    public int getType() {
        return type;
    }

    public void setType(int Type) {
        this.type = Type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    /**
     * 判断是否混合支付
     *
     * @param payType
     * @return
     */
    public static boolean isMixPayOrder(int payType) {
        return isIncludeOnline(payType) && isIncludeVirtualPay(payType);
    }


    /**
     * 判断是否包含虚拟资产
     *
     * @param payType
     * @return
     */
    public static boolean isIncludeVirtualPay(int payType) {
        return payType > ONLINE.getType();
    }

    /**
     * 获取订单的支付类型
     *
     * @param param
     * @return
     */
    public static int getPayType(PayTypeParam param) {
        return getRadix(param.getOnline(), 0) + getRadix(param.getBalance(), 1) + getRadix(param.getQpJingCoupon(), 2) + getRadix(param.getQpDongCoupon(), 3) + getRadix(param.getXpJingCoupon(), 4)
                + getRadix(param.getXpDongCoupon(), 5) + getRadix(param.getJingBean(), 6);
    }

    private static int getRadix(long fee, int number) {
        return (fee > 0 ? 1 : 0) << number;
    }

    /**
     * 判断是否包含在线
     *
     * @param payType
     * @return
     */
    public static boolean isIncludeOnline(int payType) {
        return (payType & 0x01) > 0;
    }


    /**
     * 判断是否包含余额
     *
     * @param payType
     * @return
     */
    public static boolean isIncludeBalance(int payType) {
        return (payType & 0x02) > 0;
    }

    /**
     * 判断是否包含全品京券
     *
     * @param payType
     * @return
     */
    public static boolean isIncludeQPJingCoupon(int payType) {
        return (payType & 0x04) > 0;
    }

    /**
     * 判断是否包含全品东券
     *
     * @param payType
     * @return
     */
    public static boolean isIncludeQPDongCoupon(int payType) {
        return (payType & 0x08) > 0;
    }

    /**
     * 判断是否包含限品京券
     *
     * @param payType
     * @return
     */
    public static boolean isIncludeXPJingCoupon(int payType) {
        return (payType & 0x10) > 0;
    }

    /**
     * 判断是否包含限品东券
     *
     * @param payType
     * @return
     */
    public static boolean isIncludeXPDongCoupon(int payType) {
        return (payType & 0x20) > 0;
    }

    /**
     * 判断该支付方式是否忽略密码
     *
     * @param payType
     * @return
     */
    public static boolean isIgnorePassword(int payType) {
        return payType == ONLINE.getType() || payType == ONLINE_QP_DONG_COUPON.getType() || payType == ONLINE_XP_DONG_COUPON.getType();//只使用东券与在线混合时免密码
    }

    /**
     * 判断是否包含京豆
     *
     * @param payType
     * @return
     */
    public static boolean isIncludeJingBean(int payType) {
        return (payType & 0x40) > 0;
    }

    public static void main(String[] args) {
        PayTypeParam param = new PayTypeParam();
        param.setOnline(10);
//        param.setBalance(100);

        param.setJingBean(10);

//        param.setXpJingCoupon(20);
//        param.setXpDongCoupon(20);
        System.out.println(getPayType(param));

        //        param.setQpJingCoupon(20);
//        param.setQpDongCoupon(20);
    }
}
