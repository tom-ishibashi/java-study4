package com.javastudy4.operation;

import com.javastudy4.model.Library;
import com.javastudy4.model.Book;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import com.javastudy4.service.LibraryService;
import java.sql.*;


public class InsertOperation implements LibraryOperation {
    public void execute(){
        
        Scanner sc = new Scanner(System.in);

        System.out.println("登録対象を選択してください。");
        System.out.println("1:図書館 2:本 3:ひも付き");

        LibraryService libraryService = new LibraryService();

        try {
    
            while(true){  
    
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
                        // System.out.print("本 ジャンル:");
                        // bookGenre = sc.next();
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