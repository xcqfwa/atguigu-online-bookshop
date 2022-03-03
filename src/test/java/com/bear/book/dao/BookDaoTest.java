package com.bear.book.dao;

import com.bear.book.dao.impl.BookDaoImpl;
import com.bear.book.pojo.Book;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;


/**
 * @author Spring-_-Bear
 * @datetime 2022/3/2 10:04
 */
public class BookDaoTest {
    private final BookDao bookDao = new BookDaoImpl();

    @Test
    public void addBook() {
        int i = bookDao.addBook(new Book(null, "浪潮之巅", "吴军", new BigDecimal("99.99"), 123, 0, null));
        System.out.println(i);
    }

    @Test
    public void deleteBookById() {
        int i = bookDao.deleteBookById(21);
        System.out.println(i);
    }

    @Test
    public void updateBook() {
        int i = bookDao.updateBook(new Book(21, "浪潮之巅", "吴军", new BigDecimal("99.99"), 123, 0, null));
        System.out.println(i);
    }

    @Test
    public void queryBookById() {
        Book book = bookDao.queryBookById(21);
        System.out.println(book);
    }

    @Test
    public void queryAllBooks() {
        List<Book> books = bookDao.queryAllBooks();
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Test
    public void queryBooksTotalCount() {
        int i = bookDao.queryBooksTotalCount();
        System.out.println(i);
    }

    @Test
    public void querySpecifiedBooks() {
        int begin = 5;
        int offset = 5;
        List<Book> books = bookDao.queryPageItems(begin, offset);
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Test
    public void queryBooksCountByPrice() {
        int i = bookDao.queryBooksRecordTotalByPrice(0, 100);
        System.out.println(i);
    }

    @Test
    public void queryPageItemsByPrice() {
        List<Book> books = bookDao.queryPageItemsByPrice(0, 5, 0, 100);
        for (Book book : books) {
            System.out.println(book);
        }
    }
}