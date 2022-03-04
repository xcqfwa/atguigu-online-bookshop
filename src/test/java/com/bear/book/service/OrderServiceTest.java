package com.bear.book.service;

import com.bear.book.pojo.Cart;
import com.bear.book.pojo.CartItem;
import com.bear.book.service.impl.OrderServiceImpl;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/4 23:04
 */
class OrderServiceTest {
    private final OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "java入门到放弃", 2, new BigDecimal("100")));
        cart.addItem(new CartItem(1, "java入门到放弃", 6, new BigDecimal("100")));
        cart.addItem(new CartItem(2, "数据结构", 1, new BigDecimal("200")));

        String order = orderService.createOrder(cart, 1);
        System.out.println("The number of current order:" + order);

    }
}