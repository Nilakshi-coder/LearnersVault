<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.learning.vault.entity.Student"%>
<%@page import="com.learning.vault.entity.StudentDetails"%>
<%@page import="com.learning.vault.entity.Course"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored = "true" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<title>Enroll Student for course</title>
</head>
<body>

	<%@include file="header.jsp"%>
	
	<%
		Student student = (Student)request.getAttribute("student");
		List<Course> course = (List<Course>)request.getAttribute("courseList");
	%>
	
	<br>
	<br>
	<br>
	<form action="" method="get">
	<table align="center" class="w3-table w3-border" style="margin-left: 25%; width: 30%">
		<tr>
			<td class="w3-pannel w3-black" colspan="2" style="text-align: center"><b>Assign Course</b></td>
		</tr>
		<tr>	
			<th>Student Id: </th>
			<td><%=student.getStudent_id()%></td>
		</tr>
		<tr>	
			<th>FirstName: </th>
			<td><%=student.getFname()%></td>
		</tr>
		<tr>	
			<th>LastName: </th>
			<td><%=student.getLname()%></td>
		</tr>
		<tr>	
			<th>EmailAddress: </th>
			<td><%=student.getStudentDetails().getEmailAddress()%></td>
		</tr>
		<tr>	
			<th>Contact No: </th>
			<td><%=student.getStudentDetails().getContactNo()%></td>
		</tr>
		<tr>
			<th>CourseName: </th>
			<td><select name="course">
				<%for(Course c: course){ %>
					<option value=<%=c.getCourseId()%>><%=c.getCourseName()%></option>
				<%} %>
			</select>
			</td>
		</tr>
		<tr>
			<td><input class="w3-btn w3-black" type="submit" value="Save"/></td>
			<td><input class="w3-btn w3-black w3-right" type="submit" value="Cancel"/></td>
		</tr>
	</table>
	</form>

</body>
</html>