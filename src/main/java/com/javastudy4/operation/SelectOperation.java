package com.javastudy4.operation;

import com.javastudy4.model.Library;
import com.javastudy4.model.Book;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import com.javastudy4.service.LibraryService;
import java.sql.*;

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
        
        LibraryService libraryService = new LibraryService();
        List<Library> libraries;
        
        try{
            libraries = libraryService.selectByConndition(libraryName);
        }catch(SQLException e){
            e.printStackTrace();
            return;
        }
        System.out.println("図書館/ジャンル/本タイトル/本著者/出版社");
        
        // for(Library library:libraries){
        //     //Book book = dummyLibrary.getBooks().get(0);
        //     System.out.println(String.join("/", library.getName()));
        // }

        libraries.forEach(library -> System.out.println(String.join("/", library.getName())));
        
    }
}