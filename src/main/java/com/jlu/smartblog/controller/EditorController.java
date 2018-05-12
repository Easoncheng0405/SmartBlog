package com.jlu.smartblog.controller;

import com.jlu.smartblog.model.Blog;
import com.jlu.smartblog.model.BlogInfo;
import com.jlu.smartblog.model.User;
import com.jlu.smartblog.service.BlogInfoService;
import com.jlu.smartblog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.util.Date;

/**
 * Created with IDEA
 * author:程杰
 * Date:2018/4/27
 * github:Easoncheng0405
 */
@Controller
@RequestMapping("/edit")
public class EditorController {

    private final BlogService blogService;

    private final BlogInfoService blogInfoService;

    @Autowired
    public EditorController(BlogService blogService, BlogInfoService blogInfoService) {
        this.blogService = blogService;
        this.blogInfoService = blogInfoService;
    }

    @GetMapping
    public String get() {
        return "edit";
    }

    /**
     * @param session session
     * @param content 内容
     * @return 首页
     */
    @PostMapping
    public String post(HttpSession session, @RequestParam("content") String content, Model model) {

        User user = (User) session.getAttribute("CURRENT_USER");
        Blog blog = getBlog(content);
        if (blog == null) {
            model.addAttribute("content", content);
            return "edit";
        }
        blog.setUser(user);


        BlogInfo blogInfo = new BlogInfo();
        blogInfo.setBlog(blog);
        blogInfo.setUser(user);
        blog = blogService.save(blog);

        blogInfoService.save(blogInfo);
        return "redirect:/blog/" + blog.getId();
    }

    /**
     * 以`#`开头,不得超过30个字符，超过只取前30字符
     *
     * @param content 文章内容
     * @return 标题
     */
    private Blog getBlog(String content) {
        if (content.length() < 100)
            return null;
        String title, description;
        Blog blog = new Blog();
        blog.setContent(content);
        blog.setCreateTime(new Date());
        if (!content.startsWith("#")) {
            title = "未命名文章-" + DateFormat.getDateTimeInstance().format(new Date());
            if (content.length() < 300)
                description = content;
            else
                description = content.substring(0, 300);
            blog.setTitle(title);
            blog.setDescription(description);
        } else {
            int i = 1; //直接跳过#字符
            StringBuilder builder = new StringBuilder();
            while (i < 30) {
                char tmp = content.charAt(i);
                if (tmp != '\n')
                    builder.append(tmp);
                else
                    break;
                i++;
            }
            title = builder.toString();
            if (content.length() - i < 300)
                description = content.substring(i + 1, content.length() - i);
            else
                description = content.substring(i + 1, 300);
            blog.setTitle(title);
            blog.setDescription(description);
        }

        return blog;

    }
}
