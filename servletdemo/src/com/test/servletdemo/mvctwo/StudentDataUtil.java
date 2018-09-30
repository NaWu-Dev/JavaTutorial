package com.test.servletdemo.mvctwo;

import java.util.ArrayList;
import java.util.List;

public class StudentDataUtil {

    public static List<Student> getStudents() {

        // Create empty list
        List<Student> students = new ArrayList<>();

        // add sample data
        students.add(new Student("nana", "Wu", "nawu@gmail.com"));
        students.add(new Student("Angelo", "Chen", "angelochen@gmail.com"));
        students.add(new Student("Camel", "Chen", "Camelchen@gmail.com"));

        // return the list
        return students;

    }

}
