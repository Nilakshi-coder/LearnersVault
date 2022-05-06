package com.learning.vault.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.learning.vault.config.HibernateUtil;
import com.learning.vault.entity.Course;
import com.learning.vault.entity.Student;

/**
 * Servlet implementation class CourseEnrollmentServlet
 */
@WebServlet("/enrollStudent")
public class CourseEnrollmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CourseEnrollmentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {

			SessionFactory factory = HibernateUtil.buildSessionFactory();
			System.out.println("SessionFactory: "+factory);

			if(factory!=null) {
				Session dbSession = factory.openSession();

				try {
					dbSession.beginTransaction();
	
					System.out.println("student: "+ request.getParameter("student"));
	
					int studentId = Integer.parseInt(request.getParameter("student"));
					Student student = (Student)dbSession.get(Student.class, studentId);
					request.setAttribute("student", student);
					
					List<Course> courses = (List<Course>)dbSession.createQuery("from Course").list();
					request.setAttribute("courseList", courses);
	
					
				}catch (Exception e) {
					System.err.println("Error while calling fetching student and courseData "+e);
				}finally {
					dbSession.getTransaction().commit();
					dbSession.close();
				}
			}

		}catch (Exception e) {
			System.err.println("Error while calling CourseEnrollmentServlet "+e);
		}

		RequestDispatcher rd = request.getRequestDispatcher("courseEnroll.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
