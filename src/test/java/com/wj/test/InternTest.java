package com.wj.test;

/**
 * Created by wisi on 2018/12/17.
 */
public class InternTest {
    public static void main(String[] args) {
        String s1 = new StringBuilder("a").append("b").toString();
        System.out.println(s1.intern() == s1);
        String s2 = new StringBuilder("ja").append("va").toString();
        System.out.println(s2.intern() == s2);
        String s3 = new StringBuilder("hello").append("world").toString();
        System.out.println(s3.intern() == s3);
    }
}
