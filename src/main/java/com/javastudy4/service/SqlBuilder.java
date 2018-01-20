package com.javastudy4.service;

public class SqlBuilder {
 
    /**
     * 条件を元に図書館と本を検索するSQLを作成
     */
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
    
    /**
     * 図書館テーブルIDの最大値を取得するSQLを作成
     */
    public String buildSelectLibraryMaxId() {
        StringBuilder sql = new StringBuilder();
        sql.append("select IFNULL(MAX(id),0) as id from library;");
        return sql.toString();
    }
    
    /**
     * 図書館テーブルにINSERTするSQLを作成
     */
    public String buildInsertLibrary(int id, String name) {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into library (id, name) values (" + id + ", '" + name + "');");
        return sql.toString();
    }
 
    /**
     * 本テーブルIDの最大値を取得するSQLを作成
     */
    public String buildSelectBookMaxId() {
        StringBuilder sql = new StringBuilder();
        sql.append("select IFNULL(MAX(id),0) as id from book;");
        return sql.toString();
    }
    
    /**
     * 本テーブルにINSERTするSQLを作成
     */
    public String buildInsertBook(int id,String title,String genre,int price,String author,String publisher) {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into book (id, title, genre, price, author, publisher) values (" + id + ", '" + title + "', '" + genre + "', " + price + ", '" + author + "', '" + publisher + "');");
        return sql.toString();
    }

    
}