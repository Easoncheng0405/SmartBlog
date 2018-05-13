package com.jlu.smartblog.controller;

import com.jlu.smartblog.model.BlogInfo;
import com.jlu.smartblog.model.UserInfo;
import com.jlu.smartblog.service.BlogInfoService;
import com.jlu.smartblog.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    private static final int pageSize=1;

    private final BlogInfoService blogInfoService;

    private final UserInfoService userInfoService;

    @Autowired
    public UserController(BlogInfoService blogInfoService, UserInfoService userInfoService) {
        this.blogInfoService = blogInfoService;
        this.userInfoService = userInfoService;
    }

    @GetMapping
    public String get(@PathVariable("id") long id, Model model, @RequestParam(value = "page",required = false,defaultValue = "0") int page) {
        UserInfo userInfo = userInfoService.findById(id);
        if (userInfo == null)
            return "404";

        Pageable pageable = PageRequest.of(page, pageSize);
        List<BlogInfo> list = blogInfoService.findBlogInfoByUser(userInfo.getUser(),pageable);

        model.addAttribute("info", userInfo);
        model.addAttribute("list", list);

        model.addAttribute("page", page); //页号
        if(blogInfoService.findBlogInfoByUser(userInfo.getUser(),PageRequest.of(page+1,pageSize)).size()==0){
            model.addAttribute("flag",0);//如果下一页没有内容吗，放入一个标识符
        }
        return "user";
    }
}
