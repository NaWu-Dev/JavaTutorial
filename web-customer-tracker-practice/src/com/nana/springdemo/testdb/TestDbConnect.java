package com.nana.springdemo.testdb;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

public class TestDbConnect {

    public static void main(String[] arg) {

        // setup parameters
        String userName = "Cat";
        String passWord = "100281";
        String jdbcUrl = "jdbc:mysql://192.168.1.230/web_customer_tracker?userSSL=false&serverTimezone=UTC";
        String driver = "com.mysql.jdbc.Driver";

        // connect db
        try {

            Class.forName(driver);
            Connection myConn = DriverManager.getConnection(jdbcUrl, userName, passWord);
            System.out.println("SUCCESS! ");
            myConn.close();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
}
