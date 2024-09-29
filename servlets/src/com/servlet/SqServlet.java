package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class SqServlet extends HttpServlet {

	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
		int k=(int) req.getAttribute("k");
		k=k*k;
		PrintWriter out=res.getWriter();
		out.println("value of k*k in another servlet is "+k);	
	}

}
