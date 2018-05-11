package com.jlu.smartblog.service;

import com.jlu.smartblog.model.BlogInfo;

/**
 * Created with IDEA
 * author:程杰
 * Date:2018/5/11
 * github:Easoncheng0405
 */
public interface BlogInfoService {

    BlogInfo save(BlogInfo blogInfo);

    BlogInfo findById(long id);
}
