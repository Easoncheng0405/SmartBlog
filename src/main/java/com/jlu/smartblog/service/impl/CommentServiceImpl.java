package com.jlu.smartblog.service.impl;

import com.jlu.smartblog.model.Blog;
import com.jlu.smartblog.model.Comment;
import com.jlu.smartblog.repository.CommentRepository;
import com.jlu.smartblog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IDEA
 * author:程杰
 * Date:2018/5/13
 * github:Easoncheng0405
 */
@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository repository;

    @Autowired
    public CommentServiceImpl(CommentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Comment save(Comment comment) {
        return repository.save(comment);
    }

    @Override
    public List<Comment> findByBlog(Blog blog) {
        return repository.findByBlog(blog);
    }
}
