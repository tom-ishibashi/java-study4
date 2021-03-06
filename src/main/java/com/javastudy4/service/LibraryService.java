package com.javastudy4.service;

import java.util.List;
import java.util.ArrayList;
import com.javastudy4.model.Library;
import com.javastudy4.dao.*;
import java.sql.*;

/**
 * 図書館のサービスクラス
 */
public class LibraryService{
    
    /**
     * 検索条件を基に検索する
     * @param libraryName 図書館名
     * @param bookGenre 本のジャンル
     * @param bookTitle 本の題名
     * @param bookAuthor 本の著者
     * @param bookPublisher 本の出版社
     * @return List<Library> 検索結果
     */
    public List<Library> selectByCondition(String libraryName, String bookGenre, String bookTitle, String bookAuthor, String bookPublisher) throws SQLException{
        SqlBuilder sqlBuilder = new SqlBuilder();
        String sql = sqlBuilder.buildSelectByCondittion(libraryName, bookGenre, bookTitle, bookAuthor, bookPublisher);
        JdbcDao<Library> jdbcDao = new LibraryBookLinkDao();
        jdbcDao.getConnection();
        List<Library> results = jdbcDao.getResultList(sql);
        jdbcDao.closeConnection();
        return results;
    }
    
    /**
     * 図書館の登録
     * @param name 図書館名
     */
    public void insertLibrary(String name)  throws SQLException{
        SqlBuilder sqlBuilder = new SqlBuilder();
        String selectMaxIdSql = sqlBuilder.buildSelectLibraryMaxId();
        JdbcDao<Library> jdbcDao = new LibraryDao();
        jdbcDao.getConnection();
        int id = jdbcDao.getSingleResult(selectMaxIdSql).getId();
        String insertSql = sqlBuilder.buildInsertLibrary(id + 1, name);
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
