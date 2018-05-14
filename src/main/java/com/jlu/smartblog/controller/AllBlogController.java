package com.jlu.smartblog.controller;

import com.jlu.smartblog.model.BlogInfo;
import com.jlu.smartblog.service.BlogInfoService;
import com.jlu.smartblog.util.BlogCountUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IDEA
 * author:程杰
 * Date:2018/5/14
 * github:Easoncheng0405
 */
@Controller
@RequestMapping("/all")
public class AllBlogController {

    private final BlogInfoService blogInfoService;

    private static final int PAGE_SIZE = 2;

    @Autowired
    public AllBlogController(BlogInfoService blogInfoService) {
        this.blogInfoService = blogInfoService;
    }

    @GetMapping
    public String get(@RequestParam(value = "page", required = false, defaultValue = "0") int page, Model model) {
        int count = BlogCountUtil.getCount();
        if (page == -1)
            if (count % PAGE_SIZE == 0)
                page = count / PAGE_SIZE - 1;
            else
                page = count / PAGE_SIZE;
        Pageable pageable = PageRequest.of(page, PAGE_SIZE, new Sort(Sort.Direction.DESC, "browse"));

        List<BlogInfo> list = blogInfoService.findAll(pageable);
        model.addAttribute("infos", list);
        List<Integer> pages = new ArrayList<>();

        //这里在添加到pages的时候页号要+1,因为pageable的页号是从0开始的
        BlogCountUtil.initPage(page, count, pages, PAGE_SIZE, blogInfoService);
        model.addAttribute("pages", pages);
        model.addAttribute("page",page);
        return "all";
    }
}
