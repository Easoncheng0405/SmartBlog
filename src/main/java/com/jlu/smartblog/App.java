package com.jlu.smartblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;


/**
 * Created with IDEA
 * author:程杰
 * Date:2018/4/26
 * github:Easoncheng0405
 */

@SpringBootApplication
@Controller
public class App {

    public static void main(String[] args) {

        String str = ":a:b:c:d:";
        String[] res = str.split(":");
        for (String a : res)
            System.out.println(a);

        SpringApplication.run(App.class,args);
    }

}
