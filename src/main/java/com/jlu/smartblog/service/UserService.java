package com.jlu.smartblog.service;

import com.jlu.smartblog.model.User;
import org.springframework.stereotype.Service;

/**
 * Created with IDEA
 * author:程杰
 * Date:2018/5/6
 * github:Easoncheng0405
 */

public interface UserService {

    User findById(long id);

    User findUserByEmail(String email);

    User register(User user);

    User login(String email,String password);

}
