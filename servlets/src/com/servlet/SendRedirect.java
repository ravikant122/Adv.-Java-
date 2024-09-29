package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class SendRedirect extends HttpServlet {
	
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		int i=Integer.parseInt(req.getParameter("num1"));
		int j=Integer.parseInt(req.getParameter("num2"));
		int k=i+j;
		
		// client sent the two no in this request but we are saying to client that now send request to servlet to sq2
		// but client not gonna send the two no again 
		// so we've to manipulate the url -- UrlRewriting
		// and the new URL = request - so now get k from req.getParameter("k")
		res.sendRedirect("sq2?k="+k);  // sendRedirect takes either html or jsp or servlet name
		// also It accepts relative as well as absolute URL.
		// It always sends a new request means req and res of redirected page will be diff from here 
		
		
		// if u want to send same req and res to redirected page then use forword() method
		// syntax is -- req.getRequestDispatcher("url").forword(req,res);  -- that's how it send same req and res to new url
//		RequestDispatcher rd=req.getRequestDispatcher("sq");  // sq = url-mapping -- for that we have SqServlet
//		rd.forward(req, res);
	}
}
