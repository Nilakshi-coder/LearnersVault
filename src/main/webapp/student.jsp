<%@page import="com.learning.vault.entity.Student"%>
<%@page import="com.learning.vault.entity.StudentDetails"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Students Dashboard</title>
</head>
<body>

	<%List<Student> studentList = (List<Student>)request.getAttribute("studentList");
		int studentCount = studentList.size();
		//System.out.println("Students: "+studentCount);
	%>

	<h3>Students Details</h3>
	<c:out value="${studentList}"></c:out>

	<%
		if(studentCount>0){
	%>
	<table>
		<tr>
			<th>StudentId</th>
			<th>FirstName</th>
			<th>LastName</th>
			<th>Email Address</th>
			<th>Contact Number</th>
		</tr>

		<% 
		for (Student std : studentList) {
		%>

		<tr>
			<td><%=std.getStudent_id()%></td>
			<td><%=std.getFname()%></td>
			<td><%=std.getLname()%></td>
			
			<% StudentDetails stdDtl = std.getStudentDetails(); %>
			<%
				if(stdDtl!=null){
			%>
				<td><%=stdDtl.getEmailAddress()%></td>
				<td><%=stdDtl.getContactNo()%></td>
			<%} else { %>
				<td>NOTSET</td>
				<td>NOTSET</td>
			<%} %>
		</tr>

		<% } %>
	</table>
	<% } else { %>
	No students present.
	<%} %>

</body>
</html>