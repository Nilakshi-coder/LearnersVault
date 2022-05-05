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

	<%@include file="header.jsp"%>
	<br>
	<div class="w3-container">
		<h3 style="margin-left: 20%; width: 35%; text-align: center"><b>Course Details</b></h3>
		
		<%
		List<Course> courseList = (List<Course>) request.getAttribute("courses");
		int courseCount = courseList!=null ? courseList.size(): 0;
		boolean present = courseCount > 0;
		System.out.println("SubjectCount: "+courseCount+" present: "+present);
		%>

		<c:choose>
			<c:when test="<%=present%>">
				<table class="w3-table-all" style="margin-left: 20%; width: 35%; text-align: center">
				<tr class="w3-blue">
					<th>CourseId</th>
					<th>CourseName</th>
					<th>Subjects</th>
					<th>Students</th>
				</tr>
				
				<%
				for (Course c : courseList) {
				%>
	
				<tr>
					<td><%=c.getCourseId()%></td>
					<td><%=c.getCourseName()%></td>
					
					<!-- Subject List -->
					<td>
						<form action="subject" method="get">
							<input type="hidden" name="courseId" value=<%=c.getCourseId()%>/>
							<input type="submit" value="View"/>
						</form>
					</td>
					
					<!-- Student List -->
					<td>
						<form action="student" method="get">
							<input type="hidden" value=<%=c.getCourseId()%> name="courseId"/>
							<%-- <% request.setAttribute("courseId", c.getCourseId()); %> --%>
							<input type="submit" value="View"/>
						</form>
					</td>
				</tr>
	
				<%}%>
				
				</table>
				
			</c:when>
			
			<c:otherwise>
				No subjects present.	
			</c:otherwise>
		</c:choose>
	<br>
		<b style="margin-right: 20%; width: 60%;" class="w3-right"><a href="dashboard">Back</a></b>
	</div>
	
</body>
</html>