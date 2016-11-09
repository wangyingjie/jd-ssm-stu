package com.jd.ssm.conversion;

import org.junit.Test;
import org.springframework.core.convert.support.DefaultConversionService;

import java.util.Date;

/**
 * Created by wangyingjie1 on 2016/11/9.
 *
 * Spring 类型转换器接口测试类
 */
public class ConversionServiceTest {

    @Test
    public void testConversion() {
        DefaultConversionService conversion = new DefaultConversionService();
        conversion.addConverter(new String2PhoneNumConverter());

        String phoneNumStr = "010-1234567";

        PhoneNumModel model = conversion.convert(phoneNumStr, PhoneNumModel.class);

        System.out.println(model);
    }

    @Test
    public void testDateConversion() {
        DefaultConversionService conversionService = new DefaultConversionService();

        conversionService.addConverter(new String2DateConverter());

        Date date = conversionService.convert("2017-12-12 12:11:09", Date.class);

        System.out.println(date);
    }
}
