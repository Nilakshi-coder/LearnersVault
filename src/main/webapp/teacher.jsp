<%@page import="com.learning.vault.entity.Teacher"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored = "true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title>Teacher Dashboard</title>
</head>
<body>

	<%@include file="header.jsp"%>

	<div class="w3-container">
		<h3 style="margin-left: 20%; width: 30%; text-align: center"><b>Teacher Details</b></h3>
		
		<%
		List<Teacher> teachersList = (List<Teacher>) request.getAttribute("teachers");
		int teacherCount = teachersList.size();
		boolean present = teacherCount > 0;
		System.out.println("SubjectCount: "+teacherCount+" present: "+present);
		%>

		<c:choose>
			<c:when test="<%=present%>">
				<table class="w3-table-all" style="margin-left: 20%; width: 30%;">
				<tr class="w3-blue">
					<th>TeacherId</th>
					<th>TeacherName</th>
				</tr>
				
				<%
				for (Teacher t : teachersList) {
				%>
	
				<tr>
					<td><%=t.getTeacherId()%></td>
					<td><%=t.getTeacherName()%></td>
				</tr>
	
				<%}%>
				
				</table>
				
			</c:when>
			
			<c:otherwise>
				No students present.	
			</c:otherwise>
		</c:choose>
		<br>
		<b style="margin-right: 20%; width: 60%;" class="w3-right"><a href="dashboard">Back</a></b>
	</div>
	
</body>
</html>