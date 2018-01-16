package com.javastudy4.dao;

import java.sql.SQLException;
import java.util.List;

public interface JdbcDao<T> {
    
    List<T> getResultList(String sql) throws SQLException;
    
    T getSingleResult(String sql) throws SQLException;
    
    void insert(String sql) throws SQLException;

   
}