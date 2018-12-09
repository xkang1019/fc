package com.ruoyi.framework.config;


import org.springframework.cache.CacheManager;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;

import org.springframework.data.redis.core.RedisTemplate;

import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.lang.reflect.Method;

@Configuration
@EnableCaching//启用缓存，这个注解很重要；
//继承CachingConfigurerSupport，为了自定义生成KEY的策略。可以不继承。
public class RedisConfig  {




}
