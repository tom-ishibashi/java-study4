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
        // return null;
    }
    
    @Override
    public void insert(String sql) throws SQLException{
        getConnection();
        Statement stm = con.createStatement();
        stm.executeUpdate(sql);
    }
    
/*    private List<Library> convertToList(ResultSet rs) throws SQLException{
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
*/    
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