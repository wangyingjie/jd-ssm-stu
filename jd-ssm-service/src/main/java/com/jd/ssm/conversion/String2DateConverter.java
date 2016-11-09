package com.jd.ssm.conversion;


import org.apache.commons.lang.time.DateUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;

/**
 * Created by wangyingjie1 on 2016/11/9.
 *
 * 字符串时间 转 Date类型且进行格式化
 */
@Service("string2DateConverter")
public class String2DateConverter implements Converter<String, Date> {

    @Override
    public Date convert(String source) {
        try {
            return DateUtils.parseDate(source, new String[]{"yyyy-MM-dd HH:mm:ss"});
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }


}
