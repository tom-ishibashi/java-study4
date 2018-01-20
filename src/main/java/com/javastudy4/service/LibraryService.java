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
     * @parm libraryName 図書館名
     * @parm bookGenre 本のジャンル
     * @parm bookTitle 本の題名
     * @parm bookAuthor 本の著者
     * @parm bookpublisher 本の出版社
     * @return List<Library> 検索結果
     */
    public List<Library> selectByConndition(String libraryName, String bookGenre, String bookTitle, String bookAuthor, String bookPublisher) throws SQLException{
        SqlBuilder sqlBuilder = new SqlBuilder();
        String sql = sqlBuilder.buildSelectByCondittion(libraryName, bookGenre, bookTitle, bookAuthor, bookPublisher);
        JdbcDao<Library> jdbcDao = new LibraryDao();
        return jdbcDao.getResultList(sql);
    }
    
    /**
     * 図書館の登録
     * @param name 図書館名
     */
    public void insertLibrary(String name)  throws SQLException{
        SqlBuilder sqlBuilder = new SqlBuilder();
        String selectMaxIdSql = sqlBuilder.buildSelectLibraryMaxId();
        JdbcDao<Library> jdbcDao = new LibraryDao();
        int id = jdbcDao.getSingleResult(selectMaxIdSql).getId();
        String insertSql = sqlBuilder.buildInsertLibrary(id + 1, name);
        jdbcDao.insert(insertSql);
    }
}
