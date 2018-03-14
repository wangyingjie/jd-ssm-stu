package com.jd.rpc;


import com.jd.jmi.trade.client.domain.JmiTradeRequest;
import com.jd.jmi.trade.client.domain.JmiTradeResponse;
import com.jd.jmi.trade.client.service.JmiTradeService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test/spring-jsf-consumer-cn.xml")
public class TdcOrderServiceImplTest {

    @Autowired
    private JmiTradeService jmiTradeService;

    /**
     * 国内京加油 jim 通用下单测试
     *
     * @throws Exception
     */
    @Test
    public void submitCNTdcOrder() throws Exception {

        JmiTradeRequest tradeRequest = new JmiTradeRequest();
        tradeRequest.setCartVO(null);
        tradeRequest.setOrderParam(null);
        tradeRequest.setClientInfo(null);
        tradeRequest.setSubmitOrderNecessary(null);
        tradeRequest.setSubmitOrderUnNecessary(null);
        tradeRequest.setList(null);
        tradeRequest.setJmiStock(null);
        tradeRequest.setPromoSubtract(null);
        tradeRequest.setFeature(null);

        JmiTradeResponse response = jmiTradeService.tradeOrder(tradeRequest);
        Assert.assertNotNull(response);
    }


}