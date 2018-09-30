package com.test.servletdemo.mvctwo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "MvcDemoServletTwo")
public class MvcDemoServletTwo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // get the student data from helper class (Module)
        List<Student> students = StudentDataUtil.getStudents();

        // add students to request object
        request.setAttribute("student_list", students);

        // get request dispatcher
        RequestDispatcher dispatcher = request.getRequestDispatcher("view_students_two.jsp");

        // forward to JSP
        dispatcher.forward(request, response);

    }
}
