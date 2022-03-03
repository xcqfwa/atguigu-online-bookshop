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

    /**
     * 查询图书总记录数
     *
     * @return 图书记录总数
     */
    int queryBooksTotalCount();

    /**
     * 查询指定位置和偏移量的图书记录
     *
     * @param begin  指定位置
     * @param offset 偏移量
     * @return 指定范围的图书记录
     */
    List<Book> queryPageItems(int begin, int offset);

    /**
     * 根据图书价格区间查询图书总记录数
     *
     * @param minPrice 最低价格
     * @param maxPrice 最高价格
     * @return 符合要求的图书记录数量
     */
    int queryBooksRecordTotalByPrice(int minPrice, int maxPrice);

    /**
     * 查询指定起始位置、偏移量以及价格区间的图书记录
     *
     * @param begin    起始位置
     * @param offset   偏移量
     * @param minPrice 最低价格
     * @param maxPrice 最高价格
     * @return 符合要求的图书记录
     */
    List<Book> queryPageItemsByPrice(int begin, int offset, int minPrice, int maxPrice);
}
