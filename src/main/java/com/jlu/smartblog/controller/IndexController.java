package com.jlu.smartblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
