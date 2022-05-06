package com.learning.vault.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.learning.vault.config.HibernateUtil;
import com.learning.vault.entity.Course;
import com.learning.vault.entity.Student;
import com.learning.vault.entity.Subject;
import com.learning.vault.entity.Teacher;

public class CourseDao {

	public void saveCourse(Course course) {
		Transaction transaction = null;
		Session session = null;
		try {
			session = HibernateUtil.buildSessionFactory().openSession();

			if (session != null) {
				// start a transaction
				transaction = session.beginTransaction();
				// save the Course object
				session.save(course);
				// commit transaction
				transaction.commit();
			}
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			System.err.println("Error while saving Course details in DB: " + e);
		} finally {
			if (session != null)
				session.close();
		}
	}

	public void updateCourse(Course course) {
		Transaction transaction = null;
		Session session = null;
		try {
			session = HibernateUtil.buildSessionFactory().openSession();

			if (session != null) {
				// start a transaction
				transaction = session.beginTransaction();
				// save the Course object
				session.update(course);
				// commit transaction
				transaction.commit();
			}
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			System.err.println("Error while updating Course details in DB: " + e);
		} finally {
			if (session != null)
				session.close();
		}
	}

	public void deleteCourse(Course course) {
		Transaction transaction = null;
		Session session = null;
		try {
			session = HibernateUtil.buildSessionFactory().openSession();

			if (session != null) {
				// start a transaction
				transaction = session.beginTransaction();
				// save the Course object
				session.delete(course);
				// commit transaction
				transaction.commit();
			}
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			System.err.println("Error while deleting Course details from DB: " + e);
		} finally {
			if (session != null)
				session.close();
		}
	}

	public Course getCourse(int id) {
		Transaction transaction = null;
		Session session = null;
		Course course = null;
		try {
			session = HibernateUtil.buildSessionFactory().openSession();

			if (session != null) {
				// start a transaction
				transaction = session.beginTransaction();
				// save the Course object
				course = (Course) session.get(Course.class, id);
				// commit transaction
				transaction.commit();
			}
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			System.err.println("Error while fetching Course details from DB: " + e);
		} finally {
			if (session != null)
				session.close();
		}
		return course;
	}

	public List<Subject> getSubjects(int id) {
		Transaction transaction = null;
		Session session = null;
		List<Subject> subjects = null;
		try {
			session = HibernateUtil.buildSessionFactory().openSession();

			if (session != null) {
				// start a transaction
				transaction = session.beginTransaction();
				// save the Course object
				Course course = (Course) session.get(Course.class, id);

				if (course != null) {
					subjects = course.getSubjects();
				}

				// commit transaction
				transaction.commit();
			}
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			System.err.println("Error while fetching Subject details from DB: " + e);
		} finally {
			if (session != null)
				session.close();
		}
		return subjects;
	}

	public List<Subject> getNonAssignedSubjects(int courseId) {
		Transaction transaction = null;
		Session session = null;
		List<Subject> subjects = new ArrayList<Subject>();
		try {
			session = HibernateUtil.buildSessionFactory().openSession();

			if (session != null) {
				// start a transaction
				transaction = session.beginTransaction();
				// save the Course object
				List<Subject> _subjects = (List<Subject>) session.createQuery("from Subject").list();
				Course course = (Course) session.get(Course.class, courseId);

				subjects.addAll(_subjects);

				// commit transaction
				transaction.commit();
			}
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			System.err.println("Error while fetching Subject details from DB: " + e);
		} finally {
			if (session != null)
				session.close();
		}
		return subjects;
	}

	public List<Course> getAllCourses() {
		Transaction transaction = null;
		Session session = null;
		List<Course> courses = null;
		try {
			session = HibernateUtil.buildSessionFactory().openSession();

			if (session != null) {
				// start a transaction
				transaction = session.beginTransaction();
				// save the Course object
				courses = session.createQuery("from Course").list();
				// commit transaction
				transaction.commit();
			}
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			System.err.println("Error while fetching Course details from DB: " + e);
		} finally {
			if (session != null)
				session.close();
		}

		return courses;
	}

	public void updateSubject(Course course, Subject subject, Student student) {
		Transaction transaction = null;
		Session session = null;
		try {
			session = HibernateUtil.buildSessionFactory().openSession();

			if (session != null) {
				// start a transaction
				transaction = session.beginTransaction();
				// save the Subject object

				if (course != null) {
					course = (Course) session.get(Course.class, course.getCourseId());
					List<Subject> courseSubjects = course.getSubjects() == null ? new ArrayList<Subject>()
							: course.getSubjects();

					if (subject != null) {
						boolean found = courseSubjects.stream()
								.anyMatch(s -> s.getSubjectId() == subject.getSubjectId());

						if (!found) {
							System.out.println("Subject is not present in Course");
							courseSubjects.add(subject);
							subject.setCourse(course);
							course.setSubjects(courseSubjects);
							session.update(subject);
						}
					}
					session.update(course);

				}
				// commit transaction
				transaction.commit();

			}
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			System.err.println("Error while updating Subject details in DB: " + e);
		} finally {
			if (session != null)
				session.close();
		}
	}

	public void deleteSubject(Course course, Subject subject) {
		Transaction transaction = null;
		Session session = null;
		try {
			session = HibernateUtil.buildSessionFactory().openSession();

			if (session != null) {
				// start a transaction
				transaction = session.beginTransaction();
				// save the Subject object
				if (course != null) {

					if (subject != null) {
						subject.setCourse(null);
					}
					session.update(subject);
					session.update(course);
				}
				// commit transaction
				transaction.commit();
			}
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			System.err.println("Error while deleting Subject details from DB: " + e);
		} finally {
			if (session != null)
				session.close();
		}
	}
}
