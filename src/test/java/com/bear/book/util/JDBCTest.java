package com.bear.book.util;

import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Spring-_-Bear
 * @datetime 2022/2/15 22:37
 */
public class JDBCTest {
    @Test
    public void jdbcTest() throws SQLException {
        for (int i = 1; i <= 10; i++) {
            Connection connection = JdbcUtils.getConnection();
            System.out.println(connection);
            JdbcUtils.close(connection);
        }
    }
}
