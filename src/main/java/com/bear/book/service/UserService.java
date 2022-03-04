package com.bear.book.service;

import com.bear.book.pojo.User;

/**
 * @author Spring-_-Bear
 * @datetime 2022/2/16 19:52
 */
public interface UserService {
    /**
     * 用户登录
     *
     * @param username 用户名
     * @param password 密码
     * @return 登录成功的 User 信息或 null
     */
    User loginUser(String username, String password);

    /**
     * 用户注册，保存用户信息到数据库
     *
     * @param user User
     * @return true - 用户注册成功
     */
    boolean registerUser(User user);

    /**
     * 验证用户名存在性
     *
     * @param username 用户名
     * @return true - 用户名已存在
     */
    boolean existsUsername(String username);
}
