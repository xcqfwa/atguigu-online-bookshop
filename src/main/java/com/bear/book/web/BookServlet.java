package com.bear.book.web;

import com.bear.book.pojo.Book;
import com.bear.book.service.BookService;
import com.bear.book.service.impl.BookServiceImpl;
import com.bear.book.util.BeanUtils;

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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doPost(req, resp);
    }

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Book book = BeanUtils.copyParamsToBean(new Book(), req.getParameterMap());
        if (bookService.addBook(book) == 1) {
            // 请求转发的斜杠 / 表示到 http://ip:port/工程名/
            // 请求重定向的斜杠 / 表示到 http://ip:port/
            resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=list");
        }
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        if (bookService.deleteBookById(Integer.parseInt(id)) == 1) {
            resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=list");
        }
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Book book = BeanUtils.copyParamsToBean(new Book(), req.getParameterMap());
        if (bookService.updateBook(book) == 1) {
            // 请求重定向到图书管理页面
            resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=list");
        }
    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> books = bookService.queryAllBooks();
        req.setAttribute("books", books);
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }

    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Book book = bookService.queryBookById(Integer.parseInt(id));
        req.setAttribute("book", book);
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req, resp);
    }
}
