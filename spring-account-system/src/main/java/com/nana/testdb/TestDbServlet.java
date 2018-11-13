package com.nana.testdb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

@WebServlet(name = "TestDbServlet")
public class TestDbServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String user = "Cat";
        String psw = "100281";

        String jdbcUrl = "jdbc:mysql://192.168.1.230/java-tutorial?userSSL=false&serverTimezone=UTC";
        String driver = "com.mysql.jdbc.Driver";

        try {

            PrintWriter out = response.getWriter();
            Class.forName(driver);

            Connection connection = DriverManager.getConnection(jdbcUrl, user, psw);

            System.out.println("DB Connect Successfully. ");

            connection.close();

        } catch (Exception exc) {
            exc.printStackTrace();
        }

    }
}
