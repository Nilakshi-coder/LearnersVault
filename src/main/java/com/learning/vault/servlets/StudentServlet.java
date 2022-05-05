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
import com.learning.vault.dao.CourseDao;
import com.learning.vault.dao.StudentDao;
import com.learning.vault.entity.Student;
import com.learning.vault.entity.Subject;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/student")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDao studentDao = null;
	private CourseDao courseDao = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void init() {
		studentDao = new StudentDao();
		courseDao  = new CourseDao();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession httpSession = request.getSession(false);
			
			if(httpSession!=null) {
				String action = request.getRequestURI();
				System.out.println("Parameter: "+request.getParameter("courseId"));
				String _courseId = (String) request.getParameter("courseId");

				List<Student> students = null;
				if(_courseId==null) {
					students = studentDao.getAllStudents();
				}else {
					_courseId = _courseId.replace("/", "");
					System.out.println("Parameter: "+_courseId);
					int courseId = Integer.parseInt(_courseId);
					students = studentDao.getStudentsByCourse(courseId);
					String courseName = courseDao.getCourse(courseId).getCourseName();
					request.setAttribute("courseName", courseName);
				}
				
				request.setAttribute("students", students);
			}
		}catch (Exception e) {
			System.err.println("Error while calling Student Servlet "+e);
		}

		RequestDispatcher rd = request.getRequestDispatcher("student.jsp");
		rd.forward(request, response);
	}

}
