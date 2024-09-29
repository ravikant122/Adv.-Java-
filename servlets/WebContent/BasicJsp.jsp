<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<!-- Theory -->
	<!-- why jsp over servlet -->
	<!-- 1. extension to servlet -> We can use all the features of the Servlet in JSP. In addition to, 
we can use implicit objects, predefined tags, expression language and Custom tags in JSP, that makes JSP development easy-->
	<!-- 2. Fast Development: No need to recompile and redeploy -->
	<!-- 3. Less code than Servlet -->
	<!-- 4. easy to maintain -->
	
	<!-- The Lifecycle of a JSP Page :
Translation of JSP Page
Compilation of JSP Page
Classloading (the classloader loads class file)
Instantiation (Object of the Generated Servlet is created).
Initialization ( the container(Tomcat) invokes jspInit() method).
Request processing ( the container invokes _jspService() method).
Destroy ( the container invokes jspDestroy() method) -->
	
	<!-- inside these code = java code, called as scriplet -->
	<% 
		int i=Integer.parseInt(request.getParameter("num1"));
		int j=Integer.parseInt(request.getParameter("num2"));
		// this HttpSession is same as of servlet -- both belongs to javax.servlet.http.HttpSession class
		// that's why we can all features of servlet in jsp
		HttpSession sesson=request.getSession();
		int k=i+j;
		out.println(k);	
	%>
	
	<!-- how this will gonna work without error and without importing any libs -->
	<!-- we write JSP but tomcat converts that JSP into Servlet -- tomcat translate JSP into Servlet -->
	<!-- class name = addjsp -->
	<!-- automatically extends HttpServlet -->
	<!-- and provide a service method with request and response object -->
	<!-- and provide other objects like 
		session(Session), 
		out(PrintWriter), 
		request(HttpServletRequest), 
		response(HttpServletRequest),
		pageContext(PageContext), 
		application(ServletContext),
		config(ServletConfig)
		page(Object)
		exception(Throwable) -->
	<!-- these objects = implicit objects -->
	<!-- after all objects in service method - it will copy the scriplet code -->
	
	<!-- for code to be outside but inside class -->
	<!-- like variable initialization and some other methods -->
	<%!
		int value=10;
		int cube(int n){  
			return n*n;  
		}  
	%>
	<!-- this type of code = declaration tag -->
	
	<!-- to print without out.println() -->
	<%= "Value of the variable is: " + value %> 
	<%= "Cube of 3 is: " + cube(3) %>  
	<!--  this is = expression tag -->
	
	
	<!-- Directives -->
	
	<!-- 1. page -->
	<%@ page import="java.io.BufferedReader , java.io.InputStreamReader" %>
	<!-- Attributes of JSP page directive
import -- to import libs
contentType -- to set MIME type of HTTP response
extends -- extends a class
info -- info about this jsp page -- later it will return by getServletInfo() method in servlet translation of this page
buffer -- sets the buffer size in Kb
language -- sets the lang used in this page -- default = java
isELIgnored -- EL or JSTL is ignored or not -- ignored if true
isThreadSafe -- Servlet and JSP both are multithreaded.If you want to control this behaviour of JSP page,
	you can use isThreadSafe attribute of page directive.The value of isThreadSafe value is true.If you make it false,
	the web container will serialize the multiple requests, i.e. it will wait until the JSP finishes responding to a request 
	before passing another request to it.
autoFlush 
session
pageEncoding
errorPage --we provide a link to a page that is a error page, if exception occurs in this page then control will go to that page
isErrorPage -- if true then this will be our error, we can use exception(implicit object) only in this page -->


	<!-- 2. include = to include some files -->
	<%@ include file="justAFile.jsp" %>
	
	<!-- 3. taglib = to include other tags (other than in HTML) -->
	<!-- use <prefix:tag> -->
	
	
	
	<!-- implicit objects -->
	<!-- pageContext(PageContext) -> used to set,get or remove attribute with their scopes :
		page(default)
		request
		session
		application -->
	<% pageContext.setAttribute("user","ravi",PageContext.SESSION_SCOPE); %>	<!-- we can use throughout the session -->
	<% String name=pageContext.getAttribute("user",PageContext.SESSION_SCOPE).toString(); %>
	<%= "hello" + name %>
	

	
	
</body>
</html>