package com.learning.vault.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hi from LoginServlet");
		PrintWriter out = response.getWriter();
		
		// create session
		System.out.println("Username: "+request.getParameter("username"));
		HttpSession session = request.getSession(true);
		session.setAttribute("username", request.getParameter("username"));
		
		response.sendRedirect("dashboard");
		System.out.println("Bye from LoginServlet");
	}

}
