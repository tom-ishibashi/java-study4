package com.javastudy4.service;

import java.util.List;
import java.util.ArrayList;
import com.javastudy4.model.Library;
import com.javastudy4.dao.*;
import java.sql.*;

/**
 * ひも付きのサービスクラス
 */
public class LinkService{
    
    /**
     * ひも付きの登録
     * @param libraryId
     * @param bookId
     */
    public void insertLink(int libraryId, int bookId)  throws SQLException{
        SqlBuilder sqlBuilder = new SqlBuilder();
        JdbcDao<Library> jdbcDao = new LibraryBookLinkDao();
        jdbcDao.getConnection();
        String insertSql = sqlBuilder.buildInsertLink(libraryId, bookId);
        jdbcDao.insert(insertSql);
        jdbcDao.closeConnection();
    }
    
    /**
     * 図書館テーブルの選択
     */
    public List<Library> selectLibrary() throws SQLException{
        String sql = "select * from library;";
        JdbcDao<Library> jdbcDao = new LibraryDao();
        jdbcDao.getConnection();
        List<Library> results = jdbcDao.getResultList(sql);
        jdbcDao.closeConnection();
        return results;
    }

}
