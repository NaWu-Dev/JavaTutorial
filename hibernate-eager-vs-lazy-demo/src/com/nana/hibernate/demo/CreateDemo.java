package com.nana.hibernate.demo;

import com.nana.hibernate.demo.entity.Instructor;
import com.nana.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                                .configure("hibernate.cfg.xml")
                                .addAnnotatedClass(Instructor.class)
                                .addAnnotatedClass(InstructorDetail.class)
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

            // Create object
//            Instructor tempInstructor = new Instructor("Chad", "Darby", "darby@test.com");
//            InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.test.com/youtube", "coding");

            Instructor tempInstructor = new Instructor("Madh", "Patel", "Madh@test.com");
            InstructorDetail tempInstructorDetail = new InstructorDetail("http://youtube.com", "guitar");

            // Associate objects
            tempInstructor.setInstructorDetail(tempInstructorDetail);

            // start a transaction
            session.beginTransaction();

            // save instructor will also save detailed object. because of CascadeType.All
            System.out.println("Saving instructor..." + tempInstructor);
            session.save(tempInstructor);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            factory.close();
        }

    }
}
