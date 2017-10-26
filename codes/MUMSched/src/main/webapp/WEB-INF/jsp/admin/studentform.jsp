<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%-- <%@ taglib prefix="b" uri="http://www.springframework.org/tags/form" %>
 --%>
<!DOCTYPE HTML>
<html>
<head>
<title>Student Management</title>
</head>
<body>
<spring:url value="/admin/save_student" var="saveStudentURL"/>


<%@ include file="../fragment/header.html"  %>

<form:form action="${saveStudentURL}" method="POST" modelAttribute ="studentForm">
	<form:hidden path = "student_id"/>
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
			<td><form:input type="date" path="DOB"/>
		</tr>
		<tr>
			<td>Email: </td>
			<td><form:input path="email"/>
		</tr>
		<tr>
			<td>Password: </td>
			<td><form:input type="password" path="password"/>
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