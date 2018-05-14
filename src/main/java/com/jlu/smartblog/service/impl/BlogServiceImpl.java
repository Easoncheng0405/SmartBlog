package com.jlu.smartblog.service.impl;

import com.jlu.smartblog.model.Blog;
import com.jlu.smartblog.model.User;
import com.jlu.smartblog.repository.BlogRepository;
import com.jlu.smartblog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IDEA
 * author:程杰
 * Date:2018/5/11
 * github:Easoncheng0405
 */
@Service
public class BlogServiceImpl implements BlogService {

    private final BlogRepository repository;

    @Autowired
    public BlogServiceImpl(BlogRepository repository){
        this.repository=repository;
    }

    @Override
    public Blog save(Blog blog) {
        return repository.save(blog);
    }

    @Override
    public Blog findById(long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Blog> findByUser(User user) {
        return repository.findBlogByUser(user);
    }

    @Override
    public List<Blog> findByUser(User user, Pageable pageable) {
        return repository.findBlogByUser(user,pageable);
    }

    @Override
    public List<Blog> findByUserAndType(User user, String type) {
        return repository.findBlogByUserAndType(user,type);
    }

    @Override
    public List<Blog> findByUserAndType(User user, String type, Pageable pageable) {
        return repository.findBlogByUserAndType(user,type,pageable);
    }
}
