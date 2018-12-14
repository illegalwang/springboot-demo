package com.wj.test;

import org.junit.Test;

/**
 * Created by wisi on 2018/12/13.
 */
public class IntTest {
    @Test
    public void test1() {
        int i = 1;
        System.out.println(i-- - ++i);
        System.out.println(i++ + ++i);
        System.out.println(i);
    }

}
