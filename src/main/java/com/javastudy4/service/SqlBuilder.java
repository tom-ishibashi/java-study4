package com.javastudy4.service;

public class SqlBuilder {
 
    public String buildSelectByCondittion(String libraryName, String bookGenre, String bookTitle, String bookAuthor, String bookPublisher){
        StringBuilder sql = new StringBuilder();
        sql.append("select");
        sql.append("  library.name,");
        sql.append("  book.genre,");
        sql.append("  book.title,");
        sql.append("  book.author,");
        sql.append("  book.publisher ");
        sql.append("from");
        sql.append("  library library");
        sql.append("  join library_book_link link on library.id = link.library_id ");
        sql.append("  join book book on book.id = link.book_id ");
        sql.append("where ");
        sql.append(" library.name = '" + libraryName + "'");
        sql.append(" and book.genre = '" + bookGenre + "'");
        sql.append(" and book.title = '" + bookTitle + "'");
        sql.append(" and book.author = '" + bookAuthor + "'");
        sql.append(" and book.publisher = '" + bookPublisher + "'");
        sql.append(";");
        return sql.toString();
    }
    
    
    
}