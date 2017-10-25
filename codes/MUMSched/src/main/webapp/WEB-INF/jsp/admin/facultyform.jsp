<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%-- <%@ taglib prefix="b" uri="http://www.springframework.org/tags/form" %>
 --%>
<!DOCTYPE HTML>
<html>
<head>
<title>Faculty Management</title>
</head>
<body>
<spring:url value="/admin/save_faculty" var="saveFacultyURL"/>


<%@ include file="../fragment/header.html"  %>

<form:form action="${saveFacultyURL}" method="POST" modelAttribute ="facultyForm">
	<form:hidden path = "faculty_id"/>
	<table>
		<tr>
			<td>First Name: </td>
			<td><form:input path="firstName"/>
		</tr>
		<tr>
			<td>Last Name: </td>
			<td><form:input path="lastName"/>
		</tr>
		<tr>
			<td>Date of Birth: </td>
			<td><form:input path="DOB"/>
		</tr>
		<tr>
			<td>Email: </td>
			<td><form:input path="email"/>
		</tr>
		<tr>
			<td>Password: </td>
			<td><form:input path="password"/>
		</tr>		
		<tr>
			<td> </td>
			<td><button type="submit">Save</button>
		</tr>
	
	</table>
</form:form>
	

<%@ include file="../fragment/footer.html"%>
 </body>
</html>