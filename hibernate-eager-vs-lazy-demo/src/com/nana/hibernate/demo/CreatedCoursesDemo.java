package com.nana.hibernate.demo;

import com.nana.hibernate.demo.entity.Course;
import com.nana.hibernate.demo.entity.Instructor;
import com.nana.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreatedCoursesDemo {

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

            // get instructor from db
            int id = 1;
            Instructor tempInstructor = session.get(Instructor.class, id);

            // create some courses
            Course tempCourse1 = new Course("Air Guitar - the ultimate guita");
            Course tempCourse2 = new Course("The pinball masterclass");

            // add course to instrutor
            tempInstructor.add(tempCourse1);
            tempInstructor.add(tempCourse2);

            // save the course
            session.save(tempCourse1);
            session.save(tempCourse2);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            session.close();
            factory.close();
        }

    }
}
