package com.jlu.smartblog.repository;

import com.jlu.smartblog.model.Blog;
import com.jlu.smartblog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created with IDEA
 * author:程杰
 * Date:2018/5/11
 * github:Easoncheng0405
 */
@Component
public interface BlogRepository extends JpaRepository<Blog,Long> {

    List<Blog> findBlogByUser(User user);
}
