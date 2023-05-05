<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
<%
	String alertMsg = (String)session.getAttribute("alertMsg");
	session.removeAttribute("alertMsg");
	
	if(alertMsg != null){%>
		alert('<%=alertMsg %>');
<%	}
%>
	
</script>
</head>
<body>

	<h1>메인화면</h1>
	
    <%
    	String nick = (String)session.getAttribute("nick");
    	
    	if(nick != null){ %>
		<h2><%=nick %> 님 환영합니다.</h2>
		<a href="/app21/member/logout">로그아웃</a>
		<button onclick="location.href = '/app21/member/logout'">로그아웃</button>
    		<% 
    	}else{%>
    	<h2>로그인을 해주세요</h2>
    	<%} 
    %>
	
	<ol>
		<li><a href="/app21/member/join">회원가입</a></li>
		<li><a href="/app21/member/login">로그인</a></li>
		<li><a href="회원가입요청보낼경로">정보수정</a></li>
		<li><a href="회원가입요청보낼경로">삭제</a></li>
		
	</ol>
	
	
	
</body>
</html>