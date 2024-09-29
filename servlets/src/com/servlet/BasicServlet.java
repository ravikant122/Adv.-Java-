package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
// this class extends HttpServlet means now this class is a servlet
public class BasicServlet extends HttpServlet {
	
	// servlet -- used to send response(a html page) when request page(a html page) doesn't exists 
	// then servlet create that page that's why that page = dynamic page 
	// bcoz that was developed when request came
	
	// process of how that dynamic page is gonna build
	// -- first user search for abc.html in chrome browser -- he just browsing on the internet
	// -- then the request(abc.html) comes to webcontainer that is our tomcat server
	// -- tomcat(webcontainer) sees that abc.html doesn't exist anywhere in the system
// -- so it see in the web.xml(aka deployment descriptor) -- the mapping associated with abc(it see via url-mapping not servlet-name)
	// -- whichever servlet matches -- it will call that servlet's class's service method
	// -- after executing service method's code -- it will generate a page abc.html and anything which is to print will gonna print
	// 		on this page(abc.html)
	
	 
	/* methods of servlet 
init(ServletConfig config) --	initializes the servlet. It is the life cycle method of servlet and 
								invoked by the web container only once.
service(ServletRequest request,ServletResponse response) --	provides response for the incoming request. 
															It is invoked at each request by the web container.
destroy() -- is invoked only once and indicates that servlet is being destroyed.
getServletConfig() -- returns the object of ServletConfig.
getServletInfo() -- returns information about servlet such as writer, copyright, version etc. */
	
	// another methods like doGet, doPost they will be called by service method if service method is not present
	
	/* life cycle of a servlet
1. Servlet class is loaded.
2. Servlet instance is created.
3. init method is invoked.
4. service method is invoked.
5. destroy method is invoked. */
	
	
	// we've to make method name = service bcoz Request first always go to service method (look in the HttpServlet class)
	// we are overriding service method defined in HttpServlet
	@Override
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
		// give num1 and num2 in url bcoz no user for request for add.html
		// http://localhost:8080/JSPandServlet/add?num1=3&num2=4
		
		// if u want then first create another page(let page1.html) which takes two numbers and then submit will redirect to add.html
		// but add.html is not available so it will be created through this servlet and then num1 and num2 will be values given
		// in present page(page1.html)
		
		int i=Integer.parseInt(req.getParameter("num1"));
		int j=Integer.parseInt(req.getParameter("num2"));
		int k=i+j;
		
		// this will be written in add.html (dynamic page) -- that is bcoz of the mapping of this servlet in web.xml 
		PrintWriter out=res.getWriter();
		out.println(k);	
	}
	
}
