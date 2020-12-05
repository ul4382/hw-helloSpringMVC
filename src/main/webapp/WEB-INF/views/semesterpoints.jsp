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
<h1>학년/학기별 이수 총 학점</h1>>

<table border="1">
		<tbody>
		
		<thead>
			<tr align="center">
				<th>년도</th>
				<th>학기</th>
				<th>취득 학점</th>
				<th>상세보기</th>
			</tr>
		</thead>
		
<c:forEach var="course" items="${courses}">
	<tr align="center">
	<td>${course.year}</td>
	<td>${course.semester}</td>
	<td>${course.point}</td>
	<td><a href="${pageContext.request.contextPath}/yearsemester?year=${course.year}&semester=${course.semester}">링크</a></td>
	</tr>
	
</c:forEach>
		<tfoot>
		<tr><th>총계</th><th></th><th>${course.point}</th></tr>
		</tfoot>
</tbody>
</table>	
	
</body>
</html>