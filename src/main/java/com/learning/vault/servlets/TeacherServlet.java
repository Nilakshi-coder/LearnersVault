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
 * Servlet implementation class TeacherServlet
 */
@WebServlet("/teacher")
public class TeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TeacherDao teacherDao = null;
	private SubjectDao subjectDao = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherServlet() {
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
				System.out.println(httpSession.getId());
				System.out.println(httpSession.getAttribute("username"));
				
				String _subjectId = request.getParameter("subjectId");
				
				List<Teacher> teachers = null;
				if(StringUtils.isNullOrEmpty(_subjectId)) {
					teachers = teacherDao.getAllTeachers();
					
				}else {
					_subjectId = StringUtils.removeSlash(_subjectId);
					int subjectId = Integer.parseInt(_subjectId);
					teachers = teacherDao.getTeachersBySubject(subjectId);
					System.out.println(teachers);
					Subject subject = (Subject)subjectDao.getSubject(subjectId);
					String subjectName = subject.getSubjectName();
					//request.setAttribute("subject", subject);
					request.setAttribute("subjectId", subjectId);
					request.setAttribute("subjectName", subjectName);
					request.setAttribute("success",request.getAttribute("success"));
					//String successMsg = (String)request.getAttribute("success");
					//boolean messageFound = successMsg==null ? false : true;
				}
				request.setAttribute("teachers", teachers);
			}
			
		}catch (Exception e) {
			System.err.println("Error while calling Teacher Servlet "+e);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("teacher.jsp");
		rd.forward(request, response);
	}

}
