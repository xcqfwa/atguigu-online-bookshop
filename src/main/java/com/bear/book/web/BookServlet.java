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
import java.util.List;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/2 10:32
 */
public class BookServlet extends BaseServlet {
    private final BookService bookService = new BookServiceImpl();

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 获取客户端请求的参数：当前页和每页显示的数量
        int pageNo = WebUtils.stringToInteger(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.stringToInteger(req.getParameter("pageSize"), Page.PAGE_SIZE);
        // 2. 调用 BookService 中的方法获取 Page 对象
        Page<Book> page = bookService.page(pageNo, pageSize);
        // 3. 保存到 Request 域中
        req.setAttribute("page", page);
        // 4. 请求转发到 pages/manager/book_manager.jsp 页面
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doPost(req, resp);
    }

    /**
     * 添加图书信息
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     * @throws IOException exception
     */
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Book book = WebUtils.copyParamsToBean(new Book(), req.getParameterMap());
        if (bookService.addBook(book) == 1) {
            // 请求转发的斜杠 / 表示到 http://ip:port/工程名/
            // 请求重定向的斜杠 / 表示到 http://ip:port/
            resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=list");
        }
    }

    /**
     * 通过图书 id 号删除图书信息
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     * @throws IOException exception
     */
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (bookService.deleteBookById(WebUtils.stringToInteger(req.getParameter("id"), 0)) == 1) {
            resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=list");
        }
    }

    /**
     * 通过图书 id 号更新图书信息
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     * @throws IOException exception
     */
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Book book = WebUtils.copyParamsToBean(new Book(), req.getParameterMap());
        if (bookService.updateBook(book) == 1) {
            // 请求重定向到图书管理页面
            resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=list");
        }
    }

    /**
     * 查询所有图书信息
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     * @throws ServletException exception
     * @throws IOException      exception
     */
    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> books = bookService.queryAllBooks();
        req.setAttribute("books", books);
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }

    /**
     * 通过图书 id 号获取图书信息
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     * @throws ServletException exception
     * @throws IOException      exception
     */
    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = bookService.queryBookById(WebUtils.stringToInteger(req.getParameter("id"), 0));
        req.setAttribute("book", book);
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req, resp);
    }
}
