package com.jlu.smartblog.controller;

import com.jlu.smartblog.model.User;
import com.jlu.smartblog.model.UserInfo;
import com.jlu.smartblog.model.form.UserInfoForm;
import com.jlu.smartblog.service.UserInfoService;
import com.jlu.smartblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Created with IDEA
 * author:程杰
 * Date:2018/5/13
 * github:Easoncheng0405
 */
@RequestMapping("settings")
@Controller
public class SettingsController {

    private final UserInfoService userInfoService;

    private final UserService userService;

    @Autowired
    public SettingsController(UserInfoService userInfoService, UserService userService) {
        this.userInfoService = userInfoService;
        this.userService = userService;
    }

    @GetMapping
    public String get(HttpSession session,Model model){
        User user =(User) session.getAttribute("CURRENT_USER");
        UserInfo info=userInfoService.findByUser(user);
        UserInfoForm form=new UserInfoForm();
        form.setHeader(info.getHeader());
        form.setGithub(info.getGithub());
        form.setType(info.getBlogType());
        form.setWeibo(info.getWeibo());
        form.setEmail(user.getEmail());
        form.setName(user.getName());
        form.setHome(info.getHome());
        form.setDescription(info.getDescription());
        form.setPassword(user.getPassword());
        form.setConfirm(user.getPassword());
        model.addAttribute("form",form);
        return "settings";
    }

    @PostMapping
    public String post(HttpSession session,Model model, @ModelAttribute("form")@Valid UserInfoForm form, BindingResult result){
        if(result.hasErrors()){
            model.addAttribute("message",result.getFieldError().getDefaultMessage());
            model.addAttribute("form",form);
            return "/settings";
        }
        User user =(User) session.getAttribute("CURRENT_USER");
        UserInfo userInfo=userInfoService.findByUser(user);
        user.setPassword(form.getPassword());
        user.setName(form.getName());
        userInfo.setHome(form.getHome());
        userInfo.setHeader(form.getHeader());
        userInfo.setGithub(form.getGithub());
        userInfo.setWeibo(form.getWeibo());
        userInfo.setBlogType(form.getType());
        userInfo.setDescription(form.getDescription());
        userService.register(user);
        userInfoService.save(userInfo);
        return "redirect:/";
    }
}
