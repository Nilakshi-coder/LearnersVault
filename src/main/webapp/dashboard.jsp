<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title>Home</title>
</head>
<body>

	<%@include file="header.jsp"%>

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

</body>
</html>