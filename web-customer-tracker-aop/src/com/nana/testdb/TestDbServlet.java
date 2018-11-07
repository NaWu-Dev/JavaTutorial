package com.nana.testdb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebEndpoint;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class TestDbServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        // setup connection variables
        String user = "Cat";
        String pass = "100281";

        String jdbcUrl = "jdbc:mysql://192.168.1.230/web_customer_tracker?userSSL=false&serverTimezone=UTC";
        String driver = "com.mysql.jdbc.Driver";

        // get connection to the db.
        try {

            PrintWriter out = response.getWriter();
            Class.forName(driver);

            out.println("Connection to DB: " + jdbcUrl);

            Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);

            out.println("SUCCESS!");

            myConn.close();

        } catch (Exception exp) {
            exp.printStackTrace();
            throw new ServletException(exp);
        }

    }
}
