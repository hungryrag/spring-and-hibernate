package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class AddCoursesForMaryDemo {

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
		
		// create a session
		Session session = factory.getCurrentSession();
		
		try {		
			
			// start a transaction
			session.beginTransaction();
			
			// get the student Mary from the db
			int id = 4;
			Student mary = session.get(Student.class, id);
			
			System.out.println("\nLoaded student: " + mary);
			System.out.println("Courses: " + mary.getCourses());
			
			// create new courses
			Course newCourse1 = new Course("Rubix Cube - How To Speed Cube");
			Course newCourse2 = new Course("Atari 2600 - Game Development");			 
			
			// add Mary to the new courses
			newCourse1.addStudent(mary);
			newCourse2.addStudent(mary);
			
			// save the courses
			System.out.println("Saving the courses...");
			
			session.save(newCourse1);
			session.save(newCourse2);
			
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
