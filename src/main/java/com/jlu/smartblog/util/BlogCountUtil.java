package com.jlu.smartblog.util;

import com.jlu.smartblog.service.BlogInfoService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.*;
import java.util.List;

/**
 * Created with IDEA
 * author:程杰
 * Date:2018/5/14
 * github:Easoncheng0405
 */
public class BlogCountUtil {

    public BlogCountUtil() {
        throw new RuntimeException("无法实例化");
    }

    public static int getCount() {
        int count = 0;
        try {
            Connection connection = DriverManager.getConnection
                    ("jdbc:mysql://127.0.0.1:3306/blog", "root", "0405");
            Statement statement = connection.createStatement();
            String sql = "select count(*" + ") from blog";
            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.next();
            count = resultSet.getInt(1);
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public static void initPage(@RequestParam(value = "page", defaultValue = "0",
            required = false) int page, int count, List<Integer> pages, int pageSize, BlogInfoService blogInfoService) {
        if (count <= pageSize) {  //总数不超过一页
            pages.add(1);
        } else if (count <= (page+1) * pageSize) {  //当前在最后一页
            if (blogInfoService.findAll(PageRequest.of(page - 2, pageSize,
                    new Sort(Sort.Direction.DESC, "browse"))).size() != 0)
                pages.add(page - 1);//有上上页
            pages.add(page);//数量超过一页并且在尾页，一定有上一页
            pages.add(page + 1);//当前页
        } else if (page == 0) { //在首页
            pages.add(1);//放入首页
            pages.add(2);//一定有下一页 ，因为数量超过了一页
            if (blogInfoService.findAll(PageRequest.of(page + 2, pageSize,
                    new Sort(Sort.Direction.DESC, "browse"))).size() != 0)
                pages.add(3);//有下下页
        } else { //在中间，既有上页也有下页
            pages.add(page);
            pages.add(page + 1);//这是当前页
            pages.add(page + 2);//这是下一页
        }
    }
}
