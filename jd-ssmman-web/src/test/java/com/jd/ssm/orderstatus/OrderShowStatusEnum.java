package com.jd.ssm.orderstatus;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import org.joda.time.DateTime;

import java.util.Date;
import java.util.Map;

/**
 * User: ckm
 * Date: 2015/12/11
 * Time: 11:40
 * 订单展示状态
 */
public enum OrderShowStatusEnum {
    /**
     * 未参与 待支付 未中奖 已开期 待晒单——>待付款 去支付
     */
    NO_PAY("0_0_0_1_0", "等待付款","立即支付"),
    /**
     * 未参与 支付失败||支付异常 未中奖 >=已开期 待晒单——>支付失败 立即购买
     */
    PAY_FAIL("0_41_0_1_0", "支付失败","继续抢宝"),
    /**
     * 待分配夺宝号||参与成功 已支付	未中奖	已开期 待晒单——>参与成功(等待揭晓)	立即购买
     */
    PARTAKE_SUCCESS("1_1_0_1_0", "等待揭晓","继续抢宝"),
    /**
     * 待分配夺宝号||参与成功	 已支付	全部	已结期 待晒单——>揭晓中   立即购买
     */
    PUBLISHING("2_1_0_2_0", "揭晓中","继续抢宝"),
    /**
     * 参与成功	已支付	已中奖	已算奖 待晒单——>抢宝成功	确认收货地址
     */
    TREASURE_SUCCESS("2_1_1_3_0", "抢中商品","确认收货地址"),
    /**
     * 参与成功||订单完成	已支付	未中奖	>=已算奖 全部——>未抢中	立即购买
     */
    TREASURE_FAIL("2_1_0_3_0", "未抢中","继续抢宝"),
    /**
     * 参与成功||订单完成	已支付	取消中奖		>=已算奖 全部——>过期放弃	立即购买
     */
    GIVE_UP("2_1_2_3_0", "过期放弃","继续抢宝"),
    /**
     * 参与成功	已支付	已中奖	待商家发货 待晒单——>发货中	立即购买
     */
    SENDING("2_1_1_4_0", "发货中","继续抢宝"),
    /**
     * 参与成功	已支付	已中奖	待确认收货 待晒单——>已发货	确认收货
     */
    SENDED("2_1_1_5_0", "已发货","确认收货"),
    /**
     * 参与成功||订单完成	已支付	已中奖	已确认收货 待晒单——>已收货	晒单
     */
    RECIEVED("10_1_1_6_0", "已收货","晒单分享"),
    /**
     * 参与成功||订单完成	已支付	已中奖	 已确认收货 已晒单——>完成（已晒单）	立即购买
     */
    FINISH("10_1_1_6_1", "已晒单","继续抢宝"),
    /**
     * 未参与||已取消||参与失败	未支付(混合支付)||待申请退款||退款中	未中奖	全部 全部——>失败退款	立即购买
     */
    REFUND_FIAL("11_3_0_1_0", "失败退款","继续抢宝"),
    /**
     * 已取消||参与失败	退款成功 	全部 	全部  全部——>退款完成	立即购买
     */
    REFUND_FINISH("11_4_0_1_0", "退款完成","继续抢宝"),
    /**
     * 未参与||已取消 	未支付(非混合支付)	全部 全部 全部——>已取消 	立即购买
     */
    CANCEL("11_0_0_1_0", "订单取消","继续抢宝"),
    OTHER("99", "","继续抢宝");


    private String key;
    private String value;
    private String optName;

    OrderShowStatusEnum(String key, String value , String optName) {
        this.key = key;
        this.value = value;
        this.optName = optName;
    }

    /**
     * 获取枚举
     * <p/>
     * 注意传入状态不对，key可能不存在,需判断返回枚举是否存在
     *
     * @param orderStatus 订单状态
     * @param payStatus   支付状态
     * @param awardStatus 中奖状态
     * @param issueStatus 期状态
     * @param shareStatus 晒单状态
     * @param payType     支付状态
     * @return
     */
    public static OrderShowStatusEnum getOrderStatusEnum(int orderStatus, int payStatus, int awardStatus, int issueStatus, int shareStatus, int payType, Date openAwardTime) {
        //开奖倒计时不为0时，已开奖状态 返回已结期；已中奖状态返回未中奖
        if (isWaitingOpenAward(issueStatus, openAwardTime)) {
            issueStatus = IssueStatusEnum.END_ISSUE.getType();
            awardStatus = AwardStatusEnum.NOT_AWARD.getKey();
        }

        return getOrderStatusForList(orderStatus, payStatus, awardStatus, issueStatus, shareStatus, payType, openAwardTime);
    }


