package com.wj.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间日期工具类
 *
 * Created by wj on 2018/12/24.
 */
public class DateUtil {
    /**
     * yyyy年MM月dd日
     */
    public static final String FORMAT_DATE = "yyyy年MM月dd日";
    /**
     * HH:mm:ss
     */
    public static final String FORMAT_TIME = "HH:mm:ss";
    /**
     * yyyy年MM月dd日 HH:mm:ss
     */
    public static final String FORMAT_yyyy_MM_dd_HHmmss = "yyyy年MM月dd日 HH:mm:ss";
    /**
     * yyyyMMddHHmmss
     */
    public static final String FORMAT_yyyyMMddHHmmss = "yyyyMMddHHmmss";
    /**
     * yyyy-MM-dd HH:mm:ss
     */
    public static final String FORMAT_yyyy_MM_dd_HH_mm_ss = "yyyy-MM-dd HH:mm:ss";

    /**
     * 时间格式化为字符串
     * @param date
     * @param format
     * @return
     */
    public static String dateToString(Date date, String format) {
        if (null == date)
            date = Calendar.getInstance().getTime();
        if (StringUtil.isBlank(format))
            format = FORMAT_yyyy_MM_dd_HH_mm_ss;
        return new SimpleDateFormat(format).format(date);
    }
    /**
     * 获取当前时间字符串
     * @return
     */
    public static String dateToString() {
        return new SimpleDateFormat(FORMAT_yyyy_MM_dd_HH_mm_ss).format(Calendar.getInstance().getTime());
    }

    /**
     * 字符串转时间类型
     * @param date
     * @param format
     * @return
     */
    public static Date stringToDate(String date, String format) {
        if (StringUtil.isBlank(date))
            return null;
        if (StringUtil.isBlank(format))
            format = FORMAT_yyyy_MM_dd_HH_mm_ss;
        try {
            return new SimpleDateFormat(format).parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
    }
}
