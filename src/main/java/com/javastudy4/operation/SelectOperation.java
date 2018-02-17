package com.javastudy4.operation;

import com.javastudy4.model.Library;
import com.javastudy4.model.Book;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import com.javastudy4.service.LibraryService;
import java.sql.*;

/**
 * 検索処理
 */
public class SelectOperation implements LibraryOperation {
    public void execute(){
        
        Scanner sc = new Scanner(System.in);
        String libraryName = null;
        String bookGenre = null;
        String bookTitle = null;
        String bookAuthor = null;
        String bookPublisher = null;

        while(true){
            System.out.println("検索条件を選択してください。");
            System.out.println("0:検索、1:図書館名、2:ジャンル、3:タイトル、4:著者名、5:出版社");
            int input = sc.nextInt();
            SearchConditions searchConditions = SearchConditions.getSearchConditions(input);
            
            if (input == 0) {
                break;
            }
            
            if(searchConditions == null){
                continue;
            }
            
            switch(searchConditions) {
                case LIBRARY_NAME:
                    System.out.print("図書館:");
                    libraryName = sc.next();
                    break;
                case BOOK_GENRE:
                    System.out.print("本 ジャンル:");
                    bookGenre = sc.next();
                    break;
                case BOOK_TITLE:
                    System.out.print("本 タイトル:");
                    bookTitle = sc.next();
                    break;
                case BOOK_AUTHOR:
                    System.out.print("本 著者名:");
                    bookAuthor = sc.next();
                    break;
                case BOOK_PUBLISHER:
                    System.out.print("本 出版社:");
                    bookPublisher = sc.next();
                    break;
                default:
                    break;
            }
        }
        
        LibraryService libraryService = new LibraryService();
        List<Library> libraries;
        
        try{
            libraries = libraryService.selectByCondition(libraryName, bookGenre, bookTitle, bookAuthor, bookPublisher);
        }catch(SQLException e){
            e.printStackTrace();
            return;
        }
        System.out.println("図書館/ジャンル/本タイトル/本著者/出版社");
        
         for(Library library:libraries){
             for( Book book : library.getBooks()){
                 System.out.println(String.join("/", library.getName(), book.getGenre(), book.getTitle(), book.getAuthor(), book.getPublisher()));
             } 
         }

        //libraries.forEach(library -> System.out.println(String.join("/", library.getName())));
        
    }
}