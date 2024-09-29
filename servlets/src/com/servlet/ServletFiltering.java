package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/filtering")
public class ServletFiltering extends HttpServlet {

	/*A filter is an object that is invoked at the preprocessing and postprocessing of a request.
It is mainly used to perform filtering tasks such as conversion, logging, compression, encryption and decryption,
input validation etc.
The servlet filter is pluggable, i.e. its entry is defined in the web.xml file,
if we remove the entry of filter from the web.xml file,
filter will be removed automatically and we don't need to change the servlet.
we can add multiple filters to a servlet
 */
	
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		PrintWriter out=res.getWriter();
		String name=req.getParameter("name").toString();
		int id=Integer.parseInt(req.getParameter("id"));
		System.out.println(name);
		System.out.println(id);
		out.println(name+" "+id);
	}
	
}
