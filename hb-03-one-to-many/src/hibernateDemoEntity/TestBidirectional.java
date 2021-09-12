package hibernateDemoEntity;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernateDemoEntity.Instructor;
import hibernateDemoEntity.InstructorDetail;

public class TestBidirectional {

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

			// get instructor by primary key / id
			int theId = 2;
			InstructorDetail tempInstructorDetail = 
					session.get(InstructorDetail.class, theId);
			
			//print the instructor
			
			System.out.println("The instructor detail: " + tempInstructorDetail);
			
			//print the associated instructor
			System.out.println("The associated instructor is: " + tempInstructorDetail.getInstructor());
						
			
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}catch(Exception exc) {
			exc.printStackTrace();
		}
		finally {
			//handle leak issue
			session.close();
			factory.close();
		}
	}

}





