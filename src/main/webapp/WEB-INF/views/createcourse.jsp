<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	 href="${pageContext.request.contextPath}/resources/css/main.css">
</head>
<body>

	<sf:form method="post" action="${pageContext.request.contextPath}/docreate" modelAttribute="course">
	<table class="formtable">
	<tr><td class="label"> 년도: </td> <td> <sf:input class="control" type="text" path="year"/></td></tr>
	<tr><td class="label"> 학기: </td> <td> <sf:input class="control"  type="text" path="semester"/></td></tr>
	<tr><td class="label"> 교과목명: </td> 
	<td> <sf:input class="control" type="text" path="title"/><br/>
		<sf:errors path="title" class="error"/></td></tr>
	<tr><td class="label"> 교과구분: </td> <td> <sf:input class="control" type="text" path="type"/></td></tr>
	<tr><td class="label"> 담당교수: </td> <td> <sf:input class="control" type="text" path="professor"/></td></tr>
	<tr><td class="label"> 학점: </td> <td> <sf:input class="control" type="text" path="point"/></td></tr>
	<tr><td></td><td><input type="submit" value="새 제안"/></td></tr>
	</table>
	
	</sf:form>
</body>
</html>