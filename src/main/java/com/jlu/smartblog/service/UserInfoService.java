package com.jlu.smartblog.service;

import com.jlu.smartblog.model.UserInfo;

/**
 * Created with IDEA
 * author:程杰
 * Date:2018/5/11
 * github:Easoncheng0405
 */
public interface UserInfoService {

    UserInfo save(UserInfo userInfo);

    UserInfo findById(long id);
}
