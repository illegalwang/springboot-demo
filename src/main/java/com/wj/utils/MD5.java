package com.wj.utils;

import org.apache.shiro.authc.credential.DefaultPasswordService;
import org.apache.shiro.authc.credential.PasswordService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;

import java.security.MessageDigest;

/**
 * Created by wj on 2018/12/28.
 */
public class MD5 {
    public static String md5(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes("UTF-8"));
            byte[] b = md.digest();
            int i;
            StringBuffer sb = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0) {
                    i += 256;
                }
                if (i < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i));
            }
            str = sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    /**
     * 当前所用到的加密方式
     *
     * @param password
     * @return
     */
    public static String nMd5(String password, String userId) {
        // TODO 可以改变规则
        String salt = userId;
        // SimpleHash算法加密，参数:加密方式；密码；盐值；加密次数
        Object simpleHash = new SimpleHash("MD5", password, salt, 1024);
        return simpleHash.toString();
    }

    public static void main(String[] args) {
        PasswordService ps = new DefaultPasswordService();
        String s = "$shiro1$SHA-256$500000$lV71yrsFyF3TkwbqxISryA==$dKtKyX8AmYQ7biVXlUGOn9Dowk9p8GUMiXx8F2qVR5c=";
        System.out.println(ps.encryptPassword("admin"));
        System.out.println(ps.passwordsMatch("admin", s));
        System.out.println(new Md5Hash("admin", "wj", 2));
        System.out.println(md5("admin"));
        System.out.println(md5("123456"));
        System.out.println(nMd5("000000", "9314552ded3a4052947012f41a211733"));
        System.out.println(nMd5("xinyue", "08cfa571f5df43ac82a4ecca6271d2cf"));
    }
}
