package com.javastudy4.main.factory;
import com.javastudy4.operation.LibraryOperation;
import com.javastudy4.main.Operation;
import com.javastudy4.operation.SelectOperation;

public class OperationFactory {
    public static LibraryOperation getInstance(Operation operation){
        LibraryOperation libraryOperation = null; 
        switch(operation) {
            case SELECT:
                libraryOperation = new SelectOperation();
                break;
            case INSERT:
                // TODO insert処理を実装する
                break;
            case UPDATE:
                // TODO update処理を実装する
                break;
            case DELETE:
                // TODO delete処理を実装する
                break;
        }
        return libraryOperation;
    }
}