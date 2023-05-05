<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <%
    //자바코드주석 (서비스 메소드 안에 작성)
    	String memberId = (String)request.getAttribute("memberId");
    %>
    <%//느낌표 있는 곳에 메소드 넣어줄수 있음 
    	//서비스 메소드 밖에 만들수 있음 (메소드나 변수)
    %>
    <%!
    //public void m01(){
    	
    //}
    //private String name;
    //private String age;
    
    %>
    <%//@는 설정가능 (import나 extends나 등등 속성 사용가능) 
    //지시자 태그라고 함
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- HTML주석 => 문자열이 개발자화면에 보여짐 -->
	<%--JSP 주석 =>개발자 화면에 안보임 --%>
	<h1><%= memberId %> 님 회원가입 성공</h1>
	
	<%--@ include file = "/WEB-INF/views/member/joinForm.jsp" --%>

</body>
</html>