<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<div id="wrapper">
		<%@ include file="/WEB-INF/views/common/header.jsp" %>


	    <form action="/member/join" method="post">
	        아이디<input type="text" name="memberId">
	        <br>
	        패스워드<input type="password" name="memberPwd">
	        <br>
	        닉네임<input type="text" name="memberNick">
	        <br>
	        게임<input type="checkbox" name="hobby" value="game">
	        코딩<input type="checkbox" name="hobby" value="coding">
	        운동<input type="checkbox" name="hobby" value="workout">
	        <br>
	        <input type="submit" value="회원가입">
	    </form>

    </div>

</body>
</html>