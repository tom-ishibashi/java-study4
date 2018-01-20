package com.javastudy4.dao;

import java.util.List;
import java.util.ArrayList;
import java.sql.*;
import com.javastudy4.model.Book;


public class BookDao implements JdbcDao<Book>{
    
    private Connection con;
    
    @Override
    public List<Book> getResultList(String sql) throws SQLException{
    /*    getConnection();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(sql);*/
        return null;
    }
    
    @Override
    public Book getSingleResult(String sql) throws SQLException{
        getConnection();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        return convertToSingle(rs);
    }
    
    @Override
    public void insert(String sql) throws SQLException{
        getConnection();
        Statement stm = con.createStatement();
        stm.executeUpdate(sql);
    }
    
    private List<Book> convertToList(ResultSet rs) throws SQLException{
        List<Book> result = new ArrayList<>();
        while(rs.next()){
            Book book = new Book();
            book.setId(rs.getInt("id"));
            book.setTitle(rs.getString("title"));
            book.setGenre(rs.getString("genre"));
            book.setAuthor(rs.getString("author"));
            book.setPrice(rs.getInt("price"));
            book.setPublisher(rs.getString("publisher"));
            result.add(book);
        }
        return result;
    }
    
    private Book convertToSingle(ResultSet rs) throws SQLException{
        Book result = new Book();
        while(rs.next()){
            result.setId(rs.getInt("id"));
        }
        return result;
    }
    
    private void getConnection() {
        try {
            // MySQLに接続
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javastudy4", "root", "");
            System.out.println("MySQLに接続できました。");
        } catch (SQLException e) {
            System.out.println("MySQLに接続できませんでした。");
        }
    }
    
}
