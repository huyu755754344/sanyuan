package com.sanyuan.utils;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

@Component
public class RedisUtils {
	@Autowired
	private  RedisTemplate<String, String> redisTemplate;

	/**
	 * 判断key是否存在
	 * 
	 * @param key
	 * @return
	 */
	public  boolean hasKey(String key) {
		try {
			return redisTemplate.hasKey(key);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
     * 删除缓存
     * @param key 可以传一个值 或多个
     */
	@SuppressWarnings("unchecked")
	public  void del(String... key) {
		if (key != null && key.length > 0) {
			if (key.length == 1) {
				redisTemplate.delete(key[0]);
			} else {
				redisTemplate.delete(CollectionUtils.arrayToList(key));
			}
		}
	}
	
	/**
     * 缓存获取
     * @param key 键
     * @return 值
     */
    public  String get(String key) {
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }
    
    /**
     * 缓存放入
     * @param key 键
     * @param value 值
     * @return true成功 false失败
     */
    public  boolean set(String key, String value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * 缓存放入并设置时间
     * @param key 键
     * @param value 值
     * @param time 时间(秒) time要大于0 如果time小于等于0 将设置无限期
     * @return true成功 false 失败
     */
    public boolean set(String key, String value, long time) {
        try {
            if (time > 0) {
                redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
            } else {
                set(key, value);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    /*public void updateRedis(long userId,HttpServletRequest request) {
    	String cookie = CookieUtils.getCookieValue(request, GlobalConst.COOKIE_NAME);
    	TaUser userDB = userService.selectByUserId(userId);
		set(AesEncryptUtil.desEncrypt(cookie).trim(), JsonUtils.objectToJson(userDB), 24*60*60);
    }*/

}
