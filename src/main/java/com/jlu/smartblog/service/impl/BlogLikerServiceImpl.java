package com.jlu.smartblog.service.impl;

import com.jlu.smartblog.model.BLike;
import com.jlu.smartblog.model.User;
import com.jlu.smartblog.repository.BLikeRepository;
import com.jlu.smartblog.service.BlogLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IDEA
 * author:程杰
 * Date:2018/5/13
 * github:Easoncheng0405
 */
@Service
public class BlogLikerServiceImpl implements BlogLikeService {

    private final BLikeRepository repository;

    @Autowired
    public BlogLikerServiceImpl(BLikeRepository repository) {
        this.repository = repository;
    }


    @Override
    public BLike findByLiker(User liker) {
        return repository.findBlogLikeByLiker(liker);
    }

    @Override
    public BLike save(BLike bLike) {
        return repository.save(bLike);
    }
}
