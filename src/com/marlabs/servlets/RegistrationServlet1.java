package com.marlabs.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class RegistrationServlet1
 */
public class RegistrationServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeDAO employeeDAO;

    /**
     * Default constructor. 
     */
    public RegistrationServlet1() {
        // TODO Auto-generated constructor stub
    	System.out.println("I am from registrationServlets Constructor");
    	employeeDAO=new EmployeeDAO();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("I am from registrationServlets init");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("I am from registrationServlets destroy");
		employeeDAO=null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("I am from registrationServlets doGet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("I am from registrationServlets doPost");
		int empNumber=Integer.parseInt(request.getParameter("empNumber"));
		String empName=request.getParameter("empName");
		double empSalary=Integer.parseInt(request.getParameter("empSalary"));
		int departmentNumber= Integer.parseInt(request.getParameter("DepartmentNumber"));
		response.setContentType("text/html");
		
		//JDBC logic
		EmployeeVO valueObject=new EmployeeVO(); 
		valueObject.setEmpNumber(empNumber);
		valueObject.setEmpName(empName);
		valueObject.setEmpSalary(empSalary);
		valueObject.setDepartmentNumber(departmentNumber);
		boolean result=false;
		RequestDispatcher dispatcher=null;
		try {
			result = employeeDAO.registerEmployee(valueObject);
			if(result) {
				dispatcher=request.getRequestDispatcher("RegistrationSuccess.jsp");
				dispatcher.forward(request, response);
				
			}
		} catch (SQLException e) {
			dispatcher=request.getRequestDispatcher("RegistrationFailure.jsp");
			request.setAttribute("message",e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	

}
