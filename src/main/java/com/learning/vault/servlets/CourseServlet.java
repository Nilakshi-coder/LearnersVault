package com.learning.vault.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.learning.vault.config.HibernateUtil;
import com.learning.vault.entity.Course;

/**
 * Servlet implementation class CourseServlet
 */
public class CourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseServlet() {
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
				dbSession.beginTransaction();
				
				List<Course> courses = (List<Course>) dbSession.createQuery("from Course").list();
				
				request.setAttribute("courseList", courses);
				
				dbSession.getTransaction().commit();
				dbSession.close();
			}
		}catch (Exception e) {
			System.err.println("Error while calling Student Servlet "+e);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("course.jsp");
		rd.forward(request, response);
	}

}
