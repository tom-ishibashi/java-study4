package com.javastudy4.operation;

import com.javastudy4.model.Library;
import com.javastudy4.model.Book;
import java.util.List;
import java.util.ArrayList;

public class SelectOperation {
    public void search(){
        
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