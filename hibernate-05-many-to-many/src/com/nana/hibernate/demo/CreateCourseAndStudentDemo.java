package com.nana.hibernate.demo;

import com.nana.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndStudentDemo {

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

            // create course
            Course theCourse = new Course("Pacman - how to score one million points");
            session.save(theCourse);

            // create student
            Student theStudent1 =  new Student("Jone", "Doe", "John@test.com");
            Student theStudent2 =  new Student("Mary", "Public", "Mary@test.com");

            theCourse.addStudent(theStudent1);
            theCourse.addStudent(theStudent2);

            session.save(theStudent1);
            session.save(theStudent2);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            session.close();
            factory.close();
        }

    }
}
