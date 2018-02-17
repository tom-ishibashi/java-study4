package com.javastudy4.dao;

import java.util.List;
import java.util.ArrayList;
import java.sql.*;
import com.javastudy4.model.Book;

/**
 * 本テーブルdaoクラス
 */
public class BookDao extends AbstractJdbcDao implements JdbcDao<Book>{
    
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
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        Book book = convertToSingle(rs);
        return book;
    }
    
    /**
     * @see com.javastudy4.dao.JdbcDao#insert
     */
    @Override
    public void insert(String sql) throws SQLException{
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
            // TODO 各カラムの実装
            result.setId(rs.getInt("id"));
        }
        return result;
    }
    
    public void getConnection() throws SQLException{
        super.getConnection();
    }

    public void closeConnection() throws SQLException{
        super.closeConnection();
    }
    
}
