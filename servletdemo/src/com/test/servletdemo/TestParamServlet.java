package com.test.servletdemo;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TestParamServlet")
public class TestParamServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Step 1 set content type
        response.setContentType("text/html");

        // Step 2. get printwriter
        PrintWriter out = response.getWriter();

        // Step 3. read configuration params
        ServletContext context = getServletContext(); // inherit from httpservlet
        String maxCarSize = context.getInitParameter("max-shopping-cart-size");
        String teamName = context.getInitParameter("project-team-name");

        // Step 4. generate html content
        out.println("<html><body>" +
                    "Max cart: " + maxCarSize +
                    "Team name: " + teamName +
                    "</body></html>");
    }
}
