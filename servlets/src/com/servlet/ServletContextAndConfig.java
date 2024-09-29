package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial") 
public class ServletContextAndConfig extends HttpServlet{

	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		
		// servlet context -- parameters that is accessible by all servlet
		// defined openly in web.xml(not in some particular servlet)
		PrintWriter out=res.getWriter();
		out.print("Hi ");
		
		ServletContext cntxt=getServletContext();
		String str=cntxt.getInitParameter("name");
		out.println(str);
			
		
		// servlet config -- parameter accessed by particular servlet means any servlet can make some parameters for itself
		// that is accessible by that servlet only -- defined in a particular servlets
		ServletConfig cnfg=getServletConfig();
		str=cnfg.getInitParameter("name");
		out.println("hi "+str);
		
	}
	
	
}
