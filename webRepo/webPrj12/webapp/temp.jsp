<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	System.out.println("test");
	
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	
	System.out.println(id);
	System.out.println(pwd);
	
	
	%>
	<h1>join success</h1>
	
</body>
</html>