package com.bear.book.service.impl;

import com.bear.book.dao.UserDao;
import com.bear.book.dao.impl.UserDaoImpl;
import com.bear.book.pojo.User;
import com.bear.book.service.UserService;

/**
 * @author Spring-_-Bear
 * @datetime 2022/2/16 19:57
 */
public class UserServiceImpl implements UserService {
    private final UserDao userDao = new UserDaoImpl();

    @Override
    public boolean loginUser(String username, String password) {
        if (userDao.queryUserByUsernameAndPassword(username, password) != null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean registerUser(User user) {
        if (userDao.saveUser(user) == 1) {
            return true;
        }
        return false;
    }

    @Override
    public boolean existsUsername(String username) {
        if (userDao.queryUserByUsername(username) != null) {
            return true;
        }
        return false;
    }
}
