<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<div id="wrapper">
		<%@ include file="/WEB-INF/views/common/header.jsp" %>

		제목<input type="text" value="${boardVo.title}" readonly>
		작성자<input type="text" value="${boardVo.writer}" readonly>
		작성일시<span>${boardVo.enrollDate}</span>
		<br>
		내용<textarea readonly>${boardVo.content}</textarea>
		
		<a download href ="/resources/IMG/${boardVo.changeName }" >파일 다운로드</a>
		<img alt="게시글 이미지" src="/resources/IMG/${boardVo.changeName }">
	</div>
		
</body>
</html>