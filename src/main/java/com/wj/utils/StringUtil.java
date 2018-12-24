package com.wj.utils;

/**
 * String 工具类
 * Created by wj on 2018/12/24.
 */
public class StringUtil {
    public static boolean isBlank(String str) {
        if (null == str || str.isEmpty())
            return true;
        return false;
    }
}
