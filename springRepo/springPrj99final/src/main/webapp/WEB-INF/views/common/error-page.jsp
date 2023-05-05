<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div>
		<%@ include file="/WEB-INF/views/common/header.jsp" %>
		<main>
			<h1>${requestScope.errorMsg }</h1>
		</main>
	</div>
</body>
</html>