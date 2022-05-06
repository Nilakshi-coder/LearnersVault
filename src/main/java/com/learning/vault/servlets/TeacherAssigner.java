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

import com.learning.vault.dao.SubjectDao;
import com.learning.vault.dao.TeacherDao;
import com.learning.vault.entity.Student;
import com.learning.vault.entity.Subject;
import com.learning.vault.entity.Teacher;
import com.learning.vault.util.StringUtils;

/**
 * Servlet implementation class CourseEnrollmentServlet
 */
@WebServlet("/addSubjectForTeacher")
public class TeacherAssigner extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TeacherDao teacherDao = null;
	private SubjectDao subjectDao = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TeacherAssigner() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		teacherDao = new TeacherDao();
		subjectDao = new SubjectDao();
	}



	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			HttpSession httpSession = request.getSession(false);
			
			if(httpSession!=null) {				
				String _subjectId = request.getParameter("subjectId");
				System.out.println("subject: "+_subjectId);

				if(!StringUtils.isNullOrEmpty(_subjectId)) {
					int subjectId = Integer.parseInt(request.getParameter("subjectId"));
					Subject subject = subjectDao.getSubject(subjectId);
					request.setAttribute("subject", subject);
					List<Teacher> teachers = teacherDao.getAllTeachers();
					request.setAttribute("teachers", teachers);
				}
			}
		}catch (Exception e) {
			System.err.println("Error while calling Student Servlet "+e);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("assign-teacher.jsp");
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
