package com.bear.book.dao;

import com.bear.book.pojo.Order;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/4 22:16
 */
public interface OrderDao {
    /**
     * 保存订单
     *
     * @param order 订单
     * @return 1 - 订单保存成功
     */
    int saveOrder(Order order);
}
