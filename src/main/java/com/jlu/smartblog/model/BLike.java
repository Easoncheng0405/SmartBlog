package com.jlu.smartblog.model;

import javax.persistence.*;

/**
 * Created with IDEA
 * author:程杰
 * Date:2018/5/13
 * github:Easoncheng0405
 */
@Entity
public class BLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * 点赞人
     */
    @OneToOne
    private User liker;

    /**
     * 被点赞博客
     */
    @OneToOne
    private Blog blog;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getLiker() {
        return liker;
    }

    public void setLiker(User liker) {
        this.liker = liker;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }
}