    /**
     * 获取枚举，订单列表页专用
     * <p/>
     * 注意传入状态不对，key可能不存在,需判断返回枚举是否存在
     *
     * @param orderStatus 订单状态
     * @param payStatus   支付状态
     * @param awardStatus 中奖状态
     * @param issueStatus 期状态
     * @param shareStatus 晒单状态
     * @param payType     支付状态
     * @return
     */
    public static OrderShowStatusEnum getOrderStatusForList(int orderStatus, int payStatus, int awardStatus, int issueStatus, int shareStatus, int payType, Date openAwardTime) {
        payStatus = processPayStatus(payStatus);
        return chooseShowStatus(orderStatus, payStatus, awardStatus, issueStatus, shareStatus, payType, openAwardTime);
    }

    private static int processPayStatus(int payStatus){
        //支付异常转换为支付失败
        if (payStatus == PayStatusEnum.PAY_EXCEPTION.getKey()) {
            payStatus = PayStatusEnum.PAY_FAIL.getKey();
        }

        return payStatus;
    }
    private static OrderShowStatusEnum chooseShowStatus(int orderStatus, int payStatus, int awardStatus, int issueStatus, int shareStatus, int payType, Date openAwardTime){
        /**
         * 以下状态直接返回；跨状态的  订单状态：未参与-->已取消  参与成功-->已完成   待分配夺宝号-->参与成功
         */
        //未参与 待支付 未中奖 已开期 待晒单——>待付款 去支付
        if (notPartake(orderStatus) && payStatus == PayStatusEnum.NO_PAY.getKey() && notAward(awardStatus) && issueStatus == IssueStatusEnum.OPEN_ISSUE.getType() && unShare(shareStatus)) {
            return NO_PAY;
        }
        //未参与 支付失败||支付异常 未中奖 >=已开期 全部——>支付失败 立即购买
        if (notPartake(orderStatus) && payException(payStatus) && notAward(awardStatus) && issueStatus >= IssueStatusEnum.OPEN_ISSUE.getType()) {
            return PAY_FAIL;
        }
        //待分配夺宝号||参与成功 已支付	未中奖	已开期 待晒单——>参与成功	立即购买
        if ((orderStatus == OrderStatusEnum.WAIT_DISTRIBUTE.getKey() || orderStatus == OrderStatusEnum.PARTAKE_SUCCESS.getKey()) && payStatus == PayStatusEnum.YES_PAY.getKey()
                && unAwardUnshared(awardStatus, shareStatus) && issueStatus == IssueStatusEnum.OPEN_ISSUE.getType()) {
            return PARTAKE_SUCCESS;
        }

        //待分配夺宝号||参与成功	 已支付	全部 已结期 待晒单——>揭晓中   立即购买
        if ((orderStatus == OrderStatusEnum.WAIT_DISTRIBUTE.getKey() || orderStatus == OrderStatusEnum.PARTAKE_SUCCESS.getKey()) && payStatus == PayStatusEnum.YES_PAY.getKey()
                && unShare(shareStatus) && issueStatus == IssueStatusEnum.END_ISSUE.getType()) {
            return PUBLISHING;
        }
        //参与成功||订单完成 	已支付	未中奖	>=已算奖 全部——>抢宝失败	立即购买
        if (parterSuccessOrFinishPayed(orderStatus, payStatus) && notAward(awardStatus) && issueStatus >= IssueStatusEnum.WAIT_CONFIRM_ADDRESS.getType()) {
            return TREASURE_FAIL;
        }
        //参与成功||订单完成 	已支付	取消中奖	全部		>=已算奖		过期放弃	立即购买	过期放弃
        if (parterSuccessOrFinishPayed(orderStatus, payStatus) && awardStatus == AwardStatusEnum.AWARD_CANCEL.getKey() && issueStatus >= IssueStatusEnum.WAIT_CONFIRM_ADDRESS.getType()) {
            return GIVE_UP;
        }

        //参与成功||订单完成	已支付	已中奖	已确认收货 待晒单——>已收货	晒单
        if (parterSuccessOrFinishPayed(orderStatus, payStatus) && awardReceived(awardStatus, issueStatus) && unShare(shareStatus)) {
            return RECIEVED;
        }
        //参与成功||订单完成	已支付	已中奖	 已确认收货 已晒单——>完成	立即购买
        if (parterSuccessOrFinishPayed(orderStatus, payStatus) && awardReceived(awardStatus, issueStatus) && shared(shareStatus)) {
            return FINISH;
        }

        //未参与||已取消||参与失败	未支付(混合支付)||待申请退款||退款中	未中奖	全部 全部——>失败退款	立即购买
        if ((notPartake(orderStatus) || cancelOrParterFail(orderStatus)) && reunding(payStatus, payType) && notAward(awardStatus)) {
            return REFUND_FIAL;
        }
        //已取消||参与失败	退款成功	全部	全部 全部——>退款完成	立即购买
        if (cancelOrParterFail(orderStatus) && payStatus == PayStatusEnum.REFUND_SUCCESS.getKey()) {
            return REFUND_FINISH;
        }
        //未参与||已取消 	未支付(非混合支付)
        if (notPartakeOrCancel(orderStatus) && (!PayTypeEnum.isMixPayOrder(payType) && payStatus == PayStatusEnum.NO_PAY.getKey())) {
            return CANCEL;
        }

        String key = Joiner.on("_").join(Lists.newArrayList(orderStatus, payStatus, awardStatus, issueStatus, shareStatus));

        Map<String, OrderShowStatusEnum> orderShowStatusEnumMap = OrderShowStatus.orderShowStatusEnumMap;
        OrderShowStatusEnum showStatusEnum = orderShowStatusEnumMap.get(key);
        if (showStatusEnum == null) {
            return OTHER;
        }
        return showStatusEnum;
    }
    private static boolean payException(int payStatus) {
        if (payStatus == PayStatusEnum.PAY_EXCEPTION.getKey() || payStatus == PayStatusEnum.PAY_FAIL.getKey()) {
            return true;
        }
        return false;
    }

