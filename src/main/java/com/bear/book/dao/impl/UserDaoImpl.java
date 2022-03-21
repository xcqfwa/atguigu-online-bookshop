package com.bear.book.dao.impl;

import com.bear.book.dao.BaseDao;
import com.bear.book.dao.UserDao;
import com.bear.book.pojo.User;

/**
 * @author Spring-_-Bear
 * @datetime 2022/2/16 8:53
 */
public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User queryUserByUsername(String username) {
        String sql = "SELECT * FROM t_user WHERE username = ?";
        return queryForOne(User.class, sql, username);
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "SELECT * FROM `t_user` WHERE `username` = ? AND `password` = ?;";
        return queryForOne(User.class, sql, username, password);
    }

    @Override
    public int saveUser(User user) {
        String sql = "INSERT INTO `t_user`(`username`,`password`,`email`) VALUES (?,?,?);";
        return update(sql, user.getUsername(), user.getPassword(), user.getEmail());
    }
}
