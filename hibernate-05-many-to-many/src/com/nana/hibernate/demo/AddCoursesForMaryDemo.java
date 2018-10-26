package com.nana.hibernate.demo;

import com.nana.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddCoursesForMaryDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                                .configure("hibernate.cfg.xml")
                                .addAnnotatedClass(Instructor.class)
                                .addAnnotatedClass(InstructorDetail.class)
                                .addAnnotatedClass(Course.class)
                                .addAnnotatedClass(Review.class)
                                .addAnnotatedClass(Student.class)
                                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            // start a transaction
            session.beginTransaction();

            // get student Mary
            int theId = 2;
            Student studentMary = session.get(Student.class, theId);

            System.out.println("Mary's courses (BEFORE): " + studentMary.getCourses());

            // create more courses
            Course tempCourse1 = new Course("C#");
            Course tempCourse2 = new Course("Physon");

            // add students to courses
            tempCourse1.addStudent(studentMary);
            tempCourse2.addStudent(studentMary);

            // save courses
            session.save(tempCourse1);
            session.save(tempCourse2);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Mary's courses (AFTER): " + studentMary.getCourses());

            System.out.println("Done!");

        } finally {
            session.close();
            factory.close();
        }

    }
}
