package com.javastudy4.service;

import java.util.List;
import java.util.ArrayList;
import com.javastudy4.model.Library;
import com.javastudy4.dao.LibraryDao;
import java.sql.*;

public class LibraryService{
    
    public List<Library> selectByConndition(String libraryName) throws SQLException{
        SqlBuilder sqlBuilder = new SqlBuilder();
        String sql = sqlBuilder.buildSelectByCondittion(libraryName);
        LibraryDao libraryDao = new LibraryDao();
        return libraryDao.select(sql);
    }
    
}