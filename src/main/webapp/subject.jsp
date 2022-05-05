<%@page import="com.learning.vault.entity.Subject"%>
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

	<div class="w3-container">
		<h3><b>Subject Details</b></h3>
		
		<%
		List<Subject> subjectList = (List<Subject>) request.getAttribute("subjectList");
		int subjectCount = subjectList.size();
		boolean present = subjectCount > 0;
		System.out.println("SubjectCount: "+subjectCount+" present: "+present);
		%>

		<c:choose>
			<c:when test="<%=present%>">
				<table class="w3-table-all">
				<tr class="w3-blue">
					<th>SubjectId</th>
					<th>SubjectName</th>
				</tr>
				
				<%
				for (Subject s : subjectList) {
				%>
	
				<tr>
					<td><%=s.getSubjectId()%></td>
					<td><%=s.getSubjectName()%></td>
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