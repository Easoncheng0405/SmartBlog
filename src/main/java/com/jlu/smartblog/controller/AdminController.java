package com.jlu.smartblog.controller;

import com.jlu.smartblog.model.Blog;
import com.jlu.smartblog.model.BlogInfo;
import com.jlu.smartblog.model.User;
import com.jlu.smartblog.model.UserInfo;
import com.jlu.smartblog.service.BlogInfoService;
import com.jlu.smartblog.service.BlogService;
import com.jlu.smartblog.service.UserInfoService;
import com.jlu.smartblog.util.BlogCountUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with IDEA
 * author:程杰
 * Date:2018/4/30
 * github:Easoncheng0405
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    private final static int PAGE_SIZE = 1;

    private final UserInfoService userInfoService;

    private final BlogInfoService blogInfoService;

    private final BlogService blogService;

    @Autowired
    public AdminController(UserInfoService userInfoService, BlogInfoService blogInfoService, BlogService blogService) {
        this.userInfoService = userInfoService;
        this.blogInfoService = blogInfoService;
        this.blogService = blogService;
    }

    @GetMapping
    public String get(HttpSession session, Model model, @RequestParam(value = "page", defaultValue = "0",
            required = false) int page, @RequestParam(value = "type", required = false, defaultValue = ":") String type) {
        int count = BlogCountUtil.getCount();
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
        Pageable pageable = PageRequest.of(page, PAGE_SIZE);
        User user = (User) session.getAttribute("CURRENT_USER");
        UserInfo userInfo = userInfoService.findById(user.getId());
        List<Blog> blogs;
        if (type.equals(":"))
            blogs = blogService.findByUser(user, pageable);
        else
            blogs = blogService.findByUserAndType(user, type, pageable);
        for (Blog blog : blogs) {
            blog.setBlogInfo(blogInfoService.findByBlog(blog));
        }
        model.addAttribute("user", user);
        model.addAttribute("userinfo", userInfo);
        model.addAttribute("blogs", blogs);

        String[] strs = userInfo.getBlogType().split(":");

        //分类去重
        Set<String> set = new HashSet<>();
        set.add("默认分类");
        for (String str : strs) {
            if (str.length() < 11 && !str.equals(""))
                set.add(str);
        }
        model.addAttribute("set", set);
        model.addAttribute("type", type);
        return "admin";
    }



    @GetMapping("/type")
    @ResponseBody
    public String modifyType(HttpSession session, @RequestParam("id") long id, @RequestParam("type") String type) {
        User user = (User) session.getAttribute("CURRENT_USER");
        UserInfo userInfo = userInfoService.findById(user.getId());
        String types = userInfo.getBlogType();

        //取出分类并拆分
        String[] res = types.split(":");

        //有type的类别设置为此类别
        for (String str : res) {
            if (str.equals(type)) {
                Blog blog = blogService.findById(id);
                if (blog.getType().equals(type))
                    return "已经属于 " + type + " 类别";
                blog.setType(str);
                blogService.save(blog);
                return "分类成功！请刷新页面查看！";
            }
        }

        return "没有该分类!";
    }
}
