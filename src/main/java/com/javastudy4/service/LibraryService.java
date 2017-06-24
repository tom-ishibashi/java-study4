package com.javastudy4.service;

import java.util.List;
import java.util.ArrayList;
import com.javastudy4.model.Library;

public class LibraryService {
    
    public List<Library> selectByConndition(String libraryName){
        SqlBuilder sqlBuilder = new SqlBuilder();
        String sql = sqlBuilder.buildSelectByCondittion(libraryName);
        return new ArrayList();
    }
    
}