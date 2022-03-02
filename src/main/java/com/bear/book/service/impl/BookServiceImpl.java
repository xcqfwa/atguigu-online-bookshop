package com.bear.book.service.impl;

import com.bear.book.dao.BookDao;
import com.bear.book.dao.impl.BookDaoImpl;
import com.bear.book.pojo.Book;
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
}
