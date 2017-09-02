package com.javastudy4.main;

import java.util.Scanner;
import com.javastudy4.operation.SelectOperation;
import com.javastudy4.main.factory.OperationFactory;

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
        OperationFactory.getInstance(operation).execute();
    }
}
