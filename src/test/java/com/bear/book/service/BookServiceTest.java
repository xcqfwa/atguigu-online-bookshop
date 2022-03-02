package com.bear.book.service;

import com.bear.book.pojo.Book;
import com.bear.book.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;


/**
 * @author Spring-_-Bear
 * @datetime 2022/3/2 10:24
 */
public class BookServiceTest {
    private final BookService bookService = new BookServiceImpl();

    @Test
    public void addBook() {
        int i = bookService.addBook(new Book(null, "浪潮之巅", "吴军", new BigDecimal("99.99"), 123, 0, null));
        System.out.println(i);
    }

    @Test
    public void deleteBookById() {
        int i = bookService.deleteBookById(21);
        System.out.println(i);
    }

    @Test
    public void updateBook() {
        int i = bookService.updateBook(new Book(21, "浪潮之巅", "吴军", new BigDecimal("99.99"), 123, 0, null));
        System.out.println(i);
    }

    @Test
    public void queryBookById() {
        Book book = bookService.queryBookById(20);
        System.out.println(book);
    }

    @Test
    public void queryAllBooks() {
        List<Book> books = bookService.queryAllBooks();
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Test
    public void page() {
        System.out.println(bookService.page(1, 5));
    }
}