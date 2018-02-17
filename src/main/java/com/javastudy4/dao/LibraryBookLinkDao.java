package com.javastudy4.dao;

import com.javastudy4.model.Library;
import java.util.List;
import java.util.ArrayList;
import java.sql.*;
import com.javastudy4.model.Book;


/**
 * 図書館テーブルdaoクラス
 */
public class LibraryBookLinkDao extends AbstractJdbcDao implements JdbcDao<Library>{
    
    /**
     * @see com.javastudy4.dao.JdbcDao#getResultList
     */
    @Override
    public List<Library> getResultList(String sql) throws SQLException{
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        List<Library> library = convertToList(rs);
        return library;
    }
    
    /**
     * @see com.javastudy4.dao.JdbcDao#getSingleResult
     */
    @Override
    public Library getSingleResult(String sql) throws SQLException{
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        Library library = convertToSingle(rs);
        return library;
    }
    
    /**
     * @see com.javastudy4.dao.JdbcDao#insert
     */
    @Override
    public void insert(String sql) throws SQLException{
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
            // TODO 各カラムについても実装
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
