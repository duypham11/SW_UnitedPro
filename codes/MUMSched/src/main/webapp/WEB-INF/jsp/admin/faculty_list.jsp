<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%-- <%@ taglib prefix="b" uri="http://www.springframework.org/tags/form" %>
 --%>
<!DOCTYPE HTML>
<html>
<head>
<title>Faculty Profile Management</title>
</head>
<body>


<%@ include file="../fragment/header.html"  %>

<spring:url value="/admin/add_faculty" var="addFacultyURL"/>
<a href="${addFacultyURL}">Add New Faculty</a>

<table width = 100% border="1">
	<tr>
		<td>First Name: </td>
		<td>Last Name: </td>
		<td>Date of Birth: </td>
		<td>Email: </td>
		<td>Password: </td>

		<td colspan="2">Action</td>
	</tr>
	<c:forEach items="${faculty_list}" var="faculty">
	<tr>
		<td>${faculty.firstName} </td>
		<td>${faculty.lastName} </td>
		<td>${faculty.DOB} </td>
		<td>${faculty.email} </td>
		<td>${faculty.password} </td>

 		<td>
			<spring:url value="/admin/update_faculty/${faculty.faculty_id}" var="updateFacultyURL" />
			<a href="${updateFacultyURL}">Update</a>
		</td>
		<td>
			<spring:url value="/admin/delete_faculty/${faculty.faculty_id}" var="deleteFacultyURL" />
			<a href="${deleteFacultyURL}">Delete</a>
		</td>
	</tr>
	</c:forEach>
	
</table>

<%@ include file="../fragment/footer.html"%>
 </body>
</html>