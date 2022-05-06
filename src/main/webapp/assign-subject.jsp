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
		Teacher teacher = (Teacher)request.getAttribute("teacher");
		List<Subject> subjects = (List<Subject>)request.getAttribute("subjects");
	%>
	
	<br>
	<br>
	<br>
	<form action="subject" method="get">
	<table align="center" class="w3-table w3-border" style="margin-left: 25%; width: 30%">
		<tr>
			<td class="w3-pannel w3-black" colspan="2" style="text-align: center"><b>Assign Subject</b></td>
		</tr>
		<tr>	
			<th>Teacher Id: </th>
			<td><%=teacher.getTeacherId()%></td>
		</tr>
		<tr>	
			<th>TeacherName: </th>
			<td><%=teacher.getTeacherName()%></td>
		</tr>
		<tr>
			<th>SubjectName: </th>
			<td><select name="subject">
				<%for(Subject s: subjects){ %>
					<option value=<%=s.getSubjectId()%>><%=s.getSubjectName()%></option>
				<%} %>
			</select>
			</td>
		</tr>
		<tr>
			<c:if test="<%=teacher!=null%>">
				<input type="hidden" value=<%=teacher.getTeacherId()%> name="teacherId"/>
			</c:if>
			<td><input class="w3-btn w3-black" type="submit" value="Save" name="Save"/></td>
			<td><input class="w3-btn w3-black w3-right" type="submit" value="Cancel" name="Cancel"/></td>
		</tr>
	</table>
	</form>

</body>
</html>