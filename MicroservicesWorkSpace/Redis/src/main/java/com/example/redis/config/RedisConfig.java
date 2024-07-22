package com.example.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import com.example.redis.binding.Country;

@Configuration
public class RedisConfig {

    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory jedis = new JedisConnectionFactory();
        // If your Redis server runs on a different machine, you need to set the hostname and port
        // jedis.setHostName("hostname");
        // jedis.setPort(port);
        return jedis;
    }

    @Bean
    public RedisTemplate<String, Country> redisTemplate(JedisConnectionFactory jedisConnectionFactory) {
        RedisTemplate<String, Country> rt = new RedisTemplate<>();
        rt.setConnectionFactory(jedisConnectionFactory);
        return rt;
    }
}
