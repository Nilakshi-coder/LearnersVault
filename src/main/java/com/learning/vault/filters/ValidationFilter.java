package com.learning.vault.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class ValidationFilter
 */
public class ValidationFilter implements Filter {

    /**
     * Default constructor. 
     */
    public ValidationFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("Hi from Filter");
		
		System.out.println(request.getParameter("username"));
		String username = request.getParameter("username");
		System.out.println("Username: "+username);
		String password = request.getParameter("password");
		System.out.println("Password: "+password);
		
		if(validateUserCredentials(username, password)) {
			request.setAttribute("username", username);
			chain.doFilter(request, response);
		}else {
			PrintWriter out=response.getWriter();
			request.setAttribute("loginError","Login failed! Invalid credentials");
			request.getRequestDispatcher("index.jsp").include(request, response);
		}
		
		System.out.println("Bye from Filter");
	}
	
	private boolean validateUserCredentials(String username, String password) {
		return (username!=null && password!=null && username.trim().equals("admin") && password.matches("admin@123"));
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
