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

import org.hibernate.SessionFactory;

import com.learning.vault.config.HibernateUtil;
import com.learning.vault.dao.CourseDao;
import com.learning.vault.dao.SubjectDao;
import com.learning.vault.entity.Subject;

/**
 * Servlet implementation class SubjectServlet
 */
@WebServlet("/subject")
public class SubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SubjectDao subjectDao = null;
	CourseDao courseDao = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubjectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    

	@Override
	public void init() throws ServletException {
		subjectDao = new SubjectDao();
		courseDao = new CourseDao();
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

			if (httpSession != null) {
				String action = request.getRequestURI();
				System.out.println("Parameter: "+request.getParameter("courseId"));
				String _courseId = (String) request.getParameter("courseId");

				List<Subject> subjects = null;
				if(_courseId==null) {
					subjects = subjectDao.getAllSubjects();
				}else {
					_courseId = _courseId.replace("/", "");
					System.out.println("Parameter: "+_courseId);
					int courseId = Integer.parseInt(_courseId);
					subjects = subjectDao.getSubjectsByCourseId(courseId);
					String courseName = courseDao.getCourse(courseId).getCourseName();
					request.setAttribute("courseName", courseName);
				}
				request.setAttribute("subjects", subjects);
			}
			
		}catch (Exception e) {
			System.err.println("Error while calling Subject Servlet "+e);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("subject.jsp");
		rd.forward(request, response);
	}

}
