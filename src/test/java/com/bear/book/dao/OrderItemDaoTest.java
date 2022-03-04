package com.bear.book.dao;

import com.bear.book.dao.impl.OrderItemDaoImpl;
import com.bear.book.pojo.OrderItem;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/4 22:31
 */
class OrderItemDaoTest {
    private final OrderItemDao orderItemDao = new OrderItemDaoImpl();

    @Test
    void saveOrderItem() {
        int i = orderItemDao.saveOrderItem(new OrderItem(1, "java从入门到放弃", 1, new BigDecimal("333"), new BigDecimal("3333"), "12345"));
        System.out.println(i);
    }
}