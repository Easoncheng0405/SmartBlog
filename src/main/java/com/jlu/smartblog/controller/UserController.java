package com.jlu.smartblog.controller;

import com.jlu.smartblog.model.BlogInfo;
import com.jlu.smartblog.model.User;
import com.jlu.smartblog.model.UserInfo;
import com.jlu.smartblog.service.BlogInfoService;
import com.jlu.smartblog.service.UserInfoService;
import com.jlu.smartblog.service.UserService;
import com.jlu.smartblog.util.BlogCountUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with IDEA
 * author:程杰
 * Date:2018/5/11
 * github:Easoncheng0405
 */
@Controller
@RequestMapping("/user/{id}")
public class UserController {

    private static final int PAGE_SIZE=2;

    private final BlogInfoService blogInfoService;

    private final UserInfoService userInfoService;

    private final UserService userService;

    @Autowired
    public UserController(BlogInfoService blogInfoService, UserInfoService userInfoService, UserService userService) {
        this.blogInfoService = blogInfoService;
        this.userInfoService = userInfoService;
        this.userService = userService;
    }

    @GetMapping
    public String get(@PathVariable("id") long id, Model model, @RequestParam(value = "page",required = false,defaultValue = "0") int page) {
        User user = userService.findById(id);
        if (user == null)
            return "404";
        int count=BlogCountUtil.getCount();
        if (page == -1)
            if (count % PAGE_SIZE == 0)
                page = count / PAGE_SIZE - 1;
            else
                page = count / PAGE_SIZE;
        //这里在添加到pages的时候页号要+1,因为pageable的页号是从0开始的
        List<Integer> pages = new ArrayList<>();
        BlogCountUtil.initPage(page, count, pages, PAGE_SIZE, blogInfoService);
        model.addAttribute("pages", pages);
        model.addAttribute("page",page);

        UserInfo userInfo=userInfoService.findByUser(user);
        Pageable pageable = PageRequest.of(page, PAGE_SIZE);
        List<BlogInfo> list = blogInfoService.findBlogInfoByUser(userInfo.getUser(),pageable);

        String [] type=userInfo.getBlogType().split(":");

        //分类去重
        Set<String> set=new HashSet<>();
        set.add("默认分类");
        for(String str:type){
            if(str.length()<11&&!str.equals(""))
                set.add(str);
        }
        model.addAttribute("set",set);

        model.addAttribute("info", userInfo);
        model.addAttribute("list", list);
        return "user";
    }
}
