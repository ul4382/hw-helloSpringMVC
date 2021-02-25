<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<title>Home</title>
</head>
<body>

	<p><a href="${pageContext.request.contextPath}/semesterpoints">학기별 이수 학점 조회</a></p>
	<p><a href="${pageContext.request.contextPath}/createcourse">수강 신청하기</a></p>
	<p><a href="${pageContext.request.contextPath}/courselist">수강 신청 조회</a></p>
</body>
</html>
