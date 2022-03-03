package com.bear.book.web;

import com.bear.book.pojo.Book;
import com.bear.book.pojo.Page;
import com.bear.book.service.BookService;
import com.bear.book.service.impl.BookServiceImpl;
import com.bear.book.util.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/3 18:32
 */
public class ClientBookServlet extends BaseServlet {
    private final BookService bookService = new BookServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doPost(req, resp);
    }

//    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        // 1. 获取客户端请求的参数：当前页和每页显示的数量
//        int pageNo = WebUtils.objectToString(req.getParameter("pageNo"), 1);
//        int pageSize = WebUtils.objectToString(req.getParameter("pageSize"), Page.PAGE_SIZE);
//        // 2. 调用 BookService 中的方法获取 Page 对象
//        Page<Book> page = bookService.page(pageNo, pageSize);
//        // 3. 保存到 Request 域中
//        req.setAttribute("page", page);
//        // 设置请求的地址为前台
//        page.setUrl("client/bookServlet?action=page");
//        // 4. 请求转发到 /pages/client/index.jsp 页面
//        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
//    }

    /**
     * 通过价格区间获取图书数据设置分页信息
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     * @throws ServletException exception
     * @throws IOException      exception
     */
    protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 获取客户端请求的参数：当前页和每页显示的数量
        int pageNo = WebUtils.objectToString(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.objectToString(req.getParameter("pageSize"), Page.PAGE_SIZE);
        int minPrice = WebUtils.objectToString(req.getParameter("min"), 0);
        int maxPrice = WebUtils.objectToString(req.getParameter("max"), Integer.MAX_VALUE);

        // 检查价格区间参数
        if (minPrice < 0) {
            minPrice = 0;
        }
        if (maxPrice < 0) {
            maxPrice = Integer.MAX_VALUE;
        }
        if (minPrice > maxPrice) {
            int temp = minPrice;
            minPrice = maxPrice;
            maxPrice = temp;
        }
        // 2. 调用 BookService 中的方法获取 Page 对象
        Page<Book> page = bookService.pageByPrice(pageNo, pageSize, minPrice, maxPrice);
        // 3. 保存到 Request 域中
        req.setAttribute("page", page);
        // 设置请求的地址为前台
        StringBuilder stringBuilder = new StringBuilder("client/bookServlet?action=pageByPrice");
        // 如果请求参数中存在最小价格参数，追加到分页条的请求地址参数中
        if (req.getParameter("min") != null) {
            stringBuilder.append("&min=").append(req.getParameter("min"));
        }// 如果请求参数中存在最大价格参数，追加到分页条的请求地址参数中
        if (req.getParameter("max") != null) {
            stringBuilder.append("&max=").append(req.getParameter("max"));
        }
        page.setUrl(stringBuilder.toString());
        // 4. 请求转发到 /pages/client/index.jsp 页面
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
    }
}
