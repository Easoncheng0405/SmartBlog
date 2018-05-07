package com.jlu.smartblog.model.form;

import com.jlu.smartblog.model.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

/**
 * Created with IDEA
 * author:程杰
 * Date:2018/5/7
 * github:Easoncheng0405
 */
public class LoginForm {

    @Email
    @Size(max = 30)
    private String email;

    @Size(max = 25,min=6)
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getUser(){
        User user=new User();
        user.setEmail(email);
        user.setPassword(password);
        return user;
    }
}
