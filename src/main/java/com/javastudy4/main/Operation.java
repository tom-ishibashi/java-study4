package com.javastudy4.main;

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
        Operation result = null;
        Operation[] op = Operation.values();
        for(Operation operation: op) {
            if (operation.getNo() == no) {
                result = operation;
            }
        }
        return result;
    }
}