package com.jlu.smartblog.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IDEA
 * author:程杰
 * Date:2018/5/7
 * github:Easoncheng0405
 */
public class CookieUtil {

    public static void set(HttpServletResponse response, String name, String value, int maxAge){
        Cookie cookie = new Cookie(name, value); //设置cookie的key和value值
        cookie.setPath("/");        //路径
        cookie.setMaxAge(maxAge);   //过期时间
        response.addCookie(cookie); //添加cookie
    }

    public static Cookie get(HttpServletRequest request, String name){
        Map<String, Cookie> cookieMap = readCookieMap(request);
        //判断cookieMap是否含有该key
        return cookieMap.getOrDefault(name, null);

    }

    private static Map<String, Cookie> readCookieMap(HttpServletRequest request){
        Map<String, Cookie> cookieMap = new HashMap<>();
        Cookie[] cookies = request.getCookies();        //获取所有的cookie值
        if(cookies != null){
            for (Cookie cookie : cookies){
                cookieMap.put(cookie.getName(),cookie);
            }
        }
        return cookieMap;
    }
}
