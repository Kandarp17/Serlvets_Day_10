package com.marlabs.configandcontext;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConfigInfoServlet
 */
public class ConfigInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfigInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
        System.out.println("inside constructor");
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String userName=request.getParameter("userName");
		String userPassword=request.getParameter("userPassword");
		out.println("<html><body>");
		out.println("<br>");
		out.println("UserName: "+userName);
		out.println("<br>");
		out.println("<UserPassword: "+userPassword);
		out.println("<br>");
		ServletConfig config=getServletConfig();
		double hra= Double.parseDouble(config.getInitParameter("HRA"));
		double da= Double.parseDouble(config.getInitParameter("DA"));
		double basic= Double.parseDouble(config.getInitParameter("Basic"));
		out.println("<h3>servlet config parameters</h3><br>");
		out.println("<br>");
		out.println("HRA: "+hra);
		out.println("<br>");
		out.println("DA: "+da);
		out.println("<br>");
		out.println("BAsic: "+basic);
		out.println("<br>");
		out.println("Logical Servlet Name: "+config.getServletName());
		out.println("<br>");
		out.println("Refernce of servletContext: "+config.getServletContext());
		out.println("<br><hr>");
		out.println("<h3>servlet config init parameters</h3><br>");
		java.util.Enumeration<String> e=config.getInitParameterNames();
		while(e.hasMoreElements()) {
			out.println("<br>");
			String name= e.nextElement();
			String value= request.getParameter(name);
			out.println(name+" : "+value);
		}
		out.println("</html></body>");
	}

}
