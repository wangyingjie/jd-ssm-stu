package com.jd.ssm.conversion;

import org.springframework.core.convert.converter.Converter;

/**
 * Created by wangyingjie1 on 2016/11/9.
 */
public class String2PhoneNumConverter implements Converter<String, PhoneNumModel> {

    @Override
    public PhoneNumModel convert(String source) {
        PhoneNumModel model = new PhoneNumModel();

        String areaCodeStr = source.substring(0, 3);

        model.setAreaCode(areaCodeStr);
        model.setNo(source.substring(4));

        return model;
    }
}
