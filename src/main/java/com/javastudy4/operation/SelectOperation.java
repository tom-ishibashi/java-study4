package com.javastudy4.operation;

import com.javastudy4.model.Library;
import com.javastudy4.model.Book;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class SelectOperation {
    public void search(){
        
        Scanner sc = new Scanner(System.in);
        String libraryName;
        String bookGenre;
        String bookTitle;
        String bookAuthor;
        String bookPublisher;
        
        System.out.println("検索条件を入力してください。");
        System.out.print("図書館:");
        libraryName = sc.next();
        System.out.print("本 ジャンル:");
        bookGenre = sc.next();
        System.out.print("本 タイトル:");
        bookTitle = sc.next();
        System.out.print("本 著者名:");
        bookAuthor = sc.next();
        System.out.print("本 出版社:");
        bookPublisher = sc.next();
        
        // TODO ダミーです。DAOの呼び出しを追加する。
        Library dummyLibrary = createDummyData();
        
        System.out.println("図書館/ジャンル/本タイトル/本著者/出版社");
        Book book = dummyLibrary.getBooks().get(0);
        System.out.println(String.join("/", dummyLibrary.getName(), book.getGenre(), book.getTitle(), book.getAuthor(), book.getPublisher()));;
        
    }
    
    private Library createDummyData(){
        Book book = new Book();
        book.setId(100);
        book.setTitle("サルでもデキるjava");
        List<Book> list = new ArrayList<>();
        list.add(book);
        Library library = new Library();
        library.setBooks(list);
        library.setId(1000);
        library.setName("赤羽図書館");
        return library;
    }
}