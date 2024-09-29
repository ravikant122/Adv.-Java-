package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/annot") // by using this, we don't have to write servlet mapping in web.xml 
					  // -- /annot = url-mapping -- so whenever annot.html will be requested then this servlet will be called bcoz
					  // -- we did the mapping here
public class Annotations extends HttpServlet{
	
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		// give num1 and num2 here
		// http://localhost:8080/JSPandServlet/annot?num1=2&num2=3
		int i=Integer.parseInt(req.getParameter("num1"));
		int j=Integer.parseInt(req.getParameter("num2"));
		int k=i+j;
		
		PrintWriter out=res.getWriter();
		out.println("value of i+j is "+k);
	}
	
}
