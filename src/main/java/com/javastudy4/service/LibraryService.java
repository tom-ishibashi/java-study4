package com.javastudy4.service;

import java.util.List;
import java.util.ArrayList;
import com.javastudy4.model.Library;
import com.javastudy4.dao.LibraryDao;
import java.sql.*;

public class LibraryService{
    
    public List<Library> selectByConndition(String libraryName, String bookGenre, String bookTitle, String bookAuthor, String bookPublisher) throws SQLException{
        SqlBuilder sqlBuilder = new SqlBuilder();
        String sql = sqlBuilder.buildSelectByCondittion(libraryName, bookGenre, bookTitle, bookAuthor, bookPublisher);
        LibraryDao libraryDao = new LibraryDao();
        return libraryDao.getResultList(sql);
    }
    
    public void insertLibrary(String name)  throws SQLException{
        SqlBuilder sqlBuilder = new SqlBuilder();
        String selectMaxIdSql = sqlBuilder.buildSelectLibraryMaxId();
        LibraryDao libraryDao = new LibraryDao();
        int id = libraryDao.getSingleResult(selectMaxIdSql).getId();
        String insertSql = sqlBuilder.buildInsertLibrary(id + 1, name);
        libraryDao.insert(insertSql);
    }
}