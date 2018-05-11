package com.jlu.smartblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IDEA
 * author:程杰
 * Date:2018/5/11
 * github:Easoncheng0405
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping
    public String get(){
        return "user";
    }
}
