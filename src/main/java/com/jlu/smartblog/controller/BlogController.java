package com.jlu.smartblog.controller;

import com.jlu.smartblog.model.BlogInfo;
import com.jlu.smartblog.model.BLike;
import com.jlu.smartblog.model.User;
import com.jlu.smartblog.model.UserInfo;
import com.jlu.smartblog.service.BlogInfoService;
import com.jlu.smartblog.service.BlogLikeService;
import com.jlu.smartblog.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


/**
 * Created with IDEA
 * author:程杰
 * Date:2018/4/28
 * github:Easoncheng0405
 */
@Controller
public class BlogController {

    private final BlogInfoService blogInfoService;

    private final UserInfoService userInfoService;

    private final BlogLikeService blogLikeService;

    private String str;

    @Autowired
    public BlogController(BlogInfoService blogInfoService, UserInfoService userInfoService, BlogLikeService blogLikeService) {
        this.blogInfoService = blogInfoService;
        this.userInfoService = userInfoService;
        this.blogLikeService = blogLikeService;
    }

    @GetMapping("/blog/{id}")
    public String get(@ModelAttribute("content") String content, @PathVariable("id") long id, Model model) {
        BlogInfo blogInfo = blogInfoService.findById(id);
        if (blogInfo == null)
            return "404";
        model.addAttribute("blog", blogInfo.getBlog());
        model.addAttribute("info", userInfoService.findByUser(blogInfo.getUser()));
        str = blogInfo.getBlog().getContent();

        blogInfo.setBrowse(blogInfo.getBrowse() + 1);
        blogInfoService.save(blogInfo);
        return "blog";
    }

    @GetMapping("/blog/content")
    @ResponseBody
    public String getContent() {
        return str;
    }

    @GetMapping("/blog/like")
    @ResponseBody
    public String like(@RequestParam("id") long id, HttpSession session) {

        //评论人
        User user = (User) session.getAttribute("CURRENT_USER");

        if (blogLikeService.findByLiker(user) != null)
            return "您已经点过赞了！";

        BlogInfo blogInfo = blogInfoService.findById(id);
        blogInfo.setBlike(blogInfo.getBlike() + 1);
        UserInfo userInfo = userInfoService.findByUser(blogInfo.getUser());
        userInfo.setUlike(userInfo.getUlike() + 1);
        userInfoService.save(userInfo);
        blogInfoService.save(blogInfo);

        BLike like = new BLike();
        like.setBlog(blogInfo.getBlog());
        like.setLiker(user);
        blogLikeService.save(like);

        return "感谢您的反馈";
    }



}
