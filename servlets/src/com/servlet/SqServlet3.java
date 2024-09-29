package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class SqServlet3 extends HttpServlet {

	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
		HttpSession session=req.getSession();
		int k=(int)session.getAttribute("k");
		k=k*k;
		PrintWriter out=res.getWriter();
		out.println("value of k*k in another servlet is "+k);
		
		// we can also delete attributes from session
		session.removeAttribute("k");
		// after this we can't use k
	}
	
}
