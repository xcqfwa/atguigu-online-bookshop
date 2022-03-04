package com.bear.book.pojo;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/4 16:43
 */
public class CartTest {
    private final Cart cart = new Cart();

    @Test
    void addItem() {
        cart.addItem(new CartItem(1, "java入门到放弃", 2, new BigDecimal("22.22")));
        cart.addItem(new CartItem(1, "java入门到放弃", 6, new BigDecimal("22.22")));
        cart.addItem(new CartItem(2, "数据结构", 10, new BigDecimal("22.22")));
        System.out.println(cart);
    }

    @Test
    void deleteItem() {
        cart.addItem(new CartItem(1, "java入门到放弃", 2, new BigDecimal("22.22")));
        cart.addItem(new CartItem(1, "java入门到放弃", 6, new BigDecimal("22.22")));
        cart.addItem(new CartItem(2, "数据结构", 10, new BigDecimal("22.22")));
        cart.deleteItem(1);
        System.out.println(cart);
    }

    @Test
    void clear() {
        cart.addItem(new CartItem(1, "java入门到放弃", 2, new BigDecimal("22.22")));
        cart.addItem(new CartItem(1, "java入门到放弃", 6, new BigDecimal("22.22")));
        cart.addItem(new CartItem(2, "数据结构", 10, new BigDecimal("22.22")));
        cart.clear();
        System.out.println(cart);
    }

    @Test
    void updateCount() {
        cart.addItem(new CartItem(1, "java入门到放弃", 2, new BigDecimal("100")));
        cart.addItem(new CartItem(1, "java入门到放弃", 6, new BigDecimal("100")));
        cart.addItem(new CartItem(2, "数据结构", 1, new BigDecimal("200")));
        cart.updateCount(1, 0);
        System.out.println(cart);
    }
}