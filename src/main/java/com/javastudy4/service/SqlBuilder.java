package com.javastudy4.service;

public class SqlBuilder {
 
    /**
     * 条件を基に図書館と本を検索するSQLを作成
     * @param libraryName 図書館名
     * @param bookGenre 本のジャンル
     * @param bookTitle 本の題名
     * @param bookAuthor 本の著者
     * @param bookPublisher 本の出版社
     * @return String SQL
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
     * @return String SQL
     */
    public String buildSelectLibraryMaxId() {
        StringBuilder sql = new StringBuilder();
        sql.append("select IFNULL(MAX(id),0) as id from library;");
        return sql.toString();
    }
    
    /**
     * 図書館テーブルにINSERTするSQLを作成
     * @param id 図書館テーブルのid
     * @param name 図書館名
     * @return String SQL
     */
    public String buildInsertLibrary(int id, String name) {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into library (id, name) values (" + id + ", '" + name + "');");
        return sql.toString();
    }
 
    /**
     * 本テーブルIDの最大値を取得するSQLを作成
     * @return String SQL
     */
    public String buildSelectBookMaxId() {
        StringBuilder sql = new StringBuilder();
        sql.append("select IFNULL(MAX(id),0) as id from book;");
        return sql.toString();
    }
    
    /**
     * 本テーブルにINSERTするSQLを作成
     * @param id 本テーブルのid
     * @param title 題名
     * @param genre ジャンル
     * @param author 著者
     * @param publisher 出版社
     * @return String SQL
     */
    public String buildInsertBook(int id,String title,String genre,int price,String author,String publisher) {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into book (id, title, genre, price, author, publisher) values (" + id + ", '" + title + "', '" + genre + "', " + price + ", '" + author + "', '" + publisher + "');");
        return sql.toString();
    }
    
    /**
     * ひも付きテーブルにINSERTするSQLを作成
     * @param libraryId
     * @param bookId
     */
    public String buildInsertLink(int libraryId, int bookId) {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into library_book_link (library_id, book_id) values (" + libraryId + ", " +  bookId + "  );");
        return sql.toString();
    }
    

    
}
