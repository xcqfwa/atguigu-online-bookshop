package com.bear.book.web;

import com.bear.book.pojo.User;
import com.bear.book.service.UserService;
import com.bear.book.service.impl.UserServiceImpl;
import org.omg.CORBA.UnknownUserException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Spring-_-Bear
 * @datetime 2022/2/16 21:30
 */
public class RegisterServlet extends HttpServlet {
    private final UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        // 验证验证码是否正确
        if (!"abcd".equalsIgnoreCase(code)) {
            // 验证码不正确，请求转发：跳转到注册页面
            System.out.println("验证码错误");
            req.getRequestDispatcher("/pages/user/regist.html").forward(req, resp);
            return;
        }

        // 验证用户名存在性
        if (userService.existsUsername(username)) {
            // 用户名已存在不可用
            System.out.println("用户名已存在");
            req.getRequestDispatcher("/pages/user/regist.html").forward(req, resp);
            return;
        }

        // 保存用户信息到数据库
        if (userService.registerUser(new User(null, username, password, email))) {
            System.out.println("用户注册成功");
            // 跳转到注册成功界面
            req.getRequestDispatcher("/pages/user/regist_success.html").forward(req, resp);
        }
    }
}
