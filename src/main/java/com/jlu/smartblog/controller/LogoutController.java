package com.jlu.smartblog.controller;

import com.jlu.smartblog.util.CookieUtil;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IDEA
 * author:程杰
 * Date:2018/5/7
 * github:Easoncheng0405
 */
@Controller
@RequestMapping("/logout")
public class LogoutController {


    @GetMapping
    public String get(HttpServletResponse response,HttpServletRequest request){
        CookieUtil.set(response,"email",null,0);
        CookieUtil.set(response,"password",null,0);
        request.getSession().removeAttribute("CURRENT_USER");
        return "redirect:/login";
    }
}
