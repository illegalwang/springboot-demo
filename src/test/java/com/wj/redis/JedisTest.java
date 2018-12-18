package com.wj.redis;

import redis.clients.jedis.Jedis;

/**
 * 测试Jedis
 * Created by wisi on 2018/12/17.
 */
public class JedisTest {
    public static void main(String[] args) {
        // 连接redis
        Jedis jedis = new Jedis("127.0.0.1", 6379);
//        jedis.set("abc", "123");
//        jedis.set("efg", "456");
        String efg = jedis.get("efg");
        System.out.println(efg);
        jedis.close();
    }
}
