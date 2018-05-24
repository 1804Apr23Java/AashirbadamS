package com.revature.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.BackEnd.EmployeeDaoImpl;
import com.revature.domain.Employee;

/**
 * Servlet implementation class ResetPasswordServlet
 */
public class ResetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResetPasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		Employee e = new Employee();
		EmployeeDaoImpl ed = new EmployeeDaoImpl();
		HttpSession session = request.getSession();
		response.setContentType("test/html");
		String uName = (String) session.getAttribute("username");
		String username = request.getParameter("username");
	/*	String firstname = request.getParameter("firstName");
		String lastname = request.getParameter("lastName");
		String role = request.getParameter("Role");*/

		if (e.getUsername().equals(username)) /*&& e.getFirstName().equals(firstname) && e.getLastName().equals(lastname)
				&& e.getRole().equals(role)*/ {
			
			String password = request.getParameter("password");
			
			ed.updatepassword(username,password);
			
			
		} else {
			System.out.println("Invalid Credential");
		}

	}

}
