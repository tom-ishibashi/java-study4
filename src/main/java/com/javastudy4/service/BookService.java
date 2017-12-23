package com.javastudy4.service;

import java.util.List;
import java.util.ArrayList;
import com.javastudy4.model.Library;
import com.javastudy4.dao.*;
import java.sql.*;

public class BookService{
    
    public void insertBook(String title, String genre, int price, String author, String publisher)  throws SQLException{
        SqlBuilder sqlBuilder = new SqlBuilder();
        String selectMaxIdSql = sqlBuilder.buildSelectBookMaxId();
        JdbcDao jdbcDao = new BookDao();
        // Book book = 
        jdbcDao.getSingleResult(selectMaxIdSql);
        // int id = book.getId();
        // String insertSql = sqlBuilder.buildInsertBook(id + 1, title, genre, price, author, publisher);
        // System.out.println(id);
        // jdbcDao.insert(insertSql);
    }
}