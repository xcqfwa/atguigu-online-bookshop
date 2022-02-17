package com.bear.book.web;

import com.bear.book.pojo.User;
import com.bear.book.service.UserService;
import com.bear.book.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Spring-_-Bear
 * @datetime 2022/2/17 20:19
 */
public class LoginServlet extends HttpServlet {
    private final UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // 判断用户名密码是否存在
        if (!userService.loginUser(username, password)) {
            System.out.println("用户名或密码错误");
            req.getRequestDispatcher("/pages/user/login.html").forward(req, resp);
            return;
        }

        req.getRequestDispatcher("/pages/user/login_success.html").forward(req, resp);
    }
}
