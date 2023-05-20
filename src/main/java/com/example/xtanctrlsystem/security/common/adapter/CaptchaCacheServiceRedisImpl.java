package com.example.xtanctrlsystem.security.common.adapter;

import com.anji.captcha.service.CaptchaCacheService;
import com.example.xtanctrlsystem.security.common.util.RedisUtil;


/**
 * 适配验证码在redis的存储
 * @author panswa
 * @date 2022/3/25 17:33
 */
public class CaptchaCacheServiceRedisImpl implements CaptchaCacheService {
    @Override
    public void set(String key, String value, long expiresInSeconds) {
        RedisUtil.set(key, value, expiresInSeconds);
    }

    @Override
    public boolean exists(String key) {
        return RedisUtil.hasKey(key);
    }

    @Override
    public void delete(String key) {
        RedisUtil.del(key);
    }

    @Override
    public String get(String key) {
        return RedisUtil.get(key);
    }

    @Override
    public String type() {
        return "redis";
    }
}
