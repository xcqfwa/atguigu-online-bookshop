package com.bear.book.web;

import com.bear.book.pojo.User;
import com.bear.book.service.UserService;
import com.bear.book.service.impl.UserServiceImpl;
import com.bear.book.util.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/1 19:47
 */
public class UserServlet extends BaseServlet {
    private final UserService userService = new UserServiceImpl();

    /**
     * 用户注册
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     * @throws ServletException none
     * @throws IOException      none
     */
    protected void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        User user = WebUtils.copyParamsToBean(new User(), req.getParameterMap());

        // 获取请求的参数
        String username = user.getUsername();
        String password = user.getPassword();
        String email = user.getEmail();
        String code = req.getParameter("code");
        String verifyCode = "bear";

        // 验证验证码是否正确
        if (!verifyCode.equalsIgnoreCase(code)) {
            // 验证码不正确，请求转发：跳转到注册页面
            req.setAttribute("msg", "验证码错误");
            req.setAttribute("username", username);
            req.setAttribute("email", email);
            req.getRequestDispatcher("/pages/user/register.jsp").forward(req, resp);
            return;
        }

        // 验证用户名存在性
        if (userService.existsUsername(username)) {
            // 用户名已存在不可用
            req.setAttribute("msg", "用户名已存在");
            req.setAttribute("username", username);
            req.setAttribute("email", email);
            req.getRequestDispatcher("/pages/user/register.jsp").forward(req, resp);
            return;
        }

        // 保存用户信息到数据库
        if (userService.registerUser(new User(null, username, password, email))) {
            // 跳转到注册成功界面
            req.getRequestDispatcher("/pages/user/register_success.jsp").forward(req, resp);
        }
    }

    /**
     * 用户登录
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     * @throws ServletException none
     * @throws IOException      none
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = WebUtils.copyParamsToBean(new User(), req.getParameterMap());

        // 判断用户名密码是否正确
        if (!userService.loginUser(user.getUsername(), user.getPassword())) {
            req.setAttribute("msg", "用户名或密码错误");
            req.setAttribute("username", user.getUsername());
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
            return;
        }

        req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
    }
}