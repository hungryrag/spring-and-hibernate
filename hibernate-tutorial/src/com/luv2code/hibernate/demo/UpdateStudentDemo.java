package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create a session
		Session session = factory.getCurrentSession();
		
		try {			
			
			int studentId = 1;
			
			// start transaction 
			session.beginTransaction();
			
			// retrieve student based on the id
			System.out.println("\n\nGetting student with id: " + studentId);
			
			Student student = session.get(Student.class, studentId);
			
			System.out.println("Updating the student...");
			student.setFirstName("Scooby");
			
			// commit the transaction
			session.getTransaction().commit();
			
			// get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// update email
			System.out.println("Update email...");
			
			session
				.createQuery("update Student set email='dhrubojana007@gmail.com' where id=7")
				.executeUpdate();
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}
		finally {
			factory.close();
		}
		

	}

	/**
	 * @param students
	 */
	private static void displayStudents(List<Student> students) {
		for(Student tempStudent : students) {
			System.out.println(tempStudent);
		}
	}

}
