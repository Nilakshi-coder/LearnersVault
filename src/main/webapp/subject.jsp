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
	
	<%
		List<Subject> subjectList = (List<Subject>) request.getAttribute("subjects");
		int subjectCount = subjectList!=null ? subjectList.size(): 0;
		boolean present = subjectCount > 0;
		System.out.println("SubjectCount: "+subjectCount+" present: "+present);
		String courseName = (String)request.getAttribute("courseName");
	%>
	
	<br>
	<div class="w3-container">
		<h3 style="margin-left: 20%; width: 25%; text-align: center">
			<b>
				Subject Details
				
				<c:if test="<%=courseName!=null%>">
					for <%=courseName%> 
				</c:if>
			</b>
		</h3>

		<c:choose>
			<c:when test="<%=present%>">
				<table class="w3-table-all" style="margin-left: 20%; width: 25%; text-align: center">
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
				<span style="margin-left: 20%; width: 25%; text-align: center">No subjects present</span>	
			</c:otherwise>
		</c:choose>
		<br>
		<b style="margin-left: 20%; width: 25%; text-align: center"><a href="dashboard">Back</a></b>
	</div>
	
</body>
</html>