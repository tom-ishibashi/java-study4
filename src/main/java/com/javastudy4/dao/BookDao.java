package com.javastudy4.dao;

import java.util.List;
import java.util.ArrayList;
import java.sql.*;
import com.javastudy4.model.Book;

/**
 * 本テーブルdaoクラス
 */
public class BookDao implements JdbcDao<Book>{
    
    private Connection con;
    
    /**
     * @see com.javastudy4.dao.JdbcDao#getResultList
     */
    @Override
    public List<Book> getResultList(String sql) throws SQLException{
    /*    getConnection();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(sql);*/
        return null;
    }
    
    /**
     * @see com.javastudy4.dao.JdbcDao#getSingleResult
     */
    @Override
    public Book getSingleResult(String sql) throws SQLException{
        getConnection();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        Book book = convertToSingle(rs);
        closeConnection();
        return book;
    }
    
    /**
     * @see com.javastudy4.dao.JdbcDao#insert
     */
    @Override
    public void insert(String sql) throws SQLException{
        getConnection();
        Statement stm = con.createStatement();
        stm.executeUpdate(sql);
        closeConnection();
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
            // TODO 各カラムの実装
            result.setId(rs.getInt("id"));
        }
        return result;
    }
    
    private void getConnection() {
        try {
            // MySQLに接続
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javastudy4", "root", "");
        } catch (SQLException e) {
            System.out.println("MySQLに接続できませんでした。");
        }
    }

    private void closeConnection() {
        try {
            // MySQL切断
            con.close();
        } catch (SQLException e) {
            System.out.println("MySQLを切断できませんでした。");
        }
    }
    
}
