package com.jlu.smartblog.controller;

import com.jlu.smartblog.model.User;
import com.jlu.smartblog.model.form.RegisterForm;
import com.jlu.smartblog.service.UserService;
import com.jlu.smartblog.util.CreateRandomField;
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
    public String get(){
        return "register";
    }

    @PostMapping
    public String post(Model model, @ModelAttribute("user")@Valid RegisterForm form,
                       BindingResult result){
        if(result.hasErrors()){
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
        service.register(user);
        return "redirect:/";
    }

}
