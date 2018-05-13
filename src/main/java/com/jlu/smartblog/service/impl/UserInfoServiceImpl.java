package com.jlu.smartblog.service.impl;

import com.jlu.smartblog.model.User;
import com.jlu.smartblog.model.UserInfo;
import com.jlu.smartblog.repository.UserInfoRepository;
import com.jlu.smartblog.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IDEA
 * author:程杰
 * Date:2018/5/11
 * github:Easoncheng0405
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    private final UserInfoRepository repository;

    @Autowired
    public UserInfoServiceImpl(UserInfoRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserInfo save(UserInfo userInfo) {
        return repository.save(userInfo);
    }

    @Override
    public UserInfo findById(long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public UserInfo findByUser(User user) {
        return repository.findByUser(user);
    }
}
