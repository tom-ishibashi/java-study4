package com.javastudy4.model;

public class Book {
    private int id;
    private String title;
    private String genre;
    private String author;
    private int price;
    private String publisher;
    
    // 本のIDを設定
    public void setId(int id) {
        this.id = id;
    } 
    // 本のタイトルを設定
    public void setTitle(String title) {
        this.title = title;
    } 
    // 本のジャンルを設定
    public void setGenre(String genre) {
        this.genre = genre;
    } 
    // 本の著者を設定
    public void setAuthor(String author) {
        this.author = author;
    } 
    // 本の価格を設定
    public void setPrice(int price) {
        this.price = price;
    } 
    // 本の出版社を設定
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    } 

    // 本のIDを取得
    public int getId() {
        return id;
    } 
    // 本のタイトルを取得
    public String getTitle() {
        return title;
    } 
    // 本のジャンルを取得
    public String getGenre() {
        return genre;
    } 
    // 本の著者を取得
    public String getAuthor() {
        return author;
    } 
    // 本の価格を取得
    public int getPrice() {
        return price;
    } 
    // 本の出版社を取得
    public String getPublisher() {
        return publisher;
    } 

    
}