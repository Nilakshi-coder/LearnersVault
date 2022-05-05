<%@page import="com.learning.vault.entity.Student"%>
<%@page import="com.learning.vault.entity.StudentDetails"%>
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
		<h3><b>Students Details</b></h3>
		
		<%
		List<Student> studentList = (List<Student>) request.getAttribute("studentList");
		int studentCount = studentList.size();
		boolean present = studentCount > 0;
		System.out.println("StudentCount: "+studentCount+" present: "+present);
		%>

		<c:choose>
			<c:when test="<%=present%>">
				<table class="w3-table-all">
				<tr class="w3-blue">
					<th>StudentId</th>
					<th>FirstName</th>
					<th>LastName</th>
					<th>Email Address</th>
					<th>Contact Number</th>
					<th>Course</th>
				</tr>
				
				<%
				for (Student std : studentList) {
				%>
	
				<tr>
					<td><%=std.getStudent_id()%></td>
					<td><%=std.getFname()%></td>
					<td><%=std.getLname()%></td>
	
					<%StudentDetails stdDtl = std.getStudentDetails();
						if (stdDtl != null) { %>
					<td><%=stdDtl.getEmailAddress()%></td>
					<td><%=stdDtl.getContactNo()%></td>
					<%} else {%>
					<td>NOTSET</td>
					<td>NOTSET</td>
					<%}%>
					
					<%Course course = std.getCourse();
						if (course != null) { %>
					<td><%=course.getCourseName()%></td>
					<%} else {%>
					<td><a href="add-course">click here to add course</a></td>
					<%}%>
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