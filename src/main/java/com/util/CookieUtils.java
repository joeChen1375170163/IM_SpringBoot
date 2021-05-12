package com.util;

import com.alibaba.fastjson.JSON;
import com.system.entity.User;
import com.util.redisUtil.RedisClient;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * TODO
 * 缓存
 *
 * @author cxh
 * @date 2021/5/6 11:49
 */
public class CookieUtils {

    private static final Integer TOKEN_EXPIRE = 3600;//默认超时时间3600s
    public static final String COOKIE_NAME_TOKEN = "login_user";

    public static void addCookie (HttpServletResponse response, User user, RedisClient redisClient) {
        //将token存入到redis
        redisClient.set(COOKIE_NAME_TOKEN + "::" + user.getToken(), JSON.toJSONString(user), TOKEN_EXPIRE);
        //将token写入cookie
        Cookie cookie = new Cookie(COOKIE_NAME_TOKEN, user.getToken());
        cookie.setMaxAge(TOKEN_EXPIRE);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    public static void delCookie (HttpServletResponse response, User user, RedisClient redisClient) {
        //删除
        redisClient.del(CookieUtils.COOKIE_NAME_TOKEN + "::" + user.getToken());
        //删除cookie
        Cookie cookie = new Cookie(COOKIE_NAME_TOKEN, user.getToken());
        cookie.setMaxAge(0);  // 0s 代表删除
        cookie.setPath("/");
        response.addCookie(cookie);
    }
}
