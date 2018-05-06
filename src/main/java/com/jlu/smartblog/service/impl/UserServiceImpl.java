package com.jlu.smartblog.service.impl;

import com.jlu.smartblog.model.User;
import com.jlu.smartblog.repository.UserRepository;
import com.jlu.smartblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IDEA
 * author:程杰
 * Date:2018/5/6
 * github:Easoncheng0405
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository){
        this.repository=repository;
    }

    @Override
    public User findUserByEmail(String email) {
        return repository.findUserByEmail(email);
    }

    @Override
    public User register(User user) {
        return repository.save(user);
    }
}
