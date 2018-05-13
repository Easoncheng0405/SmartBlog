package com.jlu.smartblog.model;

import javax.persistence.*;

/**
 * Created with IDEA
 * author:程杰
 * Date:2018/5/11
 * github:Easoncheng0405
 */
@Entity
public class UserInfo {


    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    /**
     * 头像URL
     */
    @Column(length = 100)
    private String header;

    /**
     * github地址
     */
    @Column(length = 100)
    private String github;

    /**
     * 微博链接
     */
    @Column(length = 100)
    private String weibo;


    /**
     * 个人链接
     */
    @Column(length = 100)
    private String home;
    /**
     * 写作总字数
     */
    private long count;


    /**
     * 获得赞数量
     */
    private long ulike;

    /**
     * 关注数量
     */
    private long interest;

    /**
     * 个人简介
     */
    @Column(length = 150)
    private String description;

    /**
     * 文章个人分类
     */
    @Column(length = 150)
    private String blogType;

    @OneToOne
    private User user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
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

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public long getUlike() {
        return ulike;
    }

    public void setUlike(long ulike) {
        this.ulike = ulike;
    }

    public long getInterest() {
        return interest;
    }

    public void setInterest(long interest) {
        this.interest = interest;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBlogType() {
        return blogType;
    }

    public void setBlogType(String blogType) {
        this.blogType = blogType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserInfo userInfo = (UserInfo) o;

        return id == userInfo.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
