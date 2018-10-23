package com.nana.hibernate.demo;

import com.nana.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            // use session object to save Java object

            // create a student object
            System.out.println("Create 3 student object");
            Student tempStudent1 = new Student("John", "Doe", "john@test.com");
            Student tempStudent2 = new Student("Mary", "Public", "mary@test.com");
            Student tempStudent3 = new Student("Bonita", "Applebum", "applebum@test.com");

            // start a transaction
            session.beginTransaction();

            // save the student object
            System.out.println("Saving the student");
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            factory.close();
        }

    }
}
