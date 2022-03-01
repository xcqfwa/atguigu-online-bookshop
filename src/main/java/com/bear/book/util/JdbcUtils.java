package com.bear.book.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Spring-_-Bear
 * @datetime 2022/2/15 22:40
 */
public class JdbcUtils {
    static DataSource dataSource;

    // Read the config info from config file
    static {
        Properties properties = new Properties();
        try {
            InputStream resourceAsStream = JdbcUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            properties.load(resourceAsStream);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Get a database connection from the pool
     *
     * @return Connection
     * @throws SQLException Something goes wrong, throws the exception
     */
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    /**
     * Close the connection and release resources
     *
     * @param connection Connection
     */
    public static void close(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

