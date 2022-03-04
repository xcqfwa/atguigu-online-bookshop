package com.bear.book.web;

import com.bear.book.pojo.User;
import com.bear.book.service.UserService;
import com.bear.book.service.impl.UserServiceImpl;
import com.bear.book.util.WebUtils;
import com.google.code.kaptcha.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/1 19:47
 */
public class UserServlet extends BaseServlet {
    private final UserService userService = new UserServiceImpl();

    /**
     * 用户注册，跳转到主页
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     * @throws IOException exception
     */
    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 销毁 Session 对象
        HttpSession session = req.getSession();
        session.invalidate();
        // 请求重定向到主页
        resp.sendRedirect("index.jsp");
    }

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

        // 获取谷歌生成的验证码
        HttpSession session = req.getSession();
        Object verifyCode = session.getAttribute(Constants.KAPTCHA_SESSION_KEY);

        // 获取请求的参数
        String username = user.getUsername();
        String password = user.getPassword();
        String email = user.getEmail();
        String code = req.getParameter("code");

        // 验证验证码是否正确
        if (verifyCode == null || !verifyCode.toString().equalsIgnoreCase(code)) {
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
            session.setAttribute("user", user);
            // 跳转到注册成功界面
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
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

        HttpSession session = req.getSession();
        session.setAttribute("user", user);
        req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
    }
}