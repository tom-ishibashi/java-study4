package com.javastudy4.service;

public class LibraryService {
    
    public List<Library> selectByConndition(String libraryName){
        String sql = buildSelectByCondittion(libraryName);
        return new ArrayList();
    }
    
}