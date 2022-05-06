<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.learning.vault.entity.Teacher"%>
<%@page import="com.learning.vault.entity.Subject"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored = "true" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<title>Assign Teacher</title>
</head>
<body>

	<%@include file="header.jsp"%>
	
	<%
		Subject subject = (Subject)request.getAttribute("subject");
		List<Teacher> teachers = (List<Teacher>)request.getAttribute("teachers");
		int teacherCount = teachers!=null ? teachers.size() : 0;
		boolean teachersFound = teacherCount>0;
	%>
	
	<br>
	<br>
	<br>
	<form action="saveSubject" method="get">
	<table align="center" class="w3-table w3-border" style="margin-left: 25%; width: 30%">
		<tr>
			<td class="w3-pannel w3-blue" colspan="2" style="text-align: center"><b>Assign Teacher</b></td>
		</tr>
		<tr>	
			<th>Subject Id: </th>
			<td><%=subject.getSubjectId()%></td>
		</tr>
		<tr>	
			<th>SubjectName: </th>
			<td><%=subject.getSubjectName()%></td>
		</tr>
		<tr>
			<th>TeacherName: </th>
			<td><select name="teacherId">
				<%for(Teacher t: teachers){ %>
					<option value=<%=t.getTeacherId()%>><%=t.getTeacherName()%></option>
				<%} %>
			</select>
			</td>
		</tr>
		<tr>
		<table align="center" class="w3-table" style="margin-left: 25%; width: 30%">
			<c:if test="<%=subject!=null%>">
				<input type="hidden" value=<%=subject.getSubjectId()%> name="subjectId"/>
				<td><input class="w3-btn w3-green" type="submit" value="Update" name="action"/></td>
				<td><input class="w3-btn w3-green" type="submit" value="Delete" name="action"/></td>
			</c:if>
			<% String cancelRef = "teacher?subjectId="+subject.getSubjectId(); %>
			<td><a href=<%=cancelRef%>><input class="w3-btn w3-green w3-right" type="button" value="Cancel" name="Cancel"/></a></td>
		</table>
		</tr>
	</table>
	</form>

</body>
</html>