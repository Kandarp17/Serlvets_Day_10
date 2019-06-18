package com.marlabs.requestinfo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestHeaderInfoServlet
 */
public class RequestHeaderInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestHeaderInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
        System.out.println("I am from servlet constructor");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out= response.getWriter();
		out.println("<html><body>");
		out.println("<h3>Header Information Example</h3>");
		java.util.Enumeration<String> e=request.getHeaderNames();
		while(e.hasMoreElements()) {
			String name= e.nextElement();
			String value= request.getHeader(name);
			out.println(name+" : "+value);
		}
		out.println("<br>");
		out.println("========================================");
		out.println("<h3>Header Information Example</h3>");
		e=request.getParameterNames();
		while(e.hasMoreElements()) {
			String name= e.nextElement();
			String value= request.getParameter(name);
			out.println(name+" : "+value);
		}
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
