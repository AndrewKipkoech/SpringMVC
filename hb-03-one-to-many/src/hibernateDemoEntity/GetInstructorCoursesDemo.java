package hibernateDemoEntity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernateDemoEntity.Course;
import hibernateDemoEntity.Instructor;
import hibernateDemoEntity.InstructorDetail;

public class GetInstructorCoursesDemo {

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
			
			//get the instructor from the database
			//create some courses
			//add courses to the instructor
			//save the courses
			session.beginTransaction();
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			System.out.println("The instructor is: " + tempInstructor.getFirstName());
			System.out.println("The instructor teach the following courses: " + tempInstructor.getCourses());
		
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			
			// add clean up code
			session.close();
			
			factory.close();
		}
	}

}





