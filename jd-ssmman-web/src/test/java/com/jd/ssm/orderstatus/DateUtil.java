package com.jd.ssm.orderstatus;

import org.apache.commons.lang.time.DateUtils;
import org.joda.time.DateTime;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 时间处理工具
 *
 * @author dingjun
 */
public class DateUtil extends DateUtils {

    public static final SimpleDateFormat timeStampFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    public static final String DATE_FORMAT_1 = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_FORMAT_2 = "yyyy-MM-dd";
    public static final String DATE_FORMAT_3 = "yyyyMMdd";
    public static final String DATE_FORMAT_MY_TREASURE = "yyyy-MM-dd HH:mm:ss SSS";

    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat();

    /**
     * 获取时间戳
     *
     * @return
     */
    public static synchronized String getTimeStamp() {
        return timeStampFormat.format(getCurrentDate());
    }


    public static Date getDayStartTime(Date date) {
        Calendar start = Calendar.getInstance();
        start.setTime(date);
        start.set(start.get(Calendar.YEAR), start.get(Calendar.MONTH), start.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        return start.getTime();
    }

    public static Date getDayEndTime(Date date) {
        Calendar end = Calendar.getInstance();
        end.setTime(date);
        end.set(end.get(Calendar.YEAR), end.get(Calendar.MONTH), end.get(Calendar.DAY_OF_MONTH), 23, 59, 59);
        return end.getTime();
    }

    /**
     * 获取当前时间
     *
     * @return
     */
    public static Date getCurrentDate() {
        Calendar c = Calendar.getInstance();
        return c.getTime();
    }


    public static XMLGregorianCalendar convertToXmlGregorianCalendar(Date date) {
        XMLGregorianCalendar xgc = null;
        try {
            GregorianCalendar gc = new GregorianCalendar();
            gc.setTime(date);
            xgc = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
        } catch (DatatypeConfigurationException e) {
            throw new RuntimeException(e);
        }
        return xgc;
    }

    public static synchronized String getDate2Str(Date date, String format) {
        simpleDateFormat.applyPattern(format);
        return simpleDateFormat.format(date);
    }

    public static synchronized String getDate2Str(Date date) {
        return timeStampFormat.format(date);
    }

    public static synchronized Date getStr2Date(String date, String format) {
        simpleDateFormat.applyPattern(format);
        try {
            return simpleDateFormat.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static synchronized Date addDateMinut(Date date, int x) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE, x);// 24小时制

        return cal.getTime();
    }

    public static synchronized Date addDateDay(Date date, int x) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, x);// 加几天

        return cal.getTime();
    }

    /**
     * 将特定格式的时间字符串转化为Date类型
     *
     * @param format 时间格式
     * @param str    某日期的字符串
     * @return 某日期（Date）
     */
    public static synchronized Date getStrToDate(String format, String str) {
        simpleDateFormat.applyPattern(format);
        ParsePosition parseposition = new ParsePosition(0);
        return simpleDateFormat.parse(str, parseposition);
    }

    /**
     * Date2String（使用joda-time）
     *
     * @param date   日期
     * @param format 时间格式
     * @return
     */
    public static String date4Show(Date date, String format) {
        return new DateTime(date).toString(format);
    }

    /**
     * date 日期是否在当前时间 day 天之前
     *
     * @param date
     * @return
     */
    public static boolean dateBeforeDay(Date date, int day) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusDays(day).isBeforeNow();
    }

    /**
     * 当前时间前/后xx小时或xx分钟
     *
     * @param isMonth     是否查前/后月份
     * @param monthValue  前/后 推xx月
     * @param isMinute    是否查前/后分钟
     * @param minuteValue 前/后 推xx分钟
     * @return
     */
    public static Long getCurrTimeToLong(boolean isMonth, Integer monthValue, boolean isMinute, Integer minuteValue) {
        if (isMonth) {
            if (monthValue == null) {
                return Calendar.getInstance().getTimeInMillis();
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.add(Calendar.MONTH, monthValue - 1);
            return calendar.getTimeInMillis();
        }
        if (isMinute) {
            if (minuteValue == null) {
                return Calendar.getInstance().getTimeInMillis();
            }

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.add(Calendar.MINUTE, minuteValue);
            return calendar.getTimeInMillis();
        }
        return Calendar.getInstance().getTimeInMillis();
    }


    //获取 day 天之前的日期,毫秒不为0  返回日期为：yyyy-MM-dd 00:00:00.SSS
    public static Date getDayBeforeDate(Integer day) {
        Date dayStartTime = DateUtil.getDayStartTime(DateUtil.getCurrentDate());
        // day 天之前的时间
        return DateUtil.addDateDay(dayStartTime, -day);
    }

    // 返回 yyyyMMdd 当前日期
    public static String getCurDay() {
        return getDate2Str(new Date(), DATE_FORMAT_3);
    }

    //获取过去 minutes 分钟的时间
    public static Date getPastMinutesDate(int minutes) {
        DateTime dt = new DateTime().minusMinutes(minutes);
        return dt.toDate();
    }



    /**
     * 返回两个时间段是否在一天内
     *
     * @param startTime
     * @param endTime
     * @param format
     */
    public static long dateDiff(String startTime, String endTime, String format) throws ParseException{
        SimpleDateFormat sd = new SimpleDateFormat(format);
        long nd = 1000 * 24 * 60 * 60;//一天的毫秒数
        //获得两个时间的毫秒时间差异
        long diff = sd.parse(endTime).getTime() - sd.parse(startTime).getTime();

        return (diff / nd);
    }


    public static void main(String[] args) {
        System.out.println(dateBeforeDay(getStr2Date("2016-6-19", "yyyy-MM-dd"), 5));
        System.out.println(DateUtil.getCurrTimeToLong(false, null, true, 2));
        System.out.println(DateUtil.getDayStartTime(DateUtil.getCurrentDate()));
    }
}
