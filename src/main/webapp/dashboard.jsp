<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>

	<form action="logout" method="post">
		<h4> 
			Welcome to Learning Vault 
			<% out.print(getServletContext().getAttribute("username")); %>
			
			<table>
				<tr>
					<td><a href="student">Student Details</a></td>
				</tr>
				
				<tr>
					<td><a href="course">Course Details</a></td>
				</tr>
				
			</table>
			
		</h4>
		<br>
		<input type="submit" value="Logout"/>
	</form>

</body>
</html>