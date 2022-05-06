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

/**
 * Servlet implementation class CourseEnrollmentServlet
 */
@WebServlet("/addSubjectForTeacher")
public class SubjectAssignee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TeacherDao teacherDao = null;
	private SubjectDao subjectDao = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SubjectAssignee() {
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
				String action = request.getRequestURI();
				System.out.println("Parameter: "+request.getParameter("teacherId"));
				String _teacherId = (String) request.getParameter("teacherId");

				Teacher teacher = null;
				List<Subject> subjects = null;
				if(_teacherId==null) {
					subjects = subjectDao.getAllSubjects();
				}else {
					_teacherId = _teacherId.replace("/", "");
					System.out.println("Parameter: "+_teacherId);
					int teacherId = Integer.parseInt(_teacherId);
					teacher = teacherDao.getTeacher(teacherId);
					subjects = subjectDao.getAllSubjects();
					request.setAttribute("teacher", teacher);
					request.setAttribute("subjects", subjects);
				}
				
				request.setAttribute("students", subjects);
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
