<%@page import="com.learning.vault.entity.Student"%>
<%@page import="com.learning.vault.entity.StudentDetails"%>
<%@page import="com.learning.vault.entity.Course"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored = "true" %>
<%@ page session="true" %>
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
		<h3 style="margin-left: 20%; width: 60%; text-align: center"><b>Students Details</b></h3>
				
		<%
		List<Student> studentList = (List<Student>) request.getAttribute("students");
		int studentCount = studentList.size();
		boolean present = studentCount > 0;
		System.out.println("StudentCount: "+studentCount+" present: "+present);
		%>
		
		<c:choose>
			<c:when test="<%=present%>">
				<table class="w3-table-all" style="margin-left: 20%; width: 60%">
				<tr class="w3-blue">
					<th>StudentId</th>
					<th>FirstName</th>
					<th>LastName</th>
					<th>Email Address</th>
					<th>Contact Number</th>
					<!-- <th>Course</th> -->
				</tr>
				
				<% for (Student std : studentList) { %>
					<form action="enrollStudent" method="get">
						<tr>
							<td><%=std.getStudent_id()%></td>
							<td><%=std.getFname()%></td>
							<td><%=std.getLname()%></td>
							
							<%StudentDetails stdDtl = std.getStudentDetails();%>
							
							<c:choose>
								<c:when test="<%= (stdDtl != null) %>">
									<td><%=stdDtl.getEmailAddress()%></td>
									<td><%=stdDtl.getContactNo()%></td>
								</c:when>

								<c:otherwise>
									<td>NOTSET</td>
									<td>NOTSET</td>
								</c:otherwise>
							</c:choose>
							
							<%-- <%Course course = std.getCourse(); %>
							
							<c:choose>
								<c:when test="<%= (course != null) %>">
									<td><%=course.getCourseName()%></td>
								</c:when>

								<c:otherwise>
									<input type="hidden" value="<%=std.getStudent_id()%>" name="student"/>
									<td><input type="submit" value="Assign Course"/></td>
								</c:otherwise>
							</c:choose> --%>
						</tr>
					</form>
				<% } %>
					
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