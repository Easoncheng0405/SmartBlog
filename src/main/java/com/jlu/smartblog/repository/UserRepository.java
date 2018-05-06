package com.jlu.smartblog.repository;

import com.jlu.smartblog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * Created with IDEA
 * author:程杰
 * Date:2018/5/6
 * github:Easoncheng0405
 */
@Component
public interface UserRepository extends JpaRepository<User,Long> {

    User findUserByEmail(String email);
}
