package com.jlu.smartblog.service;

import com.jlu.smartblog.model.Blog;
import com.jlu.smartblog.model.User;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created with IDEA
 * author:程杰
 * Date:2018/5/11
 * github:Easoncheng0405
 */
public interface BlogService {

    Blog save(Blog blog);


    Blog findById(long id);

    List<Blog> findByUser(User user);

    List<Blog> findByUser(User user, Pageable pageable);

    List<Blog> findByUserAndType(User user,String type);

    List<Blog> findByUserAndType(User user,String type,Pageable pageable);
}
