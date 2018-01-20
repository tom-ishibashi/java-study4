package com.javastudy4.main;

import java.util.Arrays;
/**
 * 操作種別
 */
public enum Operation {
    SELECT(1),
    INSERT(2),
    UPDATE(3),
    DELETE(4);
    
    private int no;
    
    Operation(int no) {
        this.no = no;
    }
    
    public int getNo() {
        return no;
    }
    
    public static Operation getOperation(int no) {
        return Arrays.stream(Operation.values())
        .filter(operation -> operation.getNo() == no)
        .findFirst()
        .orElse(null);
    }
}