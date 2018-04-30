package com.jlu.smartblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IDEA
 * author:程杰
 * Date:2018/4/30
 * github:Easoncheng0405
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping
    public String get(){
        return "admin";
    }
}
