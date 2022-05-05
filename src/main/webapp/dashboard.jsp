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
	
	<br>
	<br>

	<%-- <center> --%>
	<div class="w3-container w3-center" style="margin-left: 25%; margin-right: 25%; width: 30%">
		<h3><b>Vault Dashboard</b></h3>
		<h5 style="color:grey"><i>Click on links below to see the master list</i></h5>
		<table class="w3-table">
			
			<tr>
				<td class="w3-center"><a href="student">Student Details</a></td>
			</tr>

			<tr>
				<td class="w3-center"><a href="course">Course Details</a></td>
			</tr>

			<tr>
				<td class="w3-center"><a href="subject">Subject Details</a></td>
			</tr>

			<tr>
				<td class="w3-center"><a href="teacher">Teacher Details</a></td>
			</tr>

		</table>
	<%-- </center> --%>
	</div>

	<br>

</body>
</html>