<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.learning.vault.entity.Subject"%>
<%@page import="com.learning.vault.entity.Course"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored = "true" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<title>Assign Subject</title>
</head>
<body>

	<%@include file="header.jsp"%>
	
	<%
		Course course = (Course)request.getAttribute("course");
		List<Subject> subjects = (List<Subject>)request.getAttribute("subjects");
		int subjectsCount = subjects!=null ? subjects.size() : 0;
		boolean subjectsFound = subjectsCount>0;
	%>
	
	<br>
	<br>
	<br>
	<form action="saveCourse" method="post">
	<table align="center" class="w3-table w3-border" style="margin-left: 25%; width: 30%">
		<tr>
			<td class="w3-pannel w3-blue" colspan="2" style="text-align: center"><b>Assign Subject</b></td>
		</tr>
		<tr>	
			<th>CourseId: </th>
			<td><%=course.getCourseId()%></td>
		</tr>
		<tr>	
			<th>CourseName: </th>
			<td><%=course.getCourseName()%></td>
		</tr>
		<tr>
			<th>SubjectName: </th>
			<td><select name="subjectId">
				<%for(Subject s: subjects){ %>
					<option value=<%=s.getSubjectId()%>><%=s.getSubjectName()%></option>
				<%} %>
			</select>
			</td>
		</tr>
		<tr>
		<table align="center" class="w3-table" style="margin-left: 25%; width: 30%">
			<c:if test="<%=course!=null%>">
				<input type="hidden" value=<%=course.getCourseId()%> name="courseId"/>
				<td><input class="w3-btn w3-green" type="submit" value="Update" name="action"/></td>
				<td><input class="w3-btn w3-green" type="submit" value="Delete" name="action"/></td>
			</c:if>
			<% String cancelRef = "subject?courseId="+course.getCourseId(); %>
			<td><a href=<%=cancelRef%>><input class="w3-btn w3-green w3-right" type="button" value="Cancel" name="Cancel"/></a></td>
		</table>
		</tr>
	</table>
	</form>

</body>
</html>