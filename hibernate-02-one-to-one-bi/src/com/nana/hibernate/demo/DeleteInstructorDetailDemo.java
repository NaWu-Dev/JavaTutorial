package com.nana.hibernate.demo;

import com.nana.hibernate.demo.entity.Instructor;
import com.nana.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetailDemo {

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
            // start a transaction
            session.beginTransaction();

            // get instructor detail object
            int theId = 3;
            InstructorDetail theInstructorDetail = session.get(InstructorDetail.class, theId);

            // remove associated object reference
            // break bi-directional link
            // delete instructor detail, this time won't delete associated instructor
            theInstructorDetail.getInstructor().setInstructorDetail(null);
            System.out.println("Deleting instructor detail...." + theInstructorDetail);
            session.delete(theInstructorDetail);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        finally {
            session.close();
            factory.close();
        }

    }
}
