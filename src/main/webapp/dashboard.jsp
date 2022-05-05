<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title>Home</title>
</head>
<body>

<c:set var="user" value=<%=request.getAttribute("username")%>/>
	<form action="logout" method="post">
	
		<table class="w3-table">
			<tr class="w3-pannel w3-black">
				<td><h4>Learning Vault Dashboard</h4></td>
				<td><c:out value="${user}"/><input type="submit" value="Logout"/></td>
			</tr>
		</table>
			
			<center>
			<table class="w3-table">
				<tr>
					<td>Click on links below to see master list</td>
				</tr>
				<tr>
					<td><a href="student">Student Details</a></td>
				</tr>
				
				<tr>
					<td><a href="course">Course Details</a></td>
				</tr>
				
				<tr>
					<td><a href="subject">Subject Details</a></td>
				</tr>
				
				<tr>
					<td><a href="teacher">Teacher Details</a></td>
				</tr>
				
			</table>
			</center>
			
		</h4>
		<br>
	</form>

</body>
</html>