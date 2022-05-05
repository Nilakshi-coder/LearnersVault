package com.learning.vault.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.learning.vault.dao.CourseDao;
import com.learning.vault.dao.SubjectDao;
import com.learning.vault.entity.Course;
import com.learning.vault.entity.Subject;

/**
 * Servlet implementation class CourseServlet
 */
public class CourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CourseDao courseDao;
	private SubjectDao subjectDao;

	public void init() {
		courseDao = new CourseDao();
		subjectDao = new SubjectDao();
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

		String action = request.getServletPath();

		HttpSession httpSession = request.getSession(true);

		if(httpSession!=null) {

			switch (action) {
			case "course/assignSubjects":
				assignSubjectsToCourses(request, response);
				break;

			case "course/showSubjects":
				showSubjects(request, response);
				break;

			default:
				showCourses(request, response);
				break;
			}
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		service(request, response);
	}

	private void showSubjects(HttpServletRequest request, HttpServletResponse response) {
		try {
			String _courseId = (String) request.getParameter("courseId");

			if (_courseId != null && !"".equals(_courseId)) {
				int courseId = Integer.parseInt(_courseId);
				List<Subject> subjects = courseDao.getSubjects(courseId);

				request.setAttribute("subjects", subjects);
				request.getRequestDispatcher("show-subjects.jsp").forward(request, response);
			}
		} catch (Exception e) {
			System.err.println("Error while retrieving subject list from DB: " + e);
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

	private void assignSubjectsToCourses(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard.jsp");
		try {
			String _courseId = (String) request.getParameter("course");
			String _subjectId = (String) request.getParameter("subject");

			if (_courseId != null && !"".equals(_courseId) && _subjectId != null && !"".equals(_subjectId)) {
				int courseId = Integer.parseInt(_courseId);
				Course course = courseDao.getCourse(courseId);

				int subjectId = Integer.parseInt(_subjectId);
				Subject subject = subjectDao.getSubject(subjectId);

				List<Subject> subjectList = course.getSubjects();
				if (subjectList == null) {
					subjectList = new ArrayList<Subject>();
				}
				subjectList.add(subject);
				course.setSubjects(subjectList);
				courseDao.updateCourse(course);

				dispatcher = request.getRequestDispatcher("course.jsp");
				dispatcher.forward(request, response);
			}

		} catch (Exception e) {
			System.err.println("Error while retrieving course list from DB: " + e);
		}
	}

}
