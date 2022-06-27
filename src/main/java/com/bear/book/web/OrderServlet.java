package com.bear.book.web;

import com.bear.book.pojo.Cart;
import com.bear.book.pojo.User;
import com.bear.book.service.OrderService;
import com.bear.book.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/4 23:22
 */
public class OrderServlet extends BaseServlet {
    private final OrderService orderService = new OrderServiceImpl();

    /**
     * 生成订单
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     * @throws IOException      exception
     */
    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 从 Session 域中获取购物车对象和用户对象
        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        User loginUser = (User) session.getAttribute("user");
        // 调用 Service 层的方法根据购物车信息和用户 id 生成订单号
        String orderId = orderService.createOrder(cart, loginUser.getId());

        session.setAttribute("orderId", orderId);
        resp.sendRedirect(req.getContextPath() + "/pages/cart/checkout.jsp");
    }
}
