package com.bear.book.dao.impl;

import com.bear.book.dao.BaseDao;
import com.bear.book.dao.BookDao;
import com.bear.book.pojo.Book;
import com.bear.book.util.WebUtils;

import java.util.List;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/2 9:48
 */
public class BookDaoImpl extends BaseDao implements BookDao {
    @Override
    public int addBook(Book book) {
        String sql = "INSERT INTO `t_book`(`name`, `author`, `price`, `sales`, `stock`, `img_path`) VALUES (?,?,?,?,?,?);";
        return update(sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath());
    }

    @Override
    public int deleteBookById(Integer id) {
        String sql = "DELETE FROM `t_book` WHERE id = ?;";
        return update(sql, id);
    }

    @Override
    public int updateBook(Book book) {
        String sql = "UPDATE `t_book` SET `name`=?, `author`=?, `price`=?, `sales`=?, `stock`=?,  `img_path`=? WHERE `id` = ?;";
        return update(sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath(), book.getId());
    }


    @Override
    public Book queryBookById(Integer id) {
        String sql = "SELECT `id`, `name`, `author`, `price`, `sales`, `stock`,  `img_path` `imgPath` FROM `t_book` WHERE id = ?;";
        return queryForOne(Book.class, sql, id);
    }

    @Override
    public List<Book> queryAllBooks() {
        String sql = "SELECT `id`, `name`, `author`, `price`, `sales`, `stock`,  `img_path` `imgPath` FROM `t_book`;";
        return queryForList(Book.class, sql);
    }

    @Override
    public int queryBooksTotalCount() {
        String sql = "SELECT COUNT(*) FROM `t_book`;";
        Object o = queryForSingleValue(sql);
        return WebUtils.objectToString(o.toString(), 0);
    }

    @Override
    public List<Book> queryPageItems(int begin, int offset) {
        String sql = "SELECT `id`, `name`, `author`, `price`, `sales`, `stock`,  `img_path` `imgPath` FROM `t_book` LIMIT ?,?;";
        return queryForList(Book.class, sql, begin, offset);
    }

    @Override
    public int queryBooksRecordTotalByPrice(int minPrice, int maxPrice) {
        String sql = "SELECT COUNT(*) FROM `t_book` WHERE `price` BETWEEN ? AND ?;";
        Object o = queryForSingleValue(sql, minPrice, maxPrice);
        return WebUtils.objectToString(o, 0);
    }

    @Override
    public List<Book> queryPageItemsByPrice(int begin, int offset, int minPrice, int maxPrice) {
        String sql = "SELECT `id`, `name`, `author`, `price`, `sales`, `stock`,  `img_path` `imgPath` FROM `t_book` WHERE `price` BETWEEN ? AND ? ORDER BY `price` LIMIT ?,? ;";
        return queryForList(Book.class, sql, minPrice, maxPrice, begin, offset);
    }
}
