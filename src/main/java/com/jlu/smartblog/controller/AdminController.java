package com.jlu.smartblog.controller;

import com.jlu.smartblog.model.BlogInfo;
import com.jlu.smartblog.model.User;
import com.jlu.smartblog.model.UserInfo;
import com.jlu.smartblog.service.BlogInfoService;
import com.jlu.smartblog.service.BlogService;
import com.jlu.smartblog.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    private final static int pageSize=1;

    private final UserInfoService userInfoService;

    private final BlogInfoService blogInfoService;

    @Autowired
    public AdminController(UserInfoService userInfoService, BlogInfoService blogInfoService) {
        this.userInfoService = userInfoService;
        this.blogInfoService = blogInfoService;
    }

    @GetMapping
    public String get(HttpSession session, Model model, @RequestParam("page") int page) {

        if (page < 0)
            page = 0;
        Pageable pageable = PageRequest.of(page, pageSize);
        User user = (User) session.getAttribute("CURRENT_USER");
        UserInfo userInfo = userInfoService.findById(user.getId());
        List<BlogInfo> list = blogInfoService.findBlogInfoByUser(user, pageable);
        model.addAttribute("user", user);
        model.addAttribute("userinfo", userInfo);
        model.addAttribute("infos", list);

        model.addAttribute("page", page); //页号
        if(blogInfoService.findBlogInfoByUser(user,PageRequest.of(page+1,pageSize)).size()==0){
            model.addAttribute("flag",0);//如果下一页没有内容吗，放入一个标识符
        }
        return "admin";
    }
}
