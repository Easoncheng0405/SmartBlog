package com.jlu.smartblog.controller;

import com.jlu.smartblog.model.BlogInfo;
import com.jlu.smartblog.model.UserInfo;
import com.jlu.smartblog.service.BlogInfoService;
import com.jlu.smartblog.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created with IDEA
 * author:程杰
 * Date:2018/5/11
 * github:Easoncheng0405
 */
@Controller
@RequestMapping("/user/{id}")
public class UserController {


    private final BlogInfoService blogInfoService;

    private final UserInfoService userInfoService;

    @Autowired
    public UserController(BlogInfoService blogInfoService, UserInfoService userInfoService) {
        this.blogInfoService = blogInfoService;
        this.userInfoService = userInfoService;
    }

    @GetMapping
    public String get(@PathVariable("id") long id, Model model) {
        UserInfo userInfo = userInfoService.findById(id);
        if (userInfo == null)
            return "404";

        List<BlogInfo> list = blogInfoService.findBlogInfoByUser(userInfo.getUser());

        model.addAttribute("info", userInfo);
        model.addAttribute("list", list);
        return "user";
    }
}
