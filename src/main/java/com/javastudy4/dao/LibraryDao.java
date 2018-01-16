package com.javastudy4.dao;

import com.javastudy4.model.Book;
import com.javastudy4.model.Library;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class LibraryDao implements JdbcDao<Library>{
    
    private Connection con;
    
    @Override
    public List<Library> getResultList(String sql) throws SQLException{
        getConnection();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        return convertToList(rs);
    }
    
    @Override
    public Library getSingleResult(String sql) throws SQLException{
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
    
    private List<Library> convertToList(ResultSet rs) throws SQLException{
        List<Library> result = new ArrayList<>();
        while(rs.next()){
            List<Book> books = new ArrayList<>();
            Library library = new Library();
            Book book = new Book();
            library.setName(rs.getString("name"));
            book.setGenre(rs.getString("genre"));
            book.setTitle(rs.getString("title"));
            book.setAuthor(rs.getString("author"));
            book.setPublisher(rs.getString("publisher"));
            books.add(book);
            library.setBooks(books);
            result.add(library);
        }
        return result;
    }
    
    private Library convertToSingle(ResultSet rs) throws SQLException{
        Library result = new Library();
        while(rs.next()){
            result.setId(rs.getInt("id"));
        }
        return result;
    }
    
    private void getConnection() {
        try {
            // MySQLに接続
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javastudy4", "root", "1QAZ2wsx##");
            System.out.println("MySQLに接続できました。");
        } catch (SQLException e) {
            System.out.println("MySQLに接続できませんでした。");
        }
    }
    
}