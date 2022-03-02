package com.bear.book.service;

import com.bear.book.pojo.Book;
import com.bear.book.pojo.Page;

import java.util.List;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/2 10:22
 */
public interface BookService {
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

    /**
     * 根据当前页码号和当前页显示数据个数获得 Page 对象
     *
     * @param pageNo   当前页码
     * @param pageSize 每页显示的个数
     * @return Page<Book>
     */
    Page<Book> page(int pageNo, int pageSize);
}
