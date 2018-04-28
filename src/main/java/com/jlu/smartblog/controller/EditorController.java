package com.jlu.smartblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created with IDEA
 * author:程杰
 * Date:2018/4/27
 * github:Easoncheng0405
 */
@Controller
@RequestMapping("/edit")
public class EditorController {

    @GetMapping
    public String get(){
        return "edit";
    }

    @PostMapping
    public String post(final RedirectAttributes redirectAttributes, @RequestParam("editormd-markdown-doc") String content){
        //redirectAttributes.addFlashAttribute("",content);
        System.out.println(content);
        return "redirect:/blog";
    }
}
