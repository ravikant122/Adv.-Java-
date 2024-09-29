<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<!-- one way to access attribute -->
	<%
		String name=request.getAttribute("name").toString();
		out.println(name);
	%>
	
	<!-- another way -->
	${name}
</body>
</html>