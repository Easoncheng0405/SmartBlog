package com.jlu.smartblog.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created with IDEA
 * author:程杰
 * Date:2018/5/11
 * github:Easoncheng0405
 */
@Entity
public class BlogComment {

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /**
     * 评论者
     */
    @OneToOne
    private User user;

    /**
     * 所属博客
     */
    @OneToOne
    private Blog blog;

    /**
     * 评论内容
     */
    @Column(nullable = false,length =300)
    private String content;

    /**
     * 评论时间
     */
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    /**
     * 回应评论ID
     */
    @Column(nullable = false)
    private long commentTo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getCommentTo() {
        return commentTo;
    }

    public void setCommentTo(long commentTo) {
        this.commentTo = commentTo;
    }
}
