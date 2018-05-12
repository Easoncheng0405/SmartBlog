package com.jlu.smartblog.service.impl;

import com.jlu.smartblog.model.BlogInfo;
import com.jlu.smartblog.model.User;
import com.jlu.smartblog.repository.BlogInfoRepository;
import com.jlu.smartblog.service.BlogInfoService;
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
public class BlogInfoServiceImpl implements BlogInfoService {

    private final BlogInfoRepository repository;

    @Autowired
    public BlogInfoServiceImpl(BlogInfoRepository repository){
        this.repository=repository;
    }

    @Override
    public BlogInfo save(BlogInfo blogInfo) {
        return repository.save(blogInfo);
    }

    @Override
    public BlogInfo findById(long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<BlogInfo> findBlogInfoByUser(User user, Pageable pageable) {
        return repository.findBlogInfoByUser(user,pageable);
    }

    @Override
    public List<BlogInfo> findBlogInfoByUser(User user) {
        return repository.findBlogInfoByUser(user);
    }
}
