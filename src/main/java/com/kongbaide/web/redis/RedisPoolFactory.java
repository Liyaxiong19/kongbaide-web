package com.kongbaide.web.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by yaxiong.li on 2019/11/20.
 */
@Service
public class RedisPoolFactory {

    @Bean
    public JedisPool JedisPoolFactory() {
        try {
            JedisPoolConfig poolConfig = new JedisPoolConfig();
            JedisPool jp = new JedisPool(poolConfig, "127.0.0.1", 6379, 3000, "123456", 0);
//            JedisPool jp = new JedisPool(poolConfig, "192.168.107.19", 6379, 3000, "gongzhugou2019", 0);

            return jp;
        } catch (Exception e) {
            return null;
        }
    }
}
