package com.bear.book.dao.impl;

import com.bear.book.dao.BaseDao;
import com.bear.book.dao.OrderItemDao;
import com.bear.book.pojo.OrderItem;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/4 22:19
 */
public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql = "INSERT INTO `t_order_item`(`name`,`count`,`price`,`total_price`,`order_id`) VALUES (?,?,?,?,?);";
        return update(sql, orderItem.getName(), orderItem.getCount(), orderItem.getPrice(), orderItem.getTotalPrice(), orderItem.getOrderId());
    }
}
