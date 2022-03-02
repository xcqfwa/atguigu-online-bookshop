package com.bear.book.service.impl;

import com.bear.book.dao.BookDao;
import com.bear.book.dao.impl.BookDaoImpl;
import com.bear.book.pojo.Book;
import com.bear.book.pojo.Page;
import com.bear.book.service.BookService;

import java.util.List;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/2 10:22
 */
public class BookServiceImpl implements BookService {
    private final BookDao bookDao = new BookDaoImpl();

    @Override
    public int addBook(Book book) {
        return bookDao.addBook(book);
    }

    @Override
    public int deleteBookById(Integer id) {
        return bookDao.deleteBookById(id);
    }

    @Override
    public int updateBook(Book book) {
        return bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryAllBooks() {
        return bookDao.queryAllBooks();
    }

    @Override
    public Page<Book> page(int pageNo, int pageSize) {
        Page<Book> page = new Page<>();
        // 设置每页显示的数量
        page.setPageSize(pageSize);
        // 设置图书总记录数
        int recordTotalCount = bookDao.queryBooksTotalCount();
        page.setRecordTotalCount(recordTotalCount);
        // 求解并设置显示的总页码数
        int pageTotal = recordTotalCount / pageSize;
        if (recordTotalCount % pageSize != 0) {
            pageTotal++;
        }
        page.setPageTotal(pageTotal);
        page.setPageNo(pageNo);

        // 获取当前页的数据
        int begin = (page.getPageNo() - 1) * pageSize;
        List<Book> items = bookDao.queryPageItems(begin, pageSize);
        page.setItems(items);
        return page;
    }
}
