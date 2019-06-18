package com.marlabs.configandcontext;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContextInfoServlet
 */
public class ContextInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContextInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		out.println("<h3>request object parameters</h3>");
		out.println("<br>");
		out.println("UserName: "+userName);
		out.println("<br>");
		out.println("UserPassword: "+userPassword);
		out.println("<br>");
		ServletConfig config=getServletConfig();
		ServletContext context=config.getServletContext();
		out.println("Refernce of servletContext: "+context);
		out.println("<br>");
		out.println("servletContext Name: "+context.getServletContextName());
		out.println("<br><hr>");
		out.println("<h3>servlet context init parameters</h3><br>");
		java.util.Enumeration<String> e=context.getInitParameterNames();
		while(e.hasMoreElements()) {
			out.println("<br>");
			String name= e.nextElement();
			String value= context.getInitParameter(name);
			out.println(name+" : "+value);
		}
		
		//Set Attribute to context object
		List<String> list= new ArrayList<String>();
		list.add("User1");
		list.add("User2");
		list.add("User3");
		list.add("User4");
		context.setAttribute("userList", list);
		context.setAttribute("UserCount", list.size());
		
		
		//get Attribute for context object
		out.println("<br><hr>");
		out.println("<h3>servlet context get Attribute UserList</h3><br>");
		@SuppressWarnings("unchecked")
		List<String> userList=(List<String>) context.getAttribute("userList");
		Iterator<String> iterator=userList.iterator();
		while(iterator.hasNext()) {
			out.println("<br>");
			out.println(iterator.next());
		}
		//get attribute for all the attributes
		out.println("<br><hr>");
		out.println("<h3>servlet context get all Attribute </h3><br>");
		java.util.Enumeration<String> e1=context.getAttributeNames();
		while(e1.hasMoreElements()) {
			out.println("<br>");
			String name= e1.nextElement();
			String value= context.getAttribute(name).toString();
			out.println(name+" : "+value);
		}
		out.println("</html></body>");
	}

}
