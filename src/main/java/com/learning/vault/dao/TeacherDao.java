package com.learning.vault.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.learning.vault.config.HibernateUtil;
import com.learning.vault.entity.Teacher;

public class TeacherDao {

	public void saveTeacher(Teacher teacher) {
		Transaction transaction = null;
		Session session = null;
		try{
			session = HibernateUtil.buildSessionFactory().openSession();
		
			if(session!=null) {
				// start a transaction
	            transaction = session.beginTransaction();
	            // save the Teacher object
	            session.save(teacher);
	            // commit transaction
	            transaction.commit();
			}
		}catch (Exception e) {
			if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("Error while saving Teacher details in DB: "+e);
		}finally {
			if(session!=null)
				session.close();
		}
	}
	
	public void updateTeacher(Teacher teacher) {
		Transaction transaction = null;
		Session session = null;
		try{
			session = HibernateUtil.buildSessionFactory().openSession();
		
			if(session!=null) {
				// start a transaction
	            transaction = session.beginTransaction();
	            // save the Teacher object
	            session.update(teacher);
	            // commit transaction
	            transaction.commit();
			}
		}catch (Exception e) {
			if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("Error while updating Teacher details in DB: "+e);
		}finally {
			if(session!=null)
				session.close();
		}
	}
	
	public void deleteTeacher(Teacher teacher) {
		Transaction transaction = null;
		Session session = null;
		try{
			session = HibernateUtil.buildSessionFactory().openSession();
		
			if(session!=null) {
				// start a transaction
	            transaction = session.beginTransaction();
	            // save the Teacher object
	            session.delete(teacher);
	            // commit transaction
	            transaction.commit();
			}
		}catch (Exception e) {
			if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("Error while deleting Teacher details from DB: "+e);
		}finally {
			if(session!=null)
				session.close();
		}
	}
	
	public Teacher getTeacher(int id) {
		Transaction transaction = null;
		Session session = null;
		Teacher teacher = null;
		try{
			session = HibernateUtil.buildSessionFactory().openSession();
		
			if(session!=null) {
				// start a transaction
	            transaction = session.beginTransaction();
	            // save the Teacher object
	            teacher = (Teacher) session.get(Teacher.class, id);
	            // commit transaction
	            transaction.commit();
			}
		}catch (Exception e) {
			if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("Error while fetching Teacher details from DB: "+e);
		}finally {
			if(session!=null)
				session.close();
		}
		return teacher;
	}
	
	public List<Teacher> getAllTeachers() {
		Transaction transaction = null;
		Session session = null;
		List<Teacher> teachers = null;
		try{
			session = HibernateUtil.buildSessionFactory().openSession();
		
			if(session!=null) {
				// start a transaction
	            transaction = session.beginTransaction();
	            // save the Teacher object
	            teachers = session.createQuery("from Teacher").list();
	            // commit transaction
	            transaction.commit();
			}
		}catch (Exception e) {
			if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("Error while fetching Teacher details from DB: "+e);
		}finally {
			if(session!=null)
				session.close();
		}
		return teachers;
	}
}
