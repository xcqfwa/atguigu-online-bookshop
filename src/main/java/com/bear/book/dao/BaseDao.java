package com.bear.book.dao;

import com.bear.book.util.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Spring-_-Bear
 * @datetime 2022/2/15 22:47
 */
public abstract class BaseDao {
    private final QueryRunner queryRunner = new QueryRunner();

    /**
     * 执行 insert、update、delete 语句
     *
     * @param sql  sql
     * @param args sql 实参
     * @return 执行语句受影响的行数
     */
    public int update(String sql, Object... args) {
        Connection connection = null;
        try {
            connection = JdbcUtils.getConnection();
            return queryRunner.update(connection, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }
        return -1;
    }

    /**
     * 查询数据库表的一条记录
     *
     * @param clazz JavaBean class 对象
     * @param sql   sql
     * @param args  sql 实参
     * @param <T>   返回类型泛型
     * @return 一条记录
     */
    public <T> T queryForOne(Class<T> clazz, String sql, Object... args) {
        Connection connection = null;
        try {
            connection = JdbcUtils.getConnection();
            return queryRunner.query(connection, sql, new BeanHandler<>(clazz), args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }
        return null;
    }

    /**
     * 查询返回多条数据库表记录
     *
     * @param clazz JavaBean 的 class 对象
     * @param sql   sql
     * @param args  sql 实参
     * @param <T>   返回类型的泛型
     * @return 多条记录
     */
    public <T> List<T> queryForList(Class<T> clazz, String sql, Object... args) {
        Connection connection = null;
        try {
            connection = JdbcUtils.getConnection();
            return queryRunner.query(connection, sql, new BeanListHandler<>(clazz), args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }
        return null;
    }

    /**
     * 查询返回单元格数据
     *
     * @param sql  sql
     * @param args sql 实参
     * @return 某个单元格对象
     */
    public Object queryForSingleValue(String sql, Object... args) {
        Connection connection = null;
        try {
            connection = JdbcUtils.getConnection();
            return queryRunner.query(connection, sql, new ScalarHandler(), args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }
        return null;
    }
}
