package com.learning.vault.servlets;

import java.io.IOException;

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
import com.learning.vault.entity.Teacher;
import com.learning.vault.util.StringUtils;

/**
 * Servlet implementation class SaveSubjectServlet
 */
@WebServlet("/saveCourse")
public class SaveCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CourseDao courseDao = null;
	private SubjectDao subjectDao = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SaveCourseServlet() {
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
		String nextReq = "course?";
		try {
			HttpSession httpSession = request.getSession(false);

			if(httpSession!=null) {				
				String _courseId = request.getParameter("courseId");
				System.out.println("course: "+_courseId);
				String _subjectId = request.getParameter("subjectId");
				System.out.println("subject: "+_subjectId);
				String action = request.getParameter("action");
				System.out.println("Save: "+action);

				if(!StringUtils.isNullOrEmpty(_courseId) && !StringUtils.isNullOrEmpty(_subjectId) && !StringUtils.isNullOrEmpty(action)) {
					int courseId = Integer.parseInt(_courseId);
					int subjectId = Integer.parseInt(_subjectId);
					Course course = courseDao.getCourse(courseId);
					Subject subject = subjectDao.getSubject(subjectId);
					request.setAttribute("subject", subject);
					request.setAttribute("course", course);
					
					if("Update".equals(action)) {			
						courseDao.updateSubject(course, subject, null);
						request.setAttribute("success", "Subject updated successfully!");
					}else if("Delete".equals(action)) {
						courseDao.deleteSubject(course, subject);
						request.setAttribute("success", "Subject deleted successfully!");
					}
					nextReq = nextReq.concat("courseId="+course.getCourseId());
				}
			}
		}catch (Exception e) {
			System.err.println("Error while calling Student Servlet "+e);
		}

		RequestDispatcher rd = request.getRequestDispatcher(nextReq);
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
