package com.jlu.smartblog.config;

import com.jlu.smartblog.fifter.LoginInterceptor;
import com.jlu.smartblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created with IDEA
 * author:程杰
 * Date:2018/5/6
 * github:Easoncheng0405
 */
@Component
public class InterceptorConfig implements WebMvcConfigurer {

    private final UserService service;

    @Autowired
    public InterceptorConfig(UserService service){
        this.service=service;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String urls[]=new String[]{"/admin","/edit"};
        registry.addInterceptor(new LoginInterceptor(service)).addPathPatterns(urls);
    }
}