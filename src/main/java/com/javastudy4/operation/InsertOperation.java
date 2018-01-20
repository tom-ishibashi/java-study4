package com.javastudy4.operation;

import com.javastudy4.model.Library;
import com.javastudy4.model.Book;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import com.javastudy4.service.*;
import java.sql.*;

/**
 * 登録処理
 */
public class InsertOperation implements LibraryOperation {
    public void execute(){
        
        Scanner sc = new Scanner(System.in);

        LibraryService libraryService = new LibraryService();
        BookService bookService = new BookService();

        try {
    
            while(true){  
                System.out.println("登録対象を選択してください。");
                System.out.println("1:図書館 2:本 3:ひも付き");
                int input = sc.nextInt();
                InsertTergets insertTergets = InsertTergets.getInsertTergets(input);
                
                if(insertTergets == null){
                    break;
                }
                
                switch(insertTergets) {
                    case LIBRARY:
                        System.out.print("図書館名:");
                        libraryService.insertLibrary(sc.next());
                        break;
                    case BOOK:
                        System.out.print("本 タイトル:");
                        String bookTitle = sc.next();
                        
                        System.out.print("本 ジャンル:");
                        String bookGenre = sc.next();
                        
                        System.out.print("本 価格:");
                        int bookPrice = sc.nextInt();
                        
                        System.out.print("本 著者:");
                        String bookAuthor = sc.next();
                        
                        System.out.print("本 出版社:");
                        String bookPublisher = sc.next();
                        
                        bookService.insertBook(bookTitle,bookGenre,bookPrice,bookAuthor,bookPublisher);
                        break;
                    case LINK:
                        // System.out.print("本 タイトル:");
                        // bookTitle = sc.next();
                        break;
                    default:
                        break;
                }
    
            }
        
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        
    }
}