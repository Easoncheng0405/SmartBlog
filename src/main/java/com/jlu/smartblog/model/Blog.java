package com.jlu.smartblog.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created with IDEA
 * author:程杰
 * Date:2018/4/28
 * github:Easoncheng0405
 */
@Entity
public class Blog {

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /**
     * 标题
     */
    @Column(nullable = false,length = 50)
    private String title;

    /**
     * markdown内容
     */
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(nullable = false,length = 10000)
    private String content;

    /**
     * 创建时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date createTime;

    /**
     * 作者
     */
    @OneToOne
    private User user;

    /**
     * 博客详细信息
     */
    @OneToOne
    private BlogComment comment;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BlogComment getComment() {
        return comment;
    }

    public void setComment(BlogComment comment) {
        this.comment = comment;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Blog blog = (Blog) o;

        return id == blog.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
