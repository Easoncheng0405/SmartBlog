package com.jlu.smartblog.service;

import com.jlu.smartblog.model.BLike;
import com.jlu.smartblog.model.User;

/**
 * Created with IDEA
 * author:程杰
 * Date:2018/5/13
 * github:Easoncheng0405
 */
public interface BlogLikeService {

    BLike findByLiker(User liker);

    BLike save(BLike bLike);
}
