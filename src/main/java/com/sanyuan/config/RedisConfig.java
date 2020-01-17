package com.sanyuan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

public class RedisConfig {
	@Bean  
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {  
       RedisTemplate<String, String> template = new RedisTemplate<String, String>();  
       RedisSerializer<String> redisSerializer = new StringRedisSerializer();
       template.setConnectionFactory(factory);
       //key序列化方式
       template.setKeySerializer(redisSerializer);
       //value序列化
       template.setValueSerializer(redisSerializer);
       //value hashmap序列化
       template.setHashValueSerializer(redisSerializer);
       //key haspmap序列化
       template.setHashKeySerializer(redisSerializer);
       return template;	
    }
}
