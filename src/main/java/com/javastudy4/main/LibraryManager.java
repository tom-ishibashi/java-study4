package com.javastudy4.main;

import java.util.Scanner;

/**
 * @author tom-ishibashi
 */
public class LibraryManager {
    public static void main(String[] args) {
        System.out.println("操作を選択してください。");
        System.out.println("1.select 2.insert 3.update 4.delete");
        
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        Operation operation = Operation.getOperation(input);
        
        if (operation == null) {
            System.out.println("アプリケーションを終了します。");
            return;
        }
        
        switch(operation) {
            case SELECT:
                // TODO select処理を実装する
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
    }
}
