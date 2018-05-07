package com.jlu.smartblog.controller;

import com.jlu.smartblog.model.User;
import com.jlu.smartblog.model.form.LoginForm;
import com.jlu.smartblog.service.UserService;
import com.jlu.smartblog.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * Created with IDEA
 * author:程杰
 * Date:2018/4/27
 * github:Easoncheng0405
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    private final UserService service;

    @Autowired
    public LoginController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public String get(Model model) {
        model.addAttribute("user", new LoginForm());
        return "login";
    }


    @PostMapping
    public String post(Model model, @ModelAttribute("user") @Valid LoginForm form, BindingResult result,
                       HttpServletResponse response, HttpServletRequest request, @RequestParam(value = "next", required = false) String next) {
        if (result.hasErrors()) {
            model.addAttribute("user", form);
            model.addAttribute("message", result.getFieldError().getDefaultMessage());
            return "login";
        }

        User user = service.login(form.getEmail(), form.getPassword());
        if (user == null) {
            model.addAttribute("user", form);
            model.addAttribute("message", "用户名或密码错误！");
            return "login";
        }
        CookieUtil.set(response, "email", form.getEmail(), 7 * 24 * 60 * 60);
        CookieUtil.set(response, "password", form.getPassword(), 7 * 24 * 60 * 60);
        request.setAttribute("CURRENT_USER", user);
        return next == null ? "redirect:/" : "redirect:" + next;
    }

}
