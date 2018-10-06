package com.test.web.jdbc;

import sun.misc.Request;
import sun.reflect.annotation.ExceptionProxy;

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

        try {
            // read the "command" parameter
            String theCommand = request.getParameter("command");

            // if the command is missing, then default to listing students
            if (theCommand == null) {
                theCommand = "LIST";
            }

            // rout to the appropriate method
            switch (theCommand) {
                case "LIST":
                    // list the students in MVC fashion
                    listStudents(request, response);
                    break;
                case "ADD":
                    addStudent(request, response);
                    break;
                case "LOAD":
                    loadStudent(request, response);
                    break;
                case "UPDATE":
                    updateStudent(request, response);
                    break;
                default:
                    listStudents(request, response);
            }

        }
        catch (Exception e) {
            throw new ServletException(e);
        }

    }

    private void updateStudent(HttpServletRequest request, HttpServletResponse response)throws Exception {
        // read student information
        int theStudentId = Integer.parseInt(request.getParameter("studentId"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");

        // Create a new student object
        Student theStudent = new Student(firstName, lastName, email);

        // update student info in DB
        StudentDbUtil.updateStudent(theStudent);

        // back to main page (students list)
        listStudents(request, response);
    }

    private void loadStudent(HttpServletRequest request, HttpServletResponse response)throws Exception{
        // read student id from form data
        String theStudentId = request.getParameter("studentId");

        // get student from database (db util)
        Student theStudent = studentDbUtil.getStudent(theStudentId);

        // place student in the request attribute
        request.setAttribute("THE_STUDENT", theStudent);

        // send to jsp page: update-student-form.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("/update-student-form.jsp");
        dispatcher.forward(request, response);
    }

    private void addStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // read student info from form data
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");

        // create a new student object
        Student theStudent = new Student(firstName, lastName, email);

        // add the student to db
        studentDbUtil.addStudent(theStudent);

        // send back to main page (the studentlist)
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
