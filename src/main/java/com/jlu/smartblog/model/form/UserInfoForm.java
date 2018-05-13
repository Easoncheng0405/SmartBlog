package com.jlu.smartblog.model.form;

import javax.validation.constraints.Size;

/**
 * Created with IDEA
 * author:程杰
 * Date:2018/5/13
 * github:Easoncheng0405
 */
public class UserInfoForm {

    @Size(max = 150)
    private String header;

    @Size(min = 5, max = 20)
    private String name;

    @Size(max = 30)
    private String email;

    @Size(max = 70)
    private String type;

    @Size(min = 6, max = 25)
    private String password;

    @Size(min = 6, max = 25)
    private String confirm;

    @Size(max = 150)
    private String github;

    @Size(max = 150)
    private String weibo;

    @Size(max = 150)
    private String home;

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getWeibo() {
        return weibo;
    }

    public void setWeibo(String weibo) {
        this.weibo = weibo;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    @Override
    public String toString() {
        return "UserInfoForm{" +
                "header='" + header + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", type='" + type + '\'' +
                ", password='" + password + '\'' +
                ", confirm='" + confirm + '\'' +
                ", github='" + github + '\'' +
                ", weibo='" + weibo + '\'' +
                ", home='" + home + '\'' +
                '}';
    }
}
