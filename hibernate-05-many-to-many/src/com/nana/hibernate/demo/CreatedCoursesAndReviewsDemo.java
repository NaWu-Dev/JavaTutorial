package com.nana.hibernate.demo;

import com.nana.hibernate.demo.entity.Course;
import com.nana.hibernate.demo.entity.Instructor;
import com.nana.hibernate.demo.entity.InstructorDetail;
import com.nana.hibernate.demo.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreatedCoursesAndReviewsDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                                .configure("hibernate.cfg.xml")
                                .addAnnotatedClass(Instructor.class)
                                .addAnnotatedClass(InstructorDetail.class)
                                .addAnnotatedClass(Course.class)
                                .addAnnotatedClass(Review.class)
                                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            // start a transaction
            session.beginTransaction();

            // create a course
            Course tempCourse = new Course("Pacman - how to score one million points");

            // add some reviews
            tempCourse.addReview(new Review("Great course... lovei it"));
            tempCourse.addReview(new Review("WOW"));
            tempCourse.addReview(new Review("Job well done!"));
            tempCourse.addReview(new Review("Bad exprience..."));

            // save course
            System.out.println("Saving couser... :" + tempCourse);
            System.out.println("Reviews: " + tempCourse.getReviews());
            session.save(tempCourse);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            session.close();
            factory.close();
        }

    }
}
