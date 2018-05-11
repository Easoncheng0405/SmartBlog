package com.jlu.smartblog.model;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

/**
 * Created with IDEA
 * author:程杰
 * Date:2018/5/11
 * github:Easoncheng0405
 */
@Entity
public class BlogInfo {

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * 点赞次数(这里不能用like，mysql关键字)
     */
    private long blike;

    /**
     * 反对次数
     */
    private long dislike;

    /**
     * 收藏次数
     */
    private long collection;

    /**
     * 浏览次数
     */
    private long browse;

    /**
     * 所属博客
     */
    @OneToOne
    private Blog blog;

    @OneToOne
    private User user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getBlike() {
        return blike;
    }

    public void setBlike(long blike) {
        this.blike = blike;
    }

    public long getDislike() {
        return dislike;
    }

    public void setDislike(long dislike) {
        this.dislike = dislike;
    }

    public long getCollection() {
        return collection;
    }

    public void setCollection(long collection) {
        this.collection = collection;
    }

    public long getBrowse() {
        return browse;
    }

    public void setBrowse(long browse) {
        this.browse = browse;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
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

        BlogInfo blogInfo = (BlogInfo) o;

        return id == blogInfo.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
