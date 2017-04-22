package com.javastudy4.model;

import java.util.List;

public class Library {
    private int id;
    private String name;
    private List<Book> books;
    
    // 図書館のIDを設定
    public void setId(int id) {
        this.id = id;
    } 
    // 図書館の名前を設定
    public void setName(String name) {
        this.name = name;
    } 

    // 図書館のIDを取得
    public int getId() {
        return id;
    } 
    // 図書館の名前を取得
    public String getName() {
        return name;
    } 
    
    // 本を設定
    public void setBooks(List<Book> books){
        this.books = books;
    }
    
    // 本を取得
    public List<Book> getBooks(){
        return books;
    }
}