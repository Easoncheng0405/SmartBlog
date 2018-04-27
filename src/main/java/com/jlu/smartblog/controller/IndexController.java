package com.jlu.smartblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IDEA
 * author:程杰
 * Date:2018/4/26
 * github:Easoncheng0405
 */

@Controller
@RequestMapping("/")
public class IndexController {

    @GetMapping
    public String get(){
        return "index";
    }

    @PostMapping
    @ResponseBody
    public Map post(){
        String str="<p style=\"margin-top: 50px;\"></p>\n" +
                "#欢迎来到SmartBlog!\n" +
                "\n" +
                "\n" +
                "###SmartBlogBlog 帮助您更快捷地创建博客，更方便地浏览您的博客内容，使用 Markdown 创建易读易写的博客文章。Markdown 由一些经过精挑细选符号所组成，其作用一目了然。\n" +
                "\n" +
                "\n" +
                "##选择Blog的五大理由\n" +
                "\n" +
                "> #####Blog 帮助您更快捷地创建博客，更方便地浏览您的博客内容，每日热门博客推荐，聚焦热点内容。 文章的分类功能，使您的作品具有更多的调理，配和文章标签，让您的博客更容易检索。Markdown 创建易读易写的博客文章。Markdown 由一些经过精挑细选符号所组成，其作用一目了然。更重要的是，Blog完全免费！\n" +
                "\n" +
                "\n" +
                "<br>\n" +
                "* ######热门文章推荐\n" +
                "* ######文章自动分类\n" +
                "* ######添加文章标签\n" +
                "* ######MarkDown轻量编辑器\n" +
                "* ######是的！永久免费\n" +
                "\n" +
                "![Markdown](http://i2.bvimg.com/643433/a3d35d4d94fd6668.jpg)\n" +
                "\n" +
                "\n" +
                "###Spring Framework\n" +
                "\n" +
                ">#####The Spring Framework provides a comprehensive programming and configuration model for modern Java-based enterprise applications - on any kind of deployment platform.\n" +
                "\n" +
                "![Markdown](http://i2.bvimg.com/643433/28976f90abc93ad6.jpg)\n" +
                "\n" +
                "###认识与入门 Markdown\n" +
                "\n" +
                ">####Markdown 是一种轻量级的「标记语言」，它的优点很多，目前也被越来越多的写作爱好者，撰稿者广泛使用。看到这里请不要被「标记」、「语言」所迷惑，Markdown 的语法十分简单。常用的标记符号也不超过十个，这种相对于更为复杂的HTML 标记语言来说，Markdown 可谓是十分轻量的，学习成本也不需要太多，且一旦熟悉这种语法规则，会有一劳永逸的效果。\n" +
                "\n" +
                "\n" +
                "![Markdown](http://i2.bvimg.com/643433/85555f574eaa6525.jpg)\n" +
                "\n" +
                "###Spring Data JPA\n" +
                "\n" +
                ">####Spring Data JPA, part of the larger Spring Data family, makes it easy to easily implement JPA based repositories. This module deals with enhanced support for JPA based data access layers. It makes it easier to build Spring-powered applications that use data access technologies.\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n";
        Map map=new HashMap<String,String>();

        map.put("content",str);
        System.out.println();
        return map;
    }
}
