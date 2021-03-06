package com.learning.vault.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.learning.vault.config.HibernateUtil;
import com.learning.vault.entity.Course;
import com.learning.vault.entity.Subject;
import com.learning.vault.entity.Teacher;

public class SubjectDao {

	public void saveSubject(Subject subject) {
		Transaction transaction = null;
		Session session = null;
		try{
			session = HibernateUtil.buildSessionFactory().openSession();
		
			if(session!=null) {
				// start a transaction
	            transaction = session.beginTransaction();
	            // save the Subject object
	            session.save(subject);
	            // commit transaction
	            transaction.commit();
			}
		}catch (Exception e) {
			if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("Error while saving Subject details in DB: "+e);
		}finally {
			if(session!=null)
				session.close();
		}
	}
	
	public void updateSubject(Subject subject, Course course, Teacher teacher) {
		Transaction transaction = null;
		Session session = null;
		try{
			session = HibernateUtil.buildSessionFactory().openSession();
		
			if(session!=null) {
				// start a transaction
	            transaction = session.beginTransaction();
	            // save the Subject object
	            
	            if(subject!=null) {
	            	
	            	if(course!=null)
	            		subject.setCourse(course);
	            	
	            	if(teacher!=null)
	            		subject.setTeacher(teacher);
	            	
	            	session.update(subject);
	            }
	            
	            // commit transaction
	            transaction.commit();
			}
		}catch (Exception e) {
			if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("Error while updating Subject details in DB: "+e);
		}finally {
			if(session!=null)
				session.close();
		}
	}
	
	public void deleteTeacher(Subject subject, Teacher teacher) {
		Transaction transaction = null;
		Session session = null;
		try{
			session = HibernateUtil.buildSessionFactory().openSession();
		
			if(session!=null) {
				// start a transaction
	            transaction = session.beginTransaction();
	            // save the Subject object
	            if(subject!=null) {

	            	if(teacher!=null)
	            		subject.setTeacher(null);
	            	
	            	session.update(subject);
	            }
	            // commit transaction
	            transaction.commit();
			}
		}catch (Exception e) {
			if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("Error while deleting Subject details from DB: "+e);
		}finally {
			if(session!=null)
				session.close();
		}
	}
	
	public void deleteSubject(Subject subject) {
		Transaction transaction = null;
		Session session = null;
		try{
			session = HibernateUtil.buildSessionFactory().openSession();
		
			if(session!=null) {
				// start a transaction
	            transaction = session.beginTransaction();
	            // save the Subject object
	            session.delete(subject);
	            // commit transaction
	            transaction.commit();
			}
		}catch (Exception e) {
			if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("Error while deleting Subject details from DB: "+e);
		}finally {
			if(session!=null)
				session.close();
		}
	}
	
	public Subject getSubject(int id) {
		Transaction transaction = null;
		Session session = null;
		Subject subject = null;
		try{
			session = HibernateUtil.buildSessionFactory().openSession();
		
			if(session!=null) {
				// start a transaction
	            transaction = session.beginTransaction();
	            // save the Subject object
	            subject = (Subject) session.get(Subject.class, id);
	            // commit transaction
	            transaction.commit();
			}
		}catch (Exception e) {
			if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("Error while fetching Subject details from DB: "+e);
		}finally {
			if(session!=null)
				session.close();
		}
		return subject;
	}
	
	public List<Subject> getAllSubjects() {
		Transaction transaction = null;
		Session session = null;
		List<Subject> subjects = null;
		try{
			session = HibernateUtil.buildSessionFactory().openSession();
		
			if(session!=null) {
				// start a transaction
	            transaction = session.beginTransaction();
	            // save the Subject object
	            subjects = session.createQuery("from Subject").list();
	            // commit transaction
	            transaction.commit();
			}
		}catch (Exception e) {
			if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("Error while fetching Subject details from DB: "+e);
		}finally {
			if(session!=null)
				session.close();
		}
		return subjects;
	}
	
	public List<Subject> getSubjectsByCourse(int courseId) {
		Transaction transaction = null;
		Session session = null;
		List<Subject> subjects = null;
		try{
			session = HibernateUtil.buildSessionFactory().openSession();
		
			if(session!=null) {
				// start a transaction
	            transaction = session.beginTransaction();
	            // save the Subject object
	            Query query = session.createQuery("from Subject where course_id =:courseId");
	            query.setInteger("courseId", courseId);
	            subjects = query.list();

	            // commit transaction
	            transaction.commit();
			}
		}catch (Exception e) {
			if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("Error while fetching Subject details from DB: "+e);
		}finally {
			if(session!=null)
				session.close();
		}
		return subjects;
	}
	
	public List<Subject> getSubjectsByTeacher(int teacherId) {
		Transaction transaction = null;
		Session session = null;
		List<Subject> subjects = null;
		try{
			session = HibernateUtil.buildSessionFactory().openSession();
		
			if(session!=null) {
				// start a transaction
	            transaction = session.beginTransaction();
	            // save the Subject object
	            Query query = session.createQuery("from Subject where teacher_id =:teacherId");
	            query.setInteger("teacherId", teacherId);
	            subjects = query.list();

	            // commit transaction
	            transaction.commit();
			}
		}catch (Exception e) {
			if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("Error while fetching Subject details from DB: "+e);
		}finally {
			if(session!=null)
				session.close();
		}
		return subjects;
	}
}
