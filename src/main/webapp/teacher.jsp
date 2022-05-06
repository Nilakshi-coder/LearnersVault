<%@page import="com.learning.vault.entity.Teacher"%>
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
<title>Teacher Dashboard</title>
</head>
<body>

	<%@include file="header.jsp"%>
	
	<%
		List<Teacher> teachersList = (List<Teacher>) request.getAttribute("teachers");
		int teacherCount = teachersList!=null ? teachersList.size() : 0;
		boolean present = teacherCount > 0;
		System.out.println("TeacherCount: "+teacherCount+" present: "+present);
		
		int subject = -1;
		if(request.getAttribute("subjectId")!=null){
		 subject = (Integer)request.getAttribute("subjectId");
		}
		String subjectName = (String)request.getAttribute("subjectName");
		String successMsg = (String)request.getAttribute("success");
		boolean messageFound = successMsg==null ? false : true;
	%>
	
	<br>

	<div class="w3-container">
		<h3 style="margin-left: 20%; width: 30%; text-align: center">
		<b>
			Teacher Details
			<c:if test="<%=subjectName!=null%>">
					for <%=subjectName%> 
			</c:if>
		</b>
		</h3>

		<c:choose>
			<c:when test="<%=present%>">
				<table class="w3-table-all" style="margin-left: 20%; width: 30%;">
				<tr class="w3-blue">
					<th>TeacherId</th>
					<th>TeacherName</th>
				</tr>
				
				<%
				for (Teacher t : teachersList) {
				%>
	
				<tr>
					<td><%=t.getTeacherId()%></td>
					<td><%=t.getTeacherName()%></td>
					
				</tr>
	
				<%}%>
				
				</table>
				
			</c:when>
			
			<c:otherwise>
				<span style="margin-left: 20%; width: 25%; text-align: center; color:red">No Teachers present.</span>
			</c:otherwise>
		</c:choose>
		<b style="margin-right: 20%; width: 60%;" class="w3-right">

		<c:choose>
			<c:when test="<%=subjectName!=null%>">

					<c:choose>
						<c:when test="<%=messageFound%>">
							<span style="text-decoration: green"><%=successMsg%></span>
						</c:when>
						<c:otherwise>
							<br>
						</c:otherwise>
					</c:choose>

					<form action="addSubjectForTeacher"  method="get">
					<input type="hidden" value=<%=subject%> name="subjectId" />
					<input type="hidden" value=<%=subject%> name="subjectId" />		
					<input type="hidden" value=<%=subject%> name="subjectId" />
					<input class="w3-button w3-green" type="submit" value="Assign Teacher"/>	
					<br><br>		
				</form>
				<a href="subject">Back</a>
			</c:when>
			<c:otherwise>
				<a href="dashboard">Back</a>
			</c:otherwise>
		</c:choose>
		</b>
	</div>
	
</body>
</html>