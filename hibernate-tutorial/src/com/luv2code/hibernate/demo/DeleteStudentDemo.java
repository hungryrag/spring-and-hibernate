package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

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
			
//			// retrieve student based on the id
//			System.out.println("\n\nGetting student with id: " + studentId);
//			
//			Student student = session.get(Student.class, studentId);
//			
//			// delete the student
//			System.out.println("Deleting the student: " + student);
//			session.delete(student);
			
			// delete student id=2
			System.out.println("Deleting student id=2");
			
			session
				.createQuery("delete from Student where id=2")
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
