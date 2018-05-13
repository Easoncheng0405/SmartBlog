package com.jlu.smartblog.repository;

import com.jlu.smartblog.model.BLike;
import com.jlu.smartblog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * Created with IDEA
 * author:程杰
 * Date:2018/5/13
 * github:Easoncheng0405
 */
@Component
public interface BLikeRepository extends JpaRepository<BLike,Long> {

    BLike findBlogLikeByLiker(User liker);
}
