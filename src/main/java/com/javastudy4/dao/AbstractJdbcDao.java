package com.javastudy4.dao;

import java.sql.*;

/**
 * abstruct class
 */
abstract class AbstractJdbcDao {
    protected Connection con;
    protected void getConnection() throws SQLException{
        try {
            // MySQLに接続
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javastudy4", "root", "");
        } catch (SQLException e) {
            System.out.println("MySQLに接続できませんでした。");
            throw e;
        }
    }

    protected void closeConnection() throws SQLException{
        try {
            // MySQL切断
            con.close();
        } catch (SQLException e) {
            System.out.println("MySQLを切断できませんでした。");
            throw e;
        }
    }

   
}
