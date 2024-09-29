package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class CallingServletFromServlet extends HttpServlet {

	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		int i=Integer.parseInt(req.getParameter("num1"));
		int j=Integer.parseInt(req.getParameter("num2"));
		int k=i+j;
		
		req.setAttribute("k", k); // so that we can use the value of k in another servlet
		// this will call another servlet if page for given url is also not present
		RequestDispatcher rd=req.getRequestDispatcher("sq");  // sq = url-mapping -- for that we have SqServlet
		rd.forward(req, res);
	}
	
}
