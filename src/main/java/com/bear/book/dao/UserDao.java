package com.bear.book.dao;

import com.bear.book.pojo.User;

/**
 * @author Spring-_-Bear
 * @datetime 2022/2/16 8:44
 */
public interface UserDao {
    /**
     * 根据用户名查询用户信息
     *
     * @param username 用户名
     * @return User or null
     */
    User queryUserByUsername(String username);

    /**
     * 根据用户名和密码查询用户信息
     *
     * @param username 用户名
     * @param password 密码
     * @return User or null
     */
    User queryUserByUsernameAndPassword(String username, String password);

    /**
     * 保存用户信息
     *
     * @param user User
     * @return -1 表示保存失败，其它表示保存成功
     */
    int saveUser(User user);
}
