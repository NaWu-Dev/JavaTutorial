package com.test.servletdemo;

import java.io.IOException;
import java.io.PrintWriter;

public class HelloWorldServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        // step 1. Set the content type
        response.setContentType("text/html");

        // Step 2. get the printWriter
        PrintWriter out = response.getWriter();

        // Step 3. generate HTML content
        out.println("<html><body>");
        out.println("<h2>Hello World</h2><hr>Time on the server is: " + new java.util.Date());
        out.println("</body></html>");
    }
}
