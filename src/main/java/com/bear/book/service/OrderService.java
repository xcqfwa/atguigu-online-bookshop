package com.bear.book.service;

import com.bear.book.pojo.Cart;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/4 22:52
 */
public interface OrderService {
    /**
     * 生成订单信息
     *
     * @param cart 购物车对象
     * @param userId 用户 id
     * @return 订单号
     */
    String createOrder(Cart cart, Integer userId);
}
