package com.jlu.smartblog.repository;

import com.jlu.smartblog.model.Blog;
import com.jlu.smartblog.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created with IDEA
 * author:程杰
 * Date:2018/5/13
 * github:Easoncheng0405
 */
@Component
public interface CommentRepository extends JpaRepository<Comment,Long> {

    List<Comment> findByBlog(Blog blog);

}
