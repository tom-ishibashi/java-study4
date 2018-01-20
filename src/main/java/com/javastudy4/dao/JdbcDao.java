package com.javastudy4.dao;

import com.javastudy4.model.Library;
import java.util.List;
import java.util.ArrayList;
import java.sql.*;

/**
 * jdbcアクセスインターフェース
 */
public interface JdbcDao<T> {
    /**
     * 複数行の結果を取得する
     * @param sql SELECTのSQL
     * @return List<T> 複数行
     */
    public List<T> getResultList(String sql) throws SQLException;
    
    /**
     * 単一行での結果を取得する
     * @param sql SELECTのSQL
     * @return T 単一行
     */
    public T getSingleResult(String sql) throws SQLException;
    
    /**
     * INSERT処理
     * @param sql INSERTのSQL
     */
    public void insert(String sql) throws SQLException;

   
}
