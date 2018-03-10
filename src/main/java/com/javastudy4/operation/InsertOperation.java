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
    private Scanner sc = new Scanner(System.in);
    private LibraryService libraryService = new LibraryService(); 
    private BookService bookService = new BookService();
    private LinkService linkService = new LinkService();
    
    public void execute(){
        try {
    
            while(true){  
                System.out.println("登録対象を選択してください。");
                System.out.println("1:図書館 2:本 3:ひも付き");
                int input = sc.nextInt();
                InsertTergets insertTergets = InsertTergets.getInsertTergets(input);
                
                if(insertTergets == null){
                    System.out.println("アプリケーションを終了します");
                    break;
                }
                
                switch(insertTergets) {
                    case LIBRARY:
                        registerLibrary();
                        break;
                    case BOOK:
                        registerBook();
                        break;
                    case LINK:
                        showLibraries();
                        showBooks();
                        registerLink();
                        break;
                    default:
                        break;
                }
                System.out.println("登録が完了しました。");
            }
        
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        
    }
    
    private void registerLibrary() throws SQLException{
        System.out.print("図書館名:");
        libraryService.insertLibrary(sc.next());
    }
    
    private void registerBook() throws SQLException{
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
    }
    
    private void showLibraries() throws SQLException{
        System.out.println("図書館一覧");
        System.out.println("No:図書館");
        List<Library> libraries = libraryService.selectLibrary();
        for(Library library:libraries){
            System.out.println(library.getId() + ":" + library.getName());
        }
    }
    
    private void showBooks() throws SQLException{
        System.out.println("本一覧");
        System.out.println("No:ジャンル/本タイトル/本著者/出版社");
        List<Book> books = bookService.selectBook();
        for( Book book : books){
            System.out.println(book.getId() + ":" + String.join("/", book.getGenre(), book.getTitle(), book.getAuthor(), book.getPublisher()));
        } 
    }

    private void registerLink() throws SQLException{
        System.out.println("どの図書館にどの本をひも付けますか？");
        System.out.print("図書館No:");
        int libraryId = sc.nextInt();
        System.out.print("本No:");
        int bookId = sc.nextInt();
        linkService.insertLink(libraryId,bookId);
    }
}