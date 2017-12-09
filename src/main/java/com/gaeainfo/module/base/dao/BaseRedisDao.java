package com.gaeainfo.module.base.dao;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

/**
 * Created by Rock on 2016/11/7.
 */
@Repository
public class BaseRedisDao {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    /**
     * 保存带有超时时间的数据
     * @param key
     * @param object
     * @param timeout 单位 秒
     */
    public void save(String key, Object object, Long timeout) {
        if(object instanceof String){
            redisTemplate.opsForValue().set(key, (String) object, timeout, TimeUnit.SECONDS);
        }else{
            String _key = object.getClass().getName() + key;
            String _value = JSON.toJSONString(object);
            redisTemplate.opsForValue().set(_key, _value, timeout, TimeUnit.SECONDS);
        }


    }

    /**
     * 保存永久有效数据
     * @param key
     * @param object
     */
    public void save(String key, Object object) {
        if(object instanceof String) {
            redisTemplate.opsForValue().set(key, (String) object);
        }else{
            String _key = object.getClass().getName() + key;
            String _value = JSON.toJSONString(object);
            redisTemplate.opsForValue().set(_key, _value);
        }

    }

    /**
     * 根据key和类型获取数据
     * @param key
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T get(String key, Class<T> clazz) {
        String _key = clazz.getName() + key;
        String _value = this.get(_key);
        if(_value == null || "".equals(_value)){
            return null;
        }else{
            return JSON.parseObject(_value,clazz);
        }
    }

    /**
     * 根据key查找value
     * @param key
     * @return
     */
    public String get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     *
     * @param key
     * @param clazz
     */
    public void delete(String key, Class clazz){
        String _key = clazz.getName() + key;
        this.delete(_key);
    }

    public void delete(String key){
        redisTemplate.delete(key);
    }

    /**
     *
     * @param key
     * @param timeout 秒
     */
    public void expired(String key,Long timeout){
        redisTemplate.expire(key,timeout, TimeUnit.SECONDS);
    }



}
