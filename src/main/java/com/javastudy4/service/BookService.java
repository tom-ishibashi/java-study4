package com.javastudy4.service;

import java.util.List;
import java.util.ArrayList;
import com.javastudy4.model.Book;
import com.javastudy4.dao.*;
import java.sql.*;

/**
 * 本のサービスクラス
 */
public class BookService{
    
    /**
     * 本の登録
     * @param title 題名
     * @param genre ジャンル
     * @param price 価格
     * @param author 著者
     * @param publisher 出版社
     */
    public void insertBook(String title, String genre, int price, String author, String publisher)  throws SQLException{
        SqlBuilder sqlBuilder = new SqlBuilder();
        String selectMaxIdSql = sqlBuilder.buildSelectBookMaxId();
        JdbcDao<Book> jdbcDao = new BookDao();
        jdbcDao.getConnection();
        int id = jdbcDao.getSingleResult(selectMaxIdSql).getId();
        String insertSql = sqlBuilder.buildInsertBook(id + 1, title, genre, price, author, publisher);
        jdbcDao.insert(insertSql);
        jdbcDao.closeConnection();
    }
    /**
     * 本の選択
     */
    public List<Book> selectBook()  throws SQLException{
        String sql = "select * from book;";
        JdbcDao<Book> jdbcDao = new BookDao();
        jdbcDao.getConnection();
        List<Book> results = jdbcDao.getResultList(sql);
        jdbcDao.closeConnection();
        return results;
    }
}
