package com.test.servletdemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "StudentServlet")
public class StudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Step1. St content type
        response.setContentType("text/html");

        // Step 2. get PrintWriter
        PrintWriter out = response.getWriter();

        // Step 3. generate the HTML content
        out.println("<html><body>");
        out.println("The student is confirmed: " +
                request.getParameter("firstName") + " " +
                request.getParameter("middleName") + ", " +
                request.getParameter("lastName"));
        out.println("</body></html>");

    }
}
