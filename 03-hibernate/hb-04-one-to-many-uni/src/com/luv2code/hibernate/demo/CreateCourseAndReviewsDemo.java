package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;

public class CreateCourseAndReviewsDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.buildSessionFactory();
		
		// create a session
		Session session = factory.getCurrentSession();
		
		try {		
			
			// start a transaction
			session.beginTransaction();
			
			// create a course
			Course course = new Course("Pacman - How To Score One Million Points");
			
			// add some review
			course.addReview(new Review("Great course...loved it!"));
			course.addReview(new Review("Cool course, job well done"));
			course.addReview(new Review("What a dumb course, you are an idiot!"));
			
			// save the course...and levarage the cascade all
			System.out.println("Saving the course");
			System.out.println(course);
			System.out.println(course.getReviews());
			
			session.save(course);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			// add cleanup code
			session.close();
			
			factory.close();
		}
		

	}

}
