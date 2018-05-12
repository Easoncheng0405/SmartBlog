package com.jlu.smartblog.controller;

import com.jlu.smartblog.model.Blog;
import com.jlu.smartblog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;




/**
 * Created with IDEA
 * author:程杰
 * Date:2018/4/28
 * github:Easoncheng0405
 */
@Controller
public class BlogController {

    private final BlogService blogService;

    private String str;

    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/blog/{id}")
    public String get(@ModelAttribute("content") String content,@PathVariable("id")long id,Model model){
        Blog blog=blogService.findById(id);
        if(blog==null)
            return "404";
        System.out.println(blog.getDescription());
        model.addAttribute("blog",blog);
        model.addAttribute("user",blog.getUser());
        str=blog.getContent();
        return "blog";
    }
    @GetMapping("/blog/content")
    @ResponseBody
    public String getContent(){
        return str;
    }

}
