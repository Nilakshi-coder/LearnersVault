<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<title>Login</title>
</head>
<body>
	
	<c:if test="${not empty loginError}">
		<div class="w3-panel w3-red">
	  	<p>${loginError}</p>
		</div> 
	</c:if>
	

	<div class="w3-container w3-center">
	<form action="loginServlet" method="post">
	
	<center>
	<h3 style="padding: 1%;"><b>Login to Learning Vault</b></h3>
		
		<table class="w3-border w3-gray" style="padding: 1%">
			
			<tr> 
				<td style="padding: 1%;margin: 1%"> <p> Username: </p> </td>
				<td style="padding: 1%;margin: 1%"> <input type="text" name="username"/> </td>
			</tr>
			
			<tr>
				<td style="padding: 1%;margin: 1%"> <p> Password: </p> </td>
				<td style="padding: 1%;margin: 1%"> <input type="password" name="password" /> </td>
			</tr>
			
			<tr>
				<td colspan="2" align="center" style="padding: 1%;"> <p><input class="w3-btn w3-black " type="submit" value="Login"/></p> </td>
			</tr>
		</table>
	</center>
	
	</form>
	</div>
	
</body>
</html>
