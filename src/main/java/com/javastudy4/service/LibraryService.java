package com.javastudy4.service;

import com.javastudy4.dao.JdbcDao;
import com.javastudy4.dao.LibraryDao;
import com.javastudy4.model.Library;

import java.sql.SQLException;
import java.util.List;

public class LibraryService{
    
    public List<Library> selectByConndition(String libraryName, String bookGenre, String bookTitle, String bookAuthor, String bookPublisher) throws SQLException{
        SqlBuilder sqlBuilder = new SqlBuilder();
        String sql = sqlBuilder.buildSelectByCondittion(libraryName, bookGenre, bookTitle, bookAuthor, bookPublisher);
        JdbcDao jdbcDao = new LibraryDao();
        return jdbcDao.getResultList(sql);
    }
    
    public void insertLibrary(String name)  throws SQLException{
        SqlBuilder sqlBuilder = new SqlBuilder();
        String selectMaxIdSql = sqlBuilder.buildSelectLibraryMaxId();

        System.out.println(selectMaxIdSql);

        JdbcDao<Library> jdbcDao = new LibraryDao();
        Library library = jdbcDao.getSingleResult(selectMaxIdSql);
        String insertSql = sqlBuilder.buildInsertLibrary(library.getId() + 1, name);
        jdbcDao.insert(insertSql);
    }
}