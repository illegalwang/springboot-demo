package com.wj.utils;

import java.util.UUID;

/**
 *  UUID工具类
 *
 * Created by wj on 2018/12/24.
 */
public class UUIDUtil {

    /**
     * 随机产生32位16进制UUID
     * @return
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    public static void main(String[] args) {
        System.out.println(getUUID());
    }
}
