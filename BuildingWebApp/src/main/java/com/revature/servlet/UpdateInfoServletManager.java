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
 * Servlet implementation class UpdateInfoServletManager
 */
public class UpdateInfoServletManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateInfoServletManager() {
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
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		//PrintWriter pw = response.getWriter();

		Employee e = new Employee();

		try {
			EmployeeDaoImpl usr = new EmployeeDaoImpl();
			if (request.getParameter("username") != null) {
				System.out.println(request.getParameter("username"));
				e.setFirstName(request.getParameter("username"));
			} else
				e.setFirstName(null);
			if (request.getParameter("firstName") != null) {
				System.out.println(request.getParameter("firstName"));
				e.setFirstName(request.getParameter("firstName"));
			} else
				e.setFirstName(null);
			if (request.getParameter("lastName") != null) {
				e.setLastName(request.getParameter("lastName"));
			} else
				e.setLastName(null);	
			if (request.getParameter("password") != null) {
				e.setLastName(request.getParameter("password"));
			} else
				e.setLastName(null);
			usr.updateInfoManager(e, request.getParameter("username"));
			response.sendRedirect("ViewAllEmployeePage.html");
		} catch (Exception e2) {
			e2.printStackTrace();
		}

	}

}
