package com.jlu.smartblog.service;

import com.jlu.smartblog.model.Blog;

/**
 * Created with IDEA
 * author:程杰
 * Date:2018/5/11
 * github:Easoncheng0405
 */
public interface BlogService {

    Blog save(Blog blog);


    Blog findById(long id);
}
