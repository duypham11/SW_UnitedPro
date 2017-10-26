<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%-- <%@ taglib prefix="b" uri="http://www.springframework.org/tags/form" %>
 --%>
<!DOCTYPE HTML>
<html>
<head>
<title>Student Profile Management</title>
</head>
<body>


<%@ include file="../fragment/header.html"  %>

<spring:url value="/admin/add_student" var="addStudentURL"/>
<a href="${addStudentURL}">Add New Student</a>

<table width = 100% border="1">
	<tr>
		<td>First Name: </td>
		<td>Last Name: </td>
		<td>Date of Birth: </td>
		<td>Email: </td>
		<td>Password: </td>

		<td colspan="2">Action</td>
	</tr>
	<c:forEach items="${student_list}" var="student">
	<tr>
		<td>${student.firstName} </td>
		<td>${student.lastName} </td>
		<td>${student.DOB} </td>
		<td>${student.email} </td>
		<td>${student.password} </td>

 		<td>
			<spring:url value="/admin/update_student/${student.student_id}" var="updateStudentURL" />
			<a href="${updateStudentURL}">Update</a>
		</td>
		<td>
			<spring:url value="/admin/delete_student/${student.student_id}" var="deleteStudentURL" />
			<a href="${deleteStudentURL}">Delete</a>
		</td>
	</tr>
	</c:forEach>
	
</table>

<%@ include file="../fragment/footer.html"%>
 </body>
</html>