package com.javastudy4.service;

import com.javastudy4.dao.BookDao;
import com.javastudy4.dao.JdbcDao;
import com.javastudy4.model.Book;

import java.sql.SQLException;

public class BookService{
    
    public void insertBook(String title, String genre, int price, String author, String publisher)  throws SQLException{
        SqlBuilder sqlBuilder = new SqlBuilder();
        String selectMaxIdSql = sqlBuilder.buildSelectBookMaxId();

        System.out.println(selectMaxIdSql);

        JdbcDao<Book> jdbcDao = new BookDao();
        Book book = jdbcDao.getSingleResult(selectMaxIdSql);
        String insertSql = sqlBuilder.buildInsertBook(book.getId() + 1, title, genre, price, author, publisher);
        jdbcDao.insert(insertSql);
    }
}