    public static boolean isWaitingOpenAward(int issueStatus, Date openAwardTime) {
        return issueStatus >= IssueStatusEnum.END_ISSUE.getType() && DateTime.now().isBefore(openAwardTime.getTime());
    }


    /**
     * 已晒单
     *
     * @param shareStatus
     * @return
     */
    private static boolean shared(int shareStatus) {
        if (shareStatus == ShareStatusEnum.SHAREED.getKey()) {
            return true;
        }
        return false;
    }

    /**
     * 未晒单
     *
     * @param shareStatus
     * @return
     */
    private static boolean unShare(int shareStatus) {
        if (shareStatus == ShareStatusEnum.UN_SHARE.getKey()) {
            return true;
        }
        return false;
    }

    /**
     * 未中奖
     *
     * @param awardStatus
     * @return
     */
    private static boolean notAward(int awardStatus) {
        if (awardStatus == AwardStatusEnum.NOT_AWARD.getKey()) {
            return true;
        }
        return false;
    }

    /**
     * 未参与
     *
     * @param orderStatus
     * @return
     */
    private static boolean notPartake(int orderStatus) {
        if (orderStatus == OrderStatusEnum.NO_PARTAKE.getKey()) {
            return true;
        }
        return false;
    }

    /**
     * 已中奖  已确认收货
     *
     * @param awardStatus
     * @param issueStatus
     * @return
     */
    private static boolean awardReceived(int awardStatus, int issueStatus) {
        if (awardStatus == AwardStatusEnum.AWARD.getKey() && issueStatus == IssueStatusEnum.RECEIVED.getType()) {
            return true;
        }
        return false;
    }


    /**
     * 订单状态  已取消或参与失败
     *
     * @param orderStatus
     * @return
     */
    private static boolean cancelOrParterFail(int orderStatus) {
        if (orderStatus == OrderStatusEnum.CANCEL.getKey() || orderStatus == OrderStatusEnum.PARTAKE_FAIL.getKey()) {
            return true;
        }
        return false;
    }

    /**
     * 未参与 或 已取消
     *
     * @param orderStatus
     * @return
     */
    private static boolean notPartakeOrCancel(int orderStatus) {
        if (notPartake(orderStatus) || orderStatus == OrderStatusEnum.CANCEL.getKey()) {
            return true;
        }
        return false;
    }

    /**
     * (参与成功||订单完成) && 支付成功
     *
     * @param orderStatus
     * @param payStatus
     * @return
     */
    private static boolean parterSuccessOrFinishPayed(int orderStatus, int payStatus) {
        if ((orderStatus == OrderStatusEnum.PARTAKE_SUCCESS.getKey() || orderStatus == OrderStatusEnum.FINISH.getKey()) && payStatus == PayStatusEnum.YES_PAY.getKey()) {
            return true;
        }
        return false;
    }


    /**
     * 未中奖 待晒单
     *
     * @param awardStatus
     * @param shareStatus
     * @return
     */
    private static boolean unAwardUnshared(int awardStatus, int shareStatus) {
        if (notAward(awardStatus) && unShare(shareStatus)) {
            return true;
        }
        return false;
    }

    private static boolean reunding(int payStatus, int payType) {
        if ((payStatus == PayStatusEnum.NO_PAY.getKey() && PayTypeEnum.isMixPayOrder(payType)) ||
                payStatus == PayStatusEnum.WAIT_REFUND.getKey() || payStatus == PayStatusEnum.REFUNDING.getKey()) {
            return true;
        }
        return false;
    }


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getOptName() {
        return optName;
    }

    public void setOptName(String optName) {
        this.optName = optName;
    }


    public static void main(String[] args){
        System.out.println(getOrderStatusForList(10, 1, 1, 6, 1, 33, new Date()).getKey());
    }

}
