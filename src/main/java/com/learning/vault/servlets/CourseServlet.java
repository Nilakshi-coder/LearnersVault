package com.learning.vault.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.learning.vault.dao.CourseDao;
import com.learning.vault.entity.Course;

/**
 * Servlet implementation class CourseServlet
 */
//@WebServlet("/course")
public class CourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CourseDao courseDao = null;

	public void init() {
		courseDao = new CourseDao();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CourseServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession httpSession = request.getSession(false);
		
		String action = request.getRequestURI();
		System.out.println("ContextPath: "+action);

		if (httpSession != null) {
			showCourses(request, response);
		}
	}

	private void showCourses(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard.jsp");
		try {
			List<Course> courses = courseDao.getAllCourses();
			request.setAttribute("courses", courses);
			dispatcher = request.getRequestDispatcher("course.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			System.err.println("Error while retrieving course list from DB: " + e);
		}
	}

}
