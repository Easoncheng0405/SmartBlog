package com.jlu.smartblog.fifter;

import com.jlu.smartblog.model.User;
import com.jlu.smartblog.service.UserService;
import com.jlu.smartblog.util.CookieUtil;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IDEA
 * author:程杰
 * Date:2018/5/6
 * github:Easoncheng0405
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    private final UserService service;


    public LoginInterceptor(UserService service) {
        this.service = service;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getSession().getAttribute("CURRENT_USER") != null) {
            return true;
        }
        Cookie email = CookieUtil.get(request, "email");
        Cookie password = CookieUtil.get(request, "password");
        if (email != null && password != null) {
            User user = service.login(email.getValue(), password.getValue());
            if (user != null) {
                request.getSession().setAttribute("CURRENT_USER", user);
                return true;
            }
        }
        response.sendRedirect("/login?next=".concat(request.getRequestURI()));
        return false;
    }
}
