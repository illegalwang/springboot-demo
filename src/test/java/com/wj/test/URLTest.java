package com.wj.test;

import org.junit.Test;

import java.net.URL;

/**
 * Created by wisi on 2018/12/26.
 */
public class URLTest {
    @Test
    public void createIconUrl() {
        String str = "https://blog.csdn.net/wkl305268748/article/details/77619367/";
        String str1 = "http://jquery.cuishifeng.cn/index.html";
        String str2 = "www.baidu.com";
        try {
            URL url = new URL(str1);
            System.out.println("url授权部分：" + url.getAuthority());
            System.out.println("url的内容：" + url.getContent());
            System.out.println("url关联协议的默认端口：" + url.getDefaultPort());
            System.out.println("url的文件名：" + url.getFile());
            System.out.println("url的主机名：" + url.getHost());
            System.out.println("url的路径部分：" + url.getPath());
            System.out.println("url的端口：" + url.getPort());
            System.out.println("url的协议名：" + url.getProtocol());
            System.out.println("url的查询部分：" + url.getQuery());
            System.out.println("url的锚点：" + url.getRef());
            System.out.println("url的userInfo部分：" + url.getUserInfo());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
