package com.bear.book.dao;

import com.bear.book.pojo.OrderItem;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/4 22:17
 */
public interface OrderItemDao {
    /**
     * 保存订单项（订单详情信息）
     *
     * @param orderItem 订单项
     * @return 1 - 保存成功
     */
    int saveOrderItem(OrderItem orderItem);
}
