package com.javastudy4.operation;

import java.util.Arrays;

public enum InsertTergets {
    LIBRARY(1),
    BOOK(2),
    LINK(3);
    
    private int no;
    
    InsertTergets(int no) {
        this.no = no;
    }
    
    public int getNo() {
        return no;
    }
    
    public static InsertTergets getInsertTergets(int no) {
        return Arrays.stream(InsertTergets.values())
        .filter(insertTergets -> insertTergets.getNo() == no)
        .findFirst()
        .orElse(null);
    }
}
