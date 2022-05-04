package com.learning.vault.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.learning.vault.entity.Course;
import com.learning.vault.entity.Student;
import com.learning.vault.entity.StudentDetails;
import com.learning.vault.entity.Subject;
import com.learning.vault.entity.Teacher;

public class HibernateUtil {

	//private static Logger logger = LogManager.getLogger(HibernateUtil.class);
	static SessionFactory sessionFactory = null;

	public static SessionFactory buildSessionFactory() {

		if(sessionFactory == null) {
			try {
				System.out.println("Creating session factory");

				Configuration cfg = new Configuration().configure("hibernate.cfg.xml")
					.addAnnotatedClass(Course.class).addAnnotatedClass(Teacher.class)
					.addAnnotatedClass(Student.class).addAnnotatedClass(StudentDetails.class)
					.addAnnotatedClass(Subject.class);


				sessionFactory = cfg.buildSessionFactory();

				return sessionFactory;
			}catch (Exception e) {
				System.err.println("Error while configuring session factory"+e);
				return sessionFactory;
			}
		}else {
			return sessionFactory;
		}
	}

}
