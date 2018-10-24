package com.nana.hibernate.demo;

import com.nana.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                                .configure("hibernate.cfg.xml")
                                .addAnnotatedClass(Student.class)
                                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            // start a transaction
            session.beginTransaction();

            // query students
            List<Student> theStudents = session.createQuery("from Student").list();

            // display the students
            displayTheStudents(theStudents);

            // query student  : lastName = "Doe"
            theStudents = session.createQuery("from Student s where s.lastName = 'doe'").list();

            // display the students
            System.out.println("\n\nStudent who have last name 'Doe'");
            displayTheStudents(theStudents);

            // Query student : last name = 'Doe' or firstName = 'Daffy'
            theStudents = session.createQuery("from Student s where s.lastName = 'Doe' OR s.firstName='Daffy'").list();
            System.out.println("\n\nStudents last name = 'Doe' OR first name = 'Daffy'");
            displayTheStudents(theStudents);

            // Query student: where email LIKE '%test.com'
            theStudents = session.createQuery("from Student s where s.email LIKE '%test.com'").list();
            System.out.println("\n\nStudents email LIKE '%test.com'");
            displayTheStudents(theStudents);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            factory.close();
        }

    }

    private static void displayTheStudents(List<Student> theStudents) {
        for (Student tempStudent : theStudents) {
            System.out.println(tempStudent);
        }
    }
}
