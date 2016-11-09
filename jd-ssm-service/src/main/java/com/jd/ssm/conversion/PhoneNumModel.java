package com.jd.ssm.conversion;

/**
 * Created by wangyingjie1 on 2016/11/9.
 */
public class PhoneNumModel {

    private String areaCode;

    private String no;

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "PhoneNumModel{" +
                "areaCode=" + areaCode +
                ", no=" + no +
                '}';
    }
}
