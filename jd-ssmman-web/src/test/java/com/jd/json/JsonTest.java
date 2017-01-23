package com.jd.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangyingjie1 on 2016/12/26.
 * <p>
 * Json 在进行解析的时候如果是字符串数字，那么对应的 Value 一定要用引号 ""  将其包起来，否则默认会去掉首位是 0 的所有字符
 */
public class JsonTest {

    public static void main(String[] args) {

        String jsonStr = "{\"unitId\":0004321,\"billKey\":\"0015283737\",\"inputValues\":[\"0015283737\"]}";

        //JSONObject jsonObject = new JSONObject(jsonStr);

        JSONObject jsonObject1 = JSONObject.parseObject(jsonStr);

        Unit unit = JSON.toJavaObject(jsonObject1, Unit.class);

        System.out.println(unit.getUnitId() + "===============" + unit.getBillKey());

        System.out.println("unit====>" + unit);

        testArrayList();
    }

    public static void testArrayList() {
        List<String> list = new ArrayList<String>() {
            {
                add("xxxxx1");
                add("yyyyy1");
                add("xxxxx2");
                add("yyyyy2");
            }
        };

        System.out.println("list=======>" + list);
    }

}

class Unit {

    private int unitId;
    private String billKey;
    private String[] inputValues;

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    public String getBillKey() {
        return billKey;
    }

    public void setBillKey(String billKey) {
        this.billKey = billKey;
    }

    public String[] getInputValues() {
        return inputValues;
    }

    public void setInputValues(String[] inputValues) {
        this.inputValues = inputValues;
    }

    /*@Override
    public String toString() {
        return "com.jd.json.Unit{" +
                "unitId=" + unitId +
                ", billKey='" + billKey + '\'' +
                ", inputValues=" + Arrays.toString(inputValues) +
                '}';
    }*/

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}