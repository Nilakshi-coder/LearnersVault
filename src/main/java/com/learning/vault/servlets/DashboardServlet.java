package com.learning.vault.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.learning.vault.config.HibernateUtil;
import com.learning.vault.entity.Student;

/**
 * Servlet implementation class DashboardServlet
 */
public class DashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DashboardServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);

		if(session!=null) {
			System.out.println("sessionId: "+session.getId());
			PrintWriter out = response.getWriter();

			System.out.println("Username: "+session.getAttribute("username"));
			request.getRequestDispatcher("dashboard.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

}
