package com.jlu.smartblog.service;

import com.jlu.smartblog.model.Blog;
import com.jlu.smartblog.model.BlogInfo;
import com.jlu.smartblog.model.User;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created with IDEA
 * author:程杰
 * Date:2018/5/11
 * github:Easoncheng0405
 */
public interface BlogInfoService {

    BlogInfo save(BlogInfo blogInfo);

    BlogInfo findById(long id);

    List<BlogInfo> findBlogInfoByUser(User user);

    List<BlogInfo> findBlogInfoByUser(User user, Pageable pageable);

    BlogInfo findByBlog(Blog blog);

    List<BlogInfo> findAll(Pageable pageable);


}
