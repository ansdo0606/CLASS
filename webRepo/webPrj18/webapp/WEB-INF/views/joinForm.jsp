<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<a href="/app18">메인화면으로 이동</a>
	
	<h1>회원가입</h1>
	
	<form action="/app18/member/join" method = "post">
		아이디 : <input type = "text" name = "memberId">
		<br>
		패스워드 : <input type = "password" name = "memberPwd">
		<br>
		<input type = "submit" value = "회원가입">
		
	</form>
</body>
</html>