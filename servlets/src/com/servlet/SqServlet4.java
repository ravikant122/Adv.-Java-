package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class SqServlet4 extends HttpServlet {

	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
		int k=0;
		// we can have more than one cookies
		Cookie[] cookies=req.getCookies();
		for(Cookie cookie:cookies) {
			if(cookie.getName().equals("k"))
				k=Integer.parseInt(cookie.getValue());
		}
		k=k*k;
		PrintWriter out=res.getWriter();
		out.println("value of k*k in another servlet is "+k);
	}
	
}
