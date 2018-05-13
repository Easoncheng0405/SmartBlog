package com.jlu.smartblog.controller;

import com.jlu.smartblog.model.*;
import com.jlu.smartblog.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;


/**
 * Created with IDEA
 * author:程杰
 * Date:2018/4/28
 * github:Easoncheng0405
 */
@Controller
public class BlogController {

    private final BlogInfoService blogInfoService;

    private final BlogService blogService;


    private final UserInfoService userInfoService;

    private final BlogLikeService blogLikeService;

    private final CommentService commentService;

    private String str;

    @Autowired
    public BlogController(BlogInfoService blogInfoService, BlogService blogService, UserInfoService userInfoService,
                          BlogLikeService blogLikeService, CommentService commentService) {
        this.blogInfoService = blogInfoService;
        this.blogService = blogService;
        this.userInfoService = userInfoService;
        this.blogLikeService = blogLikeService;
        this.commentService = commentService;
    }

    @GetMapping("/blog/{id}")
    public String get(HttpSession session,@ModelAttribute("content") String content, @PathVariable("id") long id, Model model) {

        Blog blog = blogService.findById(id);
        if (blog == null)
            return "404";
        //这个user是当前查博客的人
        User user=(User)session.getAttribute("CURRENT_USER");
        System.out.println(user);
        model.addAttribute("blog", blog);
        model.addAttribute("info", userInfoService.findByUser(blog.getUser()));
        str = blog.getContent();

        List<Comment> list = commentService.findByBlog(blog);
        model.addAttribute("comments", list);
        model.addAttribute("user", user);
        BlogInfo blogInfo=blogInfoService.findByBlog(blog);
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


    @PostMapping("/comment")
    public String comment(@RequestParam("content") String content, @RequestParam("bid") long bid,@RequestParam("uid") long uid) {
        Comment comment = new Comment();

        Blog blog=blogService.findById(bid);
        comment.setBlog(blog);
        comment.setContent(content);
        comment.setDate(new Date());
        comment.setUserInfo(userInfoService.findById(uid));
        commentService.save(comment);

        BlogInfo blogInfo=blogInfoService.findByBlog(blog);
        blogInfo.setComment(blogInfo.getComment()+1);
        blogInfoService.save(blogInfo);
        return "redirect:/blog/"+bid+"#"+comment.getId();
    }


}
