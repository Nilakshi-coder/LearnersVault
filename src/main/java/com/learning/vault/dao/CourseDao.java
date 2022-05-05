package com.learning.vault.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.learning.vault.config.HibernateUtil;
import com.learning.vault.entity.Student;

public class CourseDao {

	public void saveStudent(Student student) {
		Transaction transaction = null;
		Session session = null;
		try{
			session = HibernateUtil.buildSessionFactory().openSession();
		
			if(session!=null) {
				// start a transaction
	            transaction = session.beginTransaction();
	            // save the student object
	            session.save(student);
	            // commit transaction
	            transaction.commit();
			}
		}catch (Exception e) {
			if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("Error while saving Student details in DB: "+e);
		}finally {
			if(session!=null)
				session.close();
		}
	}
	
	public void updateStudent(Student student) {
		Transaction transaction = null;
		Session session = null;
		try{
			session = HibernateUtil.buildSessionFactory().openSession();
		
			if(session!=null) {
				// start a transaction
	            transaction = session.beginTransaction();
	            // save the student object
	            session.update(student);
	            // commit transaction
	            transaction.commit();
			}
		}catch (Exception e) {
			if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("Error while updating Student details in DB: "+e);
		}finally {
			if(session!=null)
				session.close();
		}
	}
	
	public void deleteStudent(Student student) {
		Transaction transaction = null;
		Session session = null;
		try{
			session = HibernateUtil.buildSessionFactory().openSession();
		
			if(session!=null) {
				// start a transaction
	            transaction = session.beginTransaction();
	            // save the student object
	            session.delete(student);
	            // commit transaction
	            transaction.commit();
			}
		}catch (Exception e) {
			if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("Error while deleting Student details from DB: "+e);
		}finally {
			if(session!=null)
				session.close();
		}
	}
	
	public Student getStudent(int id) {
		Transaction transaction = null;
		Session session = null;
		Student student = null;
		try{
			session = HibernateUtil.buildSessionFactory().openSession();
		
			if(session!=null) {
				// start a transaction
	            transaction = session.beginTransaction();
	            // save the student object
	            student = (Student) session.get(Student.class, id);
	            // commit transaction
	            transaction.commit();
			}
		}catch (Exception e) {
			if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("Error while fetching Student details from DB: "+e);
		}finally {
			if(session!=null)
				session.close();
		}
		return student;
	}
	
	public List<Student> getAllStudents() {
		Transaction transaction = null;
		Session session = null;
		List<Student> students = null;
		try{
			session = HibernateUtil.buildSessionFactory().openSession();
		
			if(session!=null) {
				// start a transaction
	            transaction = session.beginTransaction();
	            // save the student object
	            students = session.createQuery("from Student").list();
	            // commit transaction
	            transaction.commit();
			}
		}catch (Exception e) {
			if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("Error while fetching Student details from DB: "+e);
		}finally {
			if(session!=null)
				session.close();
		}
		return students;
	}
}
