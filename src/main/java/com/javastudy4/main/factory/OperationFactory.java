package com.javastudy4.main.factory;
import com.javastudy4.operation.LibraryOperation;
import com.javastudy4.main.Operation;
import com.javastudy4.operation.SelectOperation;
import com.javastudy4.operation.InsertOperation;

public class OperationFactory {
    /**
     * 操作に応じた処理クラスの生成
     */
    public static LibraryOperation getInstance(Operation operation){
        LibraryOperation libraryOperation = null; 
        switch(operation) {
            case SELECT:
                libraryOperation = new SelectOperation();
                break;
            case INSERT:
                libraryOperation = new InsertOperation();
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