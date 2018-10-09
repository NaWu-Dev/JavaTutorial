package com.test.web.jdbc;

import java.io.*;
import java.sql.*;

public class TestServlet extends javax.servlet.http.HttpServlet {

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        // Step 1. set up the printwriter
        PrintWriter out = response.getWriter();
        response.setContentType("text/plain");

        // Step 2. get a connection to a database
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            myConn = DriverManager.getConnection("jdbc:mysql://192.168.1.230:3306/web_student_tracker", "Cat", "100281");

            // Step 3. Create a SQL statements
            String sql = "select * from student";
            myStmt = myConn.createStatement();

            // Step 4. Execute SQL query
            myRs = myStmt.executeQuery(sql);

            // STep 5. Process the result set
            while (myRs.next()) {
                String email = myRs.getString("email");
                out.println(email);
            }
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}
