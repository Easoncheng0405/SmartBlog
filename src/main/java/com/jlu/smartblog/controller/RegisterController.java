package com.jlu.smartblog.controller;

import com.jlu.smartblog.model.User;
import com.jlu.smartblog.model.form.RegisterForm;
import com.jlu.smartblog.service.UserService;
import com.jlu.smartblog.util.CookieUtil;
import com.jlu.smartblog.util.CreateRandomField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Date;

/**
 * Created with IDEA
 * author:程杰
 * Date:2018/4/27
 * github:Easoncheng0405
 */
@Controller
@RequestMapping("/register")
public class RegisterController {

    private final UserService service;

    @Autowired
    public RegisterController(UserService service){
        this.service=service;
    }

    @GetMapping
    public String get(Model model){
        model.addAttribute("user",new RegisterForm());
        return "register";
    }

    @PostMapping
    public String post(Model model, @ModelAttribute("user")@Valid RegisterForm form, BindingResult result,
                       HttpServletResponse response, HttpServletRequest request){
        if(result.hasErrors()){
            model.addAttribute("user",form);
            model.addAttribute("message",result.getFieldError().getDefaultMessage());
            return "register";
        }

        User user=form.getUser();
        if(user==null){
            model.addAttribute("message","两次输入的密码不一致");
            return "register";
        }

        if(service.findUserByEmail(user.getEmail())!=null){
            model.addAttribute("message","这个邮箱地址已被注册了");
            return "register";
        }
        user.setName(CreateRandomField.getRandomName());
        user.setTime(new Date());
        user=service.register(user);
        CookieUtil.set(response,"email",user.getEmail(),7*24*60*60);
        CookieUtil.set(response,"password",user.getPassword(),7*24*60*60);
        request.setAttribute("CURRENT_USER",user);

        return "redirect:/";
    }

}
