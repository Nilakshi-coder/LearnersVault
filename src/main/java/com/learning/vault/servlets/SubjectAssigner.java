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

import com.learning.vault.dao.CourseDao;
import com.learning.vault.dao.SubjectDao;
import com.learning.vault.entity.Course;
import com.learning.vault.entity.Subject;
import com.learning.vault.util.StringUtils;

/**
 * Servlet implementation class CourseEnrollmentServlet
 */
@WebServlet("/addSubjectsForCourse")
public class SubjectAssigner extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CourseDao courseDao = null;
	private SubjectDao subjectDao = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SubjectAssigner() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		courseDao = new CourseDao();
		subjectDao = new SubjectDao();
	}



	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			HttpSession httpSession = request.getSession(false);
			
			if(httpSession!=null) {				
				String _courseId = request.getParameter("courseId");
				System.out.println("course: "+_courseId);

				if(!StringUtils.isNullOrEmpty(_courseId)) {
					int courseId = Integer.parseInt(request.getParameter("courseId"));
					Course course = courseDao.getCourse(courseId);
					request.setAttribute("course", course);
					List<Subject> subjects = courseDao.getNonAssignedSubjects(courseId);
					request.setAttribute("subjects", subjects);
				}
			}
		}catch (Exception e) {
			System.err.println("Error while calling Student Servlet "+e);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("assign-subject.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
