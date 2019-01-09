package com.wj.test;

/**
 * Created by wisi on 2019/1/9.
 */
public class StaticTest {

    public static void say() {
        System.out.println("hello");
    }

    public static void main(String[] args) {
        ((StaticTest)null).say();
    }
}
