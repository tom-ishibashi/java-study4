package com.javastudy4.dao;

import com.javastudy4.model.Library;
import java.util.List;
import java.util.ArrayList;
import java.sql.*;
import com.javastudy4.model.Book;

public class LibraryDao {
    
    private Connection con;
    
    public List<Library> select(String sql) throws SQLException{
        getConnection();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        return convert(rs);
    }
    
    private List<Library> convert(ResultSet rs) throws SQLException{
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