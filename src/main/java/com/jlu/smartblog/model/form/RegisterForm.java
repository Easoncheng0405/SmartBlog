package com.jlu.smartblog.model.form;

import com.jlu.smartblog.model.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

/**
 * Created with IDEA
 * author:程杰
 * Date:2018/5/6
 * github:Easoncheng0405
 */
public class RegisterForm {

    @Email
    @Size(max = 30)
    private String email;

    @Size(max = 25,min=6)
    private String password;

    @Size(max = 25,min=6)
    private String confirm;

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

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public User getUser(){
        if(password!=null&&password.equals(confirm))
            return new User(email,password);
        return null;
    }
}
