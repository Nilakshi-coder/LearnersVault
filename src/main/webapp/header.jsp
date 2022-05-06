<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>

	<form action="logout" method="post">
	
		<table class="w3-table">
			<tr class="w3-pannel w3-black">
				<td><h4><b>Learning Vault</b></h4></td>
				<td class="w3-right" style="padding-top: 2%"><%=session.getAttribute("username")+":"%><b><input class="w3-btn" type="submit" value="Logout"></b></td>
			</tr>
		</table>
	</form>

</body>
</html>