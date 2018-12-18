package com.wj.redis;

import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wisi on 2018/12/17.
 */
public class SharedJedisPoolTest {
    public static void main(String[] args) {
        // 构建连接池配置信息
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        // 设置最大连接数
        poolConfig.setMaxTotal(100);
        // 定义集群连接
        List<JedisShardInfo> shards = new ArrayList<>();
        shards.add(new JedisShardInfo("127.0.0.1", 6379));
        shards.add(new JedisShardInfo("127.0.0.1", 6666));

        // 定义集群连接池
        ShardedJedisPool shardedJedisPool = new ShardedJedisPool(poolConfig, shards);
        ShardedJedis shardedJedis = null;

        try{
            // 从连接池中获得Jedis对象
            shardedJedis = shardedJedisPool.getResource();
//            for (int i = 0; i < 20; i++) {
//                shardedJedis.set("k"+i, "v"+i);
//            }

            System.out.println(shardedJedis.get("k12"));
            System.out.println(shardedJedis.get("k7"));
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if (null != shardedJedis) {
                // 关闭
                shardedJedis.close();
            }
        }
        // 关闭连接池
        shardedJedisPool.close();
    }
}
