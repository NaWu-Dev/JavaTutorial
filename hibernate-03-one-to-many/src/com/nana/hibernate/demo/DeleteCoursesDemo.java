package com.nana.hibernate.demo;

import com.nana.hibernate.demo.entity.Course;
import com.nana.hibernate.demo.entity.Instructor;
import com.nana.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DeleteCoursesDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                                .configure("hibernate.cfg.xml")
                                .addAnnotatedClass(Instructor.class)
                                .addAnnotatedClass(InstructorDetail.class)
                                .addAnnotatedClass(Course.class)
                                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            // Steps:
            // Create object
            // associate objects
            // start a transaction
            // save the insturctor
            // commit instructor

            // start a transaction
            session.beginTransaction();

            // get a course
            int theId = 10;
            Course tempCourse = session.get(Course.class, theId);

            // delete course
            session.delete(tempCourse);
            
            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            session.close();
            factory.close();
        }

    }
}
