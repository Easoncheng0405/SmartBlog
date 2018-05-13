package com.jlu.smartblog.service;

import com.jlu.smartblog.model.Blog;
import com.jlu.smartblog.model.Comment;

import java.util.List;

/**
 * Created with IDEA
 * author:程杰
 * Date:2018/5/13
 * github:Easoncheng0405
 */
public interface CommentService {

    Comment save(Comment comment);

    List<Comment> findByBlog(Blog blog);
}
