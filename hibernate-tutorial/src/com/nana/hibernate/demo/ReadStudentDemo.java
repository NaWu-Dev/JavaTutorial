package com.nana.hibernate.demo;

import com.nana.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {

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
            System.out.println("Create new student object");
            Student tempStudent = new Student("Daffy", "Duck", "daffy@test.com");

            // start a transaction
            session.beginTransaction();

            // save the student object
            System.out.println("Saving the student");
            session.save(tempStudent);

            // commit transaction
            session.getTransaction().commit();

            // find out the primary key
            System.out.println("Saved student generate ID" + tempStudent.getId());

            // now get a new session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            // retrieve student based on the id primary key
            System.out.println("Gettig student with id;: " + tempStudent.getId());

            // cokmmit the transaction
            Student myStudent = session.get(Student.class, tempStudent.getId());
            System.out.println("get completed: " + myStudent);

            // commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!");


        } finally {
            factory.close();
        }

    }
}
