package com.jlu.smartblog.controller;

import com.jlu.smartblog.model.BlogInfo;
import com.jlu.smartblog.model.User;
import com.jlu.smartblog.model.UserInfo;
import com.jlu.smartblog.service.BlogInfoService;
import com.jlu.smartblog.service.BlogService;
import com.jlu.smartblog.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created with IDEA
 * author:程杰
 * Date:2018/4/30
 * github:Easoncheng0405
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserInfoService userInfoService;

    private final BlogInfoService blogInfoService;

    @Autowired
    public AdminController(UserInfoService userInfoService, BlogInfoService blogInfoService) {
        this.userInfoService = userInfoService;
        this.blogInfoService = blogInfoService;
    }

    @GetMapping
    public String get(HttpSession session, Model model) {
        User user = (User) session.getAttribute("CURRENT_USER");
        UserInfo userInfo = userInfoService.findById(user.getId());
        List<BlogInfo> list = blogInfoService.findBlogInfoByUser(user);
        model.addAttribute("user", user);
        model.addAttribute("userinfo", userInfo);
        model.addAttribute("infos", list);
        return "admin";
    }
}
