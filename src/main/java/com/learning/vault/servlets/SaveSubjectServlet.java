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
import com.learning.vault.entity.Subject;
import com.learning.vault.entity.Teacher;
import com.learning.vault.util.StringUtils;

/**
 * Servlet implementation class SaveSubjectServlet
 */
@WebServlet("/saveSubject")
public class SaveSubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TeacherDao teacherDao = null;
	private SubjectDao subjectDao = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SaveSubjectServlet() {
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
		String nextReq = "teacher?";
		try {
			HttpSession httpSession = request.getSession(false);

			if(httpSession!=null) {				
				String _subjectId = request.getParameter("subjectId");
				System.out.println("subject: "+_subjectId);
				String _teacherId = request.getParameter("teacherId");
				System.out.println("Teacher: "+_teacherId);
				String action = request.getParameter("action");
				System.out.println("Save: "+action);

				if(!StringUtils.isNullOrEmpty(_subjectId) && !StringUtils.isNullOrEmpty(_teacherId) && !StringUtils.isNullOrEmpty(action)) {
					int subjectId = Integer.parseInt(_subjectId);
					int teacherId = Integer.parseInt(_teacherId);
					Subject subject = subjectDao.getSubject(subjectId);
					Teacher teacher = teacherDao.getTeacher(teacherId);
					request.setAttribute("subject", subject);
					request.setAttribute("teacher", teacher);
					
					if("Update".equals(action)) {			
						subjectDao.updateSubject(subject, null, teacher);
						request.setAttribute("success", "Teacher updated successfully!");
					}else if("Delete".equals(action)) {
						subjectDao.deleteTeacher(subject, teacher);
						request.setAttribute("success", "Teacher deleted successfully!");
					}
					nextReq = nextReq.concat("subjectId="+subject.getSubjectId());
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
