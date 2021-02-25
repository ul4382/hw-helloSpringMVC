<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>학기별 수강 내역</h1>>

<table border="1">
		<tbody>
		<thead>
			<tr align="center">
				<th>년도</th>
				<th>학기</th>
				<th>교과목명</th>
				<th>교과구분</th>
				<th>담당교수</th>
				<th>학점</th>
			</tr>
		</thead>
		
<c:forEach var="course" items="${courses}">
	<tr align="center">
	<td>${course.year}</td>
	<td>${course.semester}</td>
	<td>${course.title}</td>
	<td>${course.type}</td>
	<td>${course.professor}</td>
	<td>${course.point}</td>
	</tr>
</c:forEach>
</tbody>
</table>	
	
</body>
</html>