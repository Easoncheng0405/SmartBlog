package com.jlu.smartblog.repository;

import com.jlu.smartblog.model.BlogInfo;
import com.jlu.smartblog.model.User;
import org.springframework.data.domain.Pageable;
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
public interface BlogInfoRepository extends JpaRepository<BlogInfo,Long> {

    List<BlogInfo> findBlogInfoByUser(User user);

    List<BlogInfo> findBlogInfoByUser(User user, Pageable pageable);



}
