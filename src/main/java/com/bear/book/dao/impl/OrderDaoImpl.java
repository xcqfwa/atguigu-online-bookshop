package com.bear.book.dao.impl;

import com.bear.book.dao.BaseDao;
import com.bear.book.pojo.Order;
import com.bear.book.dao.OrderDao;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/4 22:18
 */
public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public int saveOrder(Order order) {
        String sql = "INSERT INTO `t_order`(`order_id`,`create_time`,`price`,`status`,`user_id`) VALUES (?,?,?,?,?);";
        return update(sql, order.getOrderId(), order.getCreateTime(), order.getPrice(), order.getStatus(), order.getUserId());
    }
}
