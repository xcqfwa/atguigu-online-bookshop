package com.bear.book.service.impl;

import com.bear.book.dao.BookDao;
import com.bear.book.dao.OrderDao;
import com.bear.book.dao.OrderItemDao;
import com.bear.book.dao.impl.BookDaoImpl;
import com.bear.book.dao.impl.OrderDaoImpl;
import com.bear.book.dao.impl.OrderItemDaoImpl;
import com.bear.book.pojo.*;
import com.bear.book.service.OrderService;

import java.util.Date;
import java.util.Map;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/4 22:54
 */
public class OrderServiceImpl implements OrderService {
    private final OrderDao orderDao = new OrderDaoImpl();
    private final OrderItemDao orderItemDao = new OrderItemDaoImpl();
    private final BookDao bookDao = new BookDaoImpl();

    @Override
    public String createOrder(Cart cart, Integer userId) {
        // 由时间戳和用户 id 生成唯一订单 id 号（解决并发量大时订单号重复问题）
        String orderId = System.currentTimeMillis() + "" + userId;
        Order order = new Order(orderId, new Date(), cart.getTotalPrice(), Order.NOT_SHIPPED, userId);
        if (orderDao.saveOrder(order) == 1) {
            // 遍历购物车对象中的每一个商品项，获取相关信息生成订单项
            for (Map.Entry<Integer, CartItem> entry : cart.getItems().entrySet()) {
                // 获得购物车中的每一个商品项
                CartItem cartItem = entry.getValue();
                // 获取商品项的相关信息生成订单项
                OrderItem orderItem = new OrderItem(null, cartItem.getName(), cartItem.getCount(), cart.getTotalPrice(), cartItem.getTotalPrice(), orderId);
                // 保存订单项信息到数据库
                orderItemDao.saveOrderItem(orderItem);

                // 更新库存和销量
                Book book = bookDao.queryBookById(cartItem.getId());
                book.setSales(book.getSales() + cartItem.getCount());
                book.setStock(book.getStock() - cartItem.getCount());
                bookDao.updateBook(book);
            }
        }
        cart.clear();
        return orderId;
    }
}
