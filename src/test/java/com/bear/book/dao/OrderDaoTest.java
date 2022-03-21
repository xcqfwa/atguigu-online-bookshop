package com.bear.book.dao;

import com.bear.book.dao.impl.OrderDaoImpl;
import com.bear.book.pojo.Order;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/4 22:29
 */
class OrderDaoTest {
    private final OrderDao orderDao = new OrderDaoImpl();

    @Test
    void saveOrder() {
        int i = orderDao.saveOrder(new Order("12345", new Date(), new BigDecimal("222"), Order.NOT_SHIPPED, 1));
        System.out.println(i);
    }
}