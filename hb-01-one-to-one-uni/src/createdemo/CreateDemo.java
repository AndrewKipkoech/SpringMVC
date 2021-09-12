package createdemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernateDemoEntity.Instructor;
import hibernateDemoEntity.InstructorDetail;
import hibernateDemoEntity.Student;

public class CreateDemo {

	public static void main(String[] args) {
		//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		//create a session
		Session session = factory.getCurrentSession();
		try {
			//use the session object to save the java object
			//create the objects
			Instructor tempInstructor = new Instructor("Andrew", "Kipkoech", "andrew@gmail.com");
			InstructorDetail instructorDetail= new InstructorDetail("http://www.andrewkip.youtube.com", "coding");
			//associate the objects
			tempInstructor.setInstructorDetail(instructorDetail);
			
			//start transaction
			session.beginTransaction();
			//save instructor
			session.save(tempInstructor);
			
			//save the student object
			System.out.println("Saving the instructor...");
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		}
		finally {
			factory.close();
		}
		

	}

}
