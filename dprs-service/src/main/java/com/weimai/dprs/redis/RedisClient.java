package com.weimai.dprs.redis;

import com.weimai.wmcommon.util.spring.SpringUtil;
import org.springframework.data.redis.cache.RedisCache;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;


@Component
public class RedisClient {

    private static final String CACHE_NAME = "dprs:";

    private static final String VOLATILE_CACHE_NAME = "dprs:volatile:";//可变的cache

    // 过期时间设为0，表示永不过期。
    private static final int EXPIRE_TIME = 0;

    private StringRedisTemplate template;

    private RedisCache cache;

    private RedisCache volatileCache;

    public RedisClient() {
        super();
        init();
    }

    public void init() {
        template = SpringUtil.getBean("strRedisTemplate");
        cache = new RedisCache(CACHE_NAME, CACHE_NAME.getBytes(), template, EXPIRE_TIME);
        volatileCache = new RedisCache(VOLATILE_CACHE_NAME, VOLATILE_CACHE_NAME.getBytes(), template, 600);
    }

    public void put(String key, Object obj) {
        cache.put(key, obj);
    }

    public Object get(String key, Class clazz) {
        return cache.get(key) == null ? null : cache.get(key, clazz);
    }

    public void del(String key) {
        cache.evict(key);
    }

    public void put(String key, Object obj, Long expireTime) {
        template = SpringUtil.getBean("strRedisTemplate");
        volatileCache = new RedisCache(VOLATILE_CACHE_NAME, VOLATILE_CACHE_NAME.getBytes(), template, expireTime);
        volatileCache.put(key, obj);
    }

    public Object getByVolatileCache(String key, Class clazz) {
        return volatileCache.get(key) == null ? null : volatileCache.get(key, clazz);
    }

    public void delByVolatileCache(String key) {
        volatileCache.evict(key);
    }

}