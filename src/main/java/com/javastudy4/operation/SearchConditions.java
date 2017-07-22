package com.javastudy4.operation;

import java.util.Arrays;

public enum SearchConditions {
    LIBRARY_NAME(1),
    BOOK_GENRE(2),
    BOOK_TITLE(3),
    BOOK_AUTHOR(4),
    BOOK_PUBLISHER(5);
    
    private int no;
    
    SearchConditions(int no) {
        this.no = no;
    }
    
    public int getNo() {
        return no;
    }
    
    // public static Operation getOperation(int no) {
    //     Operation result = null;
    //     Operation[] op = Operation.values();
    //     for(Operation operation: op) {
    //         if (operation.getNo() == no) {
    //             result = operation;
    //         }
    //     }
    //     return result;
    // }
    
    public static SearchConditions getSearchConditions(int no) {
        return Arrays.stream(SearchConditions.values())
        .filter(searchConditions -> searchConditions.getNo() == no)
        .findFirst()
        .orElse(null);
    }
}