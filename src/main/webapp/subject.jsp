<%@page import="com.learning.vault.entity.Subject"%>
<%@page import="com.learning.vault.entity.Teacher"%>
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
		Teacher teacher = (Teacher) request.getAttribute("teacher");
		String teacherName = teacher!=null?teacher.getTeacherName():null;
	%>
	
	<br>
	<div class="w3-container">
		<h3 style="margin-left: 20%; width: 25%; text-align: center">
			<b>
				Subject Details
				
				<c:if test="<%=courseName!=null%>">
					for <%=courseName%> 
				</c:if>
				<c:if test="<%=teacherName!=null%>">
					for <%=teacherName%> 
				</c:if>
			</b>
		</h3>

		<c:choose>
			<c:when test="<%=present%>">
				<table class="w3-table-all" style="margin-left: 20%; width: 25%; text-align: center">
				<tr class="w3-blue">
					<th>SubjectId</th>
					<th>SubjectName</th>
					<th>Teachers</th>
				</tr>
				
				<%
				for (Subject s : subjectList) {
				%>
	
				<tr>
					<td><%=s.getSubjectId()%></td>
					<td><%=s.getSubjectName()%></td>
					
					<!-- Teacher List -->
					<td>
						<form action="teacher" method="get">
							<input type="hidden" value=<%=s.getSubjectId()%> name="subjectId"/>
							<input type="submit" value="View"/>
						</form>
					</td>
				</tr>
	
				<%}%>
				
				</table>
				
			</c:when>
			
			<c:otherwise>
				<span style="margin-left: 20%; width: 25%; text-align: center; color:red">
					<c:choose>
						<c:when test="<%=(teacherName!=null || courseName!=null)%>">
							Subjects not assigned!
						</c:when>
						<c:otherwise>
							Subjects not present!
						</c:otherwise>	
					</c:choose>
					<br>			
				</span>	
			</c:otherwise>
		</c:choose>
		<br>
		<b style="margin-left: 20%; width: 25%; text-align: center">
		<c:choose>
			<c:when test="<%=teacherName!=null%>">
				<a href="teacher">
			</c:when>
			<c:when test="<%=courseName!=null%>">
				<a href="course">
			</c:when>
			<c:otherwise>
				<a href="dashboard">
			</c:otherwise>
		</c:choose>
			Back
		</a></b>
		
	</div>
	
</body>
</html>