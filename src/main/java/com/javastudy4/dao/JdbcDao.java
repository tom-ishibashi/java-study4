package com.javastudy4.dao;

import com.javastudy4.model.Library;
import java.util.List;
import java.util.ArrayList;
import java.sql.*;

public interface JdbcDao<T> {
    
    public List<T> getResultList(String sql) throws SQLException;
    
    public <T> T getSingleResult(String sql) throws SQLException;
    
    public void insert(String sql) throws SQLException;

   
}