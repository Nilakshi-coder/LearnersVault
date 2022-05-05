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

import com.learning.vault.dao.TeacherDao;
import com.learning.vault.entity.Teacher;

/**
 * Servlet implementation class TeacherServlet
 */
@WebServlet("/teacher")
public class TeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TeacherDao teacherDao = null;
       
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
				
				List<Teacher> teachers = teacherDao.getAllTeachers();
				request.setAttribute("teachers", teachers);
			}
			
		}catch (Exception e) {
			System.err.println("Error while calling Teacher Servlet "+e);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("teacher.jsp");
		rd.forward(request, response);
	}

}
