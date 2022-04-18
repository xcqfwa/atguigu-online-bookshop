package com.bear.book.dao;

import com.bear.book.dao.impl.UserDaoImpl;
import com.bear.book.pojo.User;
import org.junit.Test;

/**
 * @author Spring-_-Bear
 * @datetime 2022/2/16 9:02
 */
public class UserDaoTest {
    UserDao userDao = new UserDaoImpl();

    @Test
    public void queryUserByUsername() {
        String username = "admin";
        User user = userDao.queryUserByUsername(username);
        if (user != null) {
            System.out.println(user);
        } else {
            System.out.println("用户信息不存在");
        }
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        String username = "admin";
        String password = "admin";
        User user = userDao.queryUserByUsernameAndPassword(username, password);
        if (user != null) {
            System.out.println(user);
        } else {
            System.out.println("用户信息不存在");
        }
    }

    @Test
    public void saveUser() {
        User user = new User(null, "admin", "admin", "admin@admin.com");
        int res = userDao.saveUser(user);
        if (res == 1) {
            System.out.println("用户信息保存成功");
        } else {
            System.out.println("用户信息保存失败");
        }
    }
}