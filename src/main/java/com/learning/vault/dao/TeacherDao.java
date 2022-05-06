package com.learning.vault.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.learning.vault.config.HibernateUtil;
import com.learning.vault.entity.Student;
import com.learning.vault.entity.Subject;
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
	
	public Teacher assignSubject(int teacherId, int subjectId) {
		Transaction transaction = null;
		Session session = null;
		Teacher teacher = null;
		Subject subject = null;
		try{
			session = HibernateUtil.buildSessionFactory().openSession();
		
			if(session!=null) {
				System.out.println("Assigning Subject::"+subjectId+" to Teacher::"+teacherId+" ");
				// start a transaction
	            transaction = session.beginTransaction();
	            // save the Teacher object
	            teacher = (Teacher) session.get(Teacher.class, teacherId);
	            subject = (Subject) session.get(Subject.class, subjectId);
	            		
	            List<Subject> subjectList = teacher.getSubjects();
	            subjectList.add(subject);
	            
	            teacher.setSubjects(subjectList);
	            
	            session.update(teacher);
	            
	            // commit transaction
	            transaction.commit();
			}
		}catch (Exception e) {
			if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("Error while assinging Subject to Teacher in DB: "+e);
		}finally {
			if(session!=null)
				session.close();
		}
		return teacher;
	}

	public List<Teacher> getTeachersBySubject(int subjectId) {
		Transaction transaction = null;
		Session session = null;
		List<Teacher> teachers = null;
		try{
			session = HibernateUtil.buildSessionFactory().openSession();
		
			if(session!=null) {
				// start a transaction
	            transaction = session.beginTransaction();
	            // save the student object
	            Query query = session.createSQLQuery("select t.teacher_id, t.teacher_name from teacher t, subject s "
	            		+ "where t.teacher_id=s.teacher_id and s.subject_id="+subjectId);
	            System.out.println("Query: "+query.toString());
	            
	            List<Object[]> rows = query.list();
            	teachers = new ArrayList<Teacher>();
	            for(Object[] row : rows){
	            	Teacher teacher = new Teacher();
	            	teacher.setTeacherId(Integer.parseInt(row[0].toString()));
	            	teacher.setTeacherName(row[1].toString());
	            	System.out.println(teacher);
	            	teachers.add(teacher);
	            }
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
		return teachers;
	}
}
