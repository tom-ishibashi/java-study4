package com.javastudy4.service;

public class SqlBuilder {
 
    public String buildSelectByCondittion(String libraryName){
        StringBuilder sql = new StringBuilder();
        sql.append("select * from library");
        sql.append(" where name = '" + libraryName + "'");
        return sql.toString();
    }
    
    
    
}