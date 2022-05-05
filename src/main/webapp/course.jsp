<%@page import="com.learning.vault.entity.Course"%>
<%@page import="com.learning.vault.entity.Subject"%>
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
<title>Students Dashboard</title>
</head>
<body>

	<%@include file="header.jsp"%>

	<div class="w3-container">
		<h3><b>Course Details</b></h3>
		
		<%
		List<Course> courseList = (List<Course>) request.getAttribute("courses");
		int courseCount = courseList!= null ? courseList.size() : 0;
		boolean present = courseCount > 0;
		System.out.println("CourseCount: "+courseCount+" present: "+present);
		%>

		<c:choose>
			<c:when test="<%=present%>">
				<table class="w3-table-all">
				<tr class="w3-blue">
					<th>CourseId</th>
					<th>CourseName</th>
					<th>Subject</th>
					<th>Teacher</th>
				</tr>
				
				<%
				for (Course c : courseList) {
				%>
	
				<tr>
					<td><%=c.getCourseId()%></td>
					<td><%=c.getCourseName()%></td>
					<td><a href="course/showSubjects?courseId=<%=c.getCourseId()%>">View</a></td>
					<td><a href="course/showTeachers?courseId=<%=c.getCourseId()%>">View</a></td>
				</tr>
	
				<%}%>
				
				</table>
				
			</c:when>
			
			<c:otherwise>
				No Courses present.	
			</c:otherwise>
		</c:choose>
		
		<br>
		<br>
		<a href="dashboard">Back</a>
	</div>
	
</body>
</html>