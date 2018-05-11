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

    @OneToOne
    private User user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
