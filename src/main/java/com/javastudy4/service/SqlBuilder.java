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
        if (libraryName == null && bookGenre == null && bookTitle == null && bookAuthor == null && bookPublisher == null){
            return sql.toString();
        }
        sql.append("where ");
        sql.append("1 = 1");
        if (libraryName != null){
            sql.append(" and library.name = '" + libraryName + "'");
        }
        if (bookGenre != null){
            sql.append(" and book.genre = '" + bookGenre + "'");
        }
        if (bookTitle != null){
            sql.append(" and book.title = '" + bookTitle + "'");
        }
        if (bookAuthor != null){
            sql.append(" and book.author = '" + bookAuthor + "'");
        }
        if (bookPublisher != null){
            sql.append(" and book.publisher = '" + bookPublisher + "'");
        }
        sql.append(";");
        return sql.toString();
    }
    
    public String buildSelectLibraryMaxId() {
        StringBuilder sql = new StringBuilder();
        sql.append("select IFNULL(MAX(id),0) as id from library;");
        return sql.toString();
    }
    public String buildInsertLibrary(int id, String name) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT into library (id, name) values (" + id + ", '" + name + "');");
        return sql.toString();
    }


    
}