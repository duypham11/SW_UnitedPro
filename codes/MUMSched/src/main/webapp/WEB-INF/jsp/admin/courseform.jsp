<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%-- <%@ taglib prefix="b" uri="http://www.springframework.org/tags/form" %>
 --%>
<!DOCTYPE HTML>
<html>
<head>
<title>Course Management</title>
</head>
<body>
<spring:url value="/admin/save_course" var="saveCourseURL"/>


<%@ include file="../fragment/header.html"  %>

<form:form action="${saveCourseURL}" method="POST" modelAttribute ="courseForm">
	<form:hidden path = "course_id"/>
	<%-- <form:hidden path = "faculty.faculty_id"/> --%>
	<table>
		<tr>
			<td>Course Code: </td>
			<td><form:input path="courseCode"/>
		</tr>
		<tr>
			<td>Course Name: </td>
			<td><form:input path="courseName"/>
		</tr>
		<tr>
			<td>Course Description: </td>
			<td><form:input path="courseDescription"/>
		</tr>		

		<%-- <tr>
			<td>Faculty: </td> 
 			<td>
			<form:select path="faculty" modelAttribute ="faculty">
			<form:option value="0 "> --SELECT--</form:option>
			<form:options items="${facultyList}" itemValue="faculty_id" itemLabel="facultyName"/>
			</form:select>
			</td>	
		</tr> --%>
		<tr>
			<td> </td>
			<td><button type="submit">Save</button>
		</tr>
	
	</table>
</form:form>
	

<%@ include file="../fragment/footer.html"%>
 </body>
</html>