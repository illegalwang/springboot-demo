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

    /**
     * 获取前13位为时间的UUID
     * @return
     */
    public static String getTimeUUID() {
        return System.currentTimeMillis() + getUUID().substring(13);
    }

    /**
     * 创建一个6位数验证码
     * @return
     */
    public static String createAuthCode() {
        StringBuilder authCode = new StringBuilder();
        int random = (int)(Math.random()*31);
        for (int i = 0; i < 6; i++) {
            String code = getUUID();
            authCode.append(getUUID().substring(random, random+1));
        }
        return authCode.toString();
    }

    public static void main(String[] args) {
//        System.out.println(getUUID());
//        System.out.println(getTimeUUID());
        System.out.println(createAuthCode());
    }
}
