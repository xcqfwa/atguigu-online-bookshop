package com.bear.book.dao;

import com.bear.book.pojo.Book;

import java.util.List;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/2 9:45
 */
public interface BookDao {
    /**
     * 添加图书
     *
     * @param book Book
     * @return 添加成功返回 1
     */
    int addBook(Book book);

    /**
     * 通过图书 id 删除图书记录
     *
     * @param id 图书 id
     * @return 删除成功返回 1
     */
    int deleteBookById(Integer id);

    /**
     * 更新图书信息
     *
     * @param book 图书信息
     * @return 更新成功返回 1
     */
    int updateBook(Book book);

    /**
     * 通过图书 id 查询图书信息
     *
     * @param id 图书 id
     * @return Book
     */
    Book queryBookById(Integer id);

    /**
     * 查询所有图书信息
     *
     * @return 图书对象集合
     */
    List<Book> queryAllBooks();
}
