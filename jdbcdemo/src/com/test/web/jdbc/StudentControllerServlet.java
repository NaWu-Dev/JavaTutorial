package com.test.web.jdbc;

import sun.misc.Request;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentControllerServlet")
public class StudentControllerServlet extends HttpServlet {

    private StudentDbUtil studentDbUtil;

    @Override
    public void init() throws ServletException {
        super.init();

        // create student db util, and pass it in the conn pool
        try {
            studentDbUtil = new StudentDbUtil();
        } catch (Exception exc) {
            throw new ServletException(exc);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // list the students in MVC fashion
        listStudents(request, response);

    }

    private void listStudents(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // get students from db util
        List<Student> students = null;
        try {
            students = studentDbUtil.getStudents();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // add students to request
        request.setAttribute("STUDENTS_LIST", students);

        // send to JSP page (view)
        RequestDispatcher dispatcher = request.getRequestDispatcher("/list-students.jsp");
        dispatcher.forward(request, response);
    }
}
