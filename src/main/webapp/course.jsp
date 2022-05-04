<%@page import="com.learning.vault.entity.Course"%>
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

	<div class="w3-container">
		<h3><b>Course Details</b></h3>
		
		<%
		List<Course> courseList = (List<Course>) request.getAttribute("courseList");
		int courseCount = courseList.size();
		boolean present = courseCount > 0;
		System.out.println("CourseCount: "+courseCount+" present: "+present);
		%>

		<c:choose>
			<c:when test="<%=present%>">
				<table class="w3-table-all">
				<tr class="w3-blue">
					<th>CourseId</th>
					<th>CourseName</th>
				</tr>
				
				<%
				for (Course c : courseList) {
				%>
	
				<tr>
					<td><%=c.getCourseId()%></td>
					<td><%=c.getCourseName()%></td>
				</tr>
	
				<%}%>
				
				</table>
				
			</c:when>
			
			<c:otherwise>
				No students present.	
			</c:otherwise>
		</c:choose>
	</div>
	
</body>
</html>