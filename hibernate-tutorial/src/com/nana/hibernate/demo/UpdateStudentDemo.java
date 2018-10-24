package com.nana.hibernate.demo;

import com.nana.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                                .configure("hibernate.cfg.xml")
                                .addAnnotatedClass(Student.class)
                                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {

            int studentId = 1;

            // now get a new session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            // retrieve student based on the id primary key
            System.out.println("Getting student with id;: " + studentId);

            // cokmmit the transaction
            Student myStudent = session.get(Student.class, studentId);

            System.out.println("Updating student...");
            myStudent.setFirstName("Scooby");

            // commit the transaction
            session.getTransaction().commit();


            //...
            // Update email for all students
            session = factory.getCurrentSession();
            session.beginTransaction();
            System.out.println("Update email for all students");
            session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
            session.getTransaction().commit();

            System.out.println("Done!");


        } finally {
            factory.close();
        }

    }
}
