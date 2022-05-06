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
import com.learning.vault.dao.TeacherDao;
import com.learning.vault.entity.Subject;
import com.learning.vault.entity.Teacher;

/**
 * Servlet implementation class SubjectServlet
 */
@WebServlet("/subject")
public class SubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SubjectDao subjectDao = null;
	CourseDao courseDao = null;
	TeacherDao teacherDao = null;

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
		teacherDao = new TeacherDao();
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
				String _courseId = (String) request.getParameter("courseId");
				String _teacherId = (String) request.getParameter("teacherId");
				String action = (String) request.getParameter("Save");
				String _subject = (String) request.getParameter("subject");
				
				System.out.println("courseId: "+_courseId+" _teacherId: "+_teacherId+" subject: "+_subject+" action: "+action);
				
				List<Subject> subjects = null;
				if(_courseId==null && _teacherId==null) {
					subjects = subjectDao.getAllSubjects();					
					
				}else if(_courseId!=null){
					_courseId = _courseId.replace("/", "");
					int courseId = Integer.parseInt(_courseId);
					subjects = subjectDao.getSubjectsByCourse(courseId);
					String courseName = courseDao.getCourse(courseId).getCourseName();
					request.setAttribute("courseName", courseName);
					
				}else if(_teacherId!=null) {
					_teacherId = _teacherId.replace("/", "");
					System.out.println("Parameter: "+_teacherId);
					int teacherId = Integer.parseInt(_teacherId);

					if("Save".equals(action) && _subject!=null) {
						int subjectId = Integer.parseInt(_subject);						
						teacherDao.assignSubject(teacherId, subjectId);
					}
					
					subjects = subjectDao.getSubjectsByTeacher(teacherId);
					Teacher teacher = teacherDao.getTeacher(teacherId);
					request.setAttribute("teacher", teacher);
					
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
