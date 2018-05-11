package com.jlu.smartblog.repository;

import com.jlu.smartblog.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * Created with IDEA
 * author:程杰
 * Date:2018/5/11
 * github:Easoncheng0405
 */
@Component
public interface UserInfoRepository extends JpaRepository<UserInfo,Long> {


}
