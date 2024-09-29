package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class DoPostAndDoGet extends HttpServlet{

	// first service method will be called in HttpServlet class
	// then service method will called these methods
	
	// if method = Post then this will be called
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
		int i=Integer.parseInt(req.getParameter("num1"));
		int j=Integer.parseInt(req.getParameter("num2"));
		int k=i+j;
		
		// it will write on html page
		PrintWriter out=res.getWriter();
		out.println(k);	
	}
	
	// if method = Get then this will be called
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {
		int i=Integer.parseInt(req.getParameter("num1"));
		int j=Integer.parseInt(req.getParameter("num2"));
		int k=i+j;
		
		// it will write on html page
		PrintWriter out=res.getWriter();
		out.println(k);	
	}
	
}
