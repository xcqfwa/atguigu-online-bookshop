package com.bear.book.web;

import com.bear.book.pojo.Book;
import com.bear.book.pojo.Cart;
import com.bear.book.pojo.CartItem;
import com.bear.book.service.BookService;
import com.bear.book.service.impl.BookServiceImpl;
import com.bear.book.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/4 17:15
 */
public class CartServlet extends BaseServlet {
    private final BookService bookService = new BookServiceImpl();

    /**
     * 添加商品信息到购物车
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     * @throws IOException Exception
     */
    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int bookId = WebUtils.objectToString(req.getParameter("bookId"), 0);
        Book book = bookService.queryBookById(bookId);
        if (book != null) {
            // 创建购物车项
            CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice());
            // 先查看 Session 域中是否存在 Cart 对象，有则使用，无则新建
            Cart cart = (Cart) req.getSession().getAttribute("cart");
            if (cart == null) {
                cart = new Cart();
                req.getSession().setAttribute("cart", cart);
            }
            cart.addItem(cartItem);
            // 最后一次添加的商品的名称
            req.getSession().setAttribute("lastAddName", cartItem.getName());
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    /**
     * 删除商品项
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     * @throws IOException Exception
     */
    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int bookId = WebUtils.objectToString(req.getParameter("bookId"), 0);
        // 从 Session 域中获取购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null) {
            cart.deleteItem(bookId);
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    /**
     * 清空购物车
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     * @throws IOException Exception
     */
    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 从 Session 域中获取购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null) {
            cart.clear();
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    /**
     * 修改购物车中商品项数量
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     * @throws IOException Exception
     */
    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 获取请求的参数
        int bookId = WebUtils.objectToString(req.getParameter("bookId"), 0);
        int newCount = WebUtils.objectToString(req.getParameter("newCount"), 0);
        // 从 Session 域中获取购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null) {
            cart.updateCount(bookId, newCount);
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }
}